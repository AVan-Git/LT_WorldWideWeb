package edu.vn.iuh.fit.ws.chat.gui;

import edu.vn.iuh.fit.ws.chat.server.Message;
import edu.vn.iuh.fit.ws.chat.server.MessageDecoder;
import edu.vn.iuh.fit.ws.chat.server.MessageEncoder;
import jakarta.websocket.*;

import javax.swing.*;
import java.net.URI;

@ClientEndpoint(
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class ChatClient {
    private Session session;
    private WebSocketContainer container;

    private String wsURL;
    private String nickName;
    private JTextArea taContent;

    public ChatClient(String wsURL, String nickName, JTextArea taContent) throws Exception {
        this.wsURL = wsURL;
        this.nickName = nickName;
        this.taContent = taContent;
        container = ContainerProvider.getWebSocketContainer();
//        URI uri = new URI("ws://localhost:8080/helloworld/chat/coi");
        if (!wsURL.endsWith("/"))
            wsURL += "/";
        URI uri = new URI(wsURL + nickName);
        container.connectToServer(this, uri);
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig configuration) {
        this.session = session;
        session.addMessageHandler(new MessageHandler.Whole<Message>() {
            @Override
            public void onMessage(Message message) {
                taContent.append(message.getFrom() + ": " + message.getContent() + "\n");
            }
        });
    }

    @OnError
    public void onError(Session session, Throwable thr) {
        JOptionPane.showMessageDialog(null, "Error communicating with peer " + session.getId() + ". Detail: " + thr.getMessage());
    }

    public void sendMessage(Message message) {
        try {
            session.getBasicRemote().sendObject(message);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.printf("Session %s close because of %s", session.getId(), closeReason);
    }

    public void close() throws Exception {
        session.close();
    }

}
