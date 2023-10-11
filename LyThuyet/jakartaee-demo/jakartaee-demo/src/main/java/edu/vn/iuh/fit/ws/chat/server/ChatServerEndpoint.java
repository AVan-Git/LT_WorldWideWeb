package edu.vn.iuh.fit.ws.chat.server;

import jakarta.websocket.*;
import jakarta.websocket.server.PathParam;
import jakarta.websocket.server.ServerEndpoint;

import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

@ServerEndpoint(value = "/chat/{username}",
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class ChatServerEndpoint {
    private static final Logger logger = Logger.getLogger(ChatServerEndpoint.class.getName());

    private static final Set<ChatServerEndpoint> chatEndpoints = new HashSet<>();
    private static final HashMap<String, String> users = new HashMap<>();
    private Session session;

    private static void sendTo(Message message){
        String to = message.getTo();
        if(to!=null){
            chatEndpoints.forEach(endpoint -> {
                synchronized (endpoint) {
                    try {
                        String us = users.get(endpoint.session.getId());
                        if(to.equalsIgnoreCase(us))
                            endpoint.session.getBasicRemote().sendObject(message);
                    } catch (Exception e) {
                        logger.log(Level.SEVERE, e.getMessage());
                    }
                }
            });
        }
    }

    private static void broadcast(Message message)
            throws IOException, EncodeException {
        chatEndpoints.forEach(endpoint -> {
            synchronized (endpoint) {
                try {
                    if(message.getTo()==null)
                        endpoint.session.getBasicRemote().sendObject(message);
                    else{
                        String us = users.get(endpoint.session.getId());
                        if (!message.getTo().equalsIgnoreCase(us))
                            endpoint.session.getBasicRemote().sendObject(message);
                    }
                } catch (IOException | EncodeException e) {
                    logger.log(Level.SEVERE, e.getMessage());
                }
            }
        });
    }

    @OnOpen
    public void onOpen(Session session, @PathParam("username") String username)
            throws IOException, EncodeException {
        this.session = session;
        chatEndpoints.add(this);
        users.put(session.getId(), username);

        Message message = new Message();
        message.setFrom(username);
        message.setContent("Connected!");
        broadcast(message);
    }

    @OnMessage
    public void onMessage(Session session, Message message)
            throws IOException, EncodeException {
        message.setFrom(users.get(session.getId()));
        if(message.getTo()!=null)
            sendTo(message);
        else
            broadcast(message);
    }

    @OnClose
    public void onClose(Session session) throws IOException, EncodeException {
        chatEndpoints.remove(this);
        Message message = new Message();
        message.setFrom(users.get(session.getId()));
        message.setContent("Disconnected!");
        broadcast(message);
    }

    @OnError
    public void onError(Session session, Throwable throwable) {
        // Do error handling here
    }

}