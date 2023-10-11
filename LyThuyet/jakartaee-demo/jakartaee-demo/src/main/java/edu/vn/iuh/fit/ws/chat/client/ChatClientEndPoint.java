package edu.vn.iuh.fit.ws.chat.client;

import edu.vn.iuh.fit.ws.chat.server.Message;
import edu.vn.iuh.fit.ws.chat.server.MessageDecoder;
import edu.vn.iuh.fit.ws.chat.server.MessageEncoder;
import jakarta.websocket.*;

import java.io.IOException;
import java.net.URI;

@ClientEndpoint(
        decoders = MessageDecoder.class,
        encoders = MessageEncoder.class)
public class ChatClientEndPoint {
    private Session session;

    public ChatClientEndPoint() throws Exception {
        WebSocketContainer container = ContainerProvider.getWebSocketContainer();
        URI uri = new URI("ws://localhost:8080/helloworld/chat/coi");
        container.connectToServer(this, uri);
    }

    @OnOpen
    public void onOpen(Session session, EndpointConfig configuration) {
//        System.out.printf("Client on open");
        this.session = session;
        session.addMessageHandler(new MessageHandler.Whole<String>() {
            @Override
            public void onMessage(String message) {
                System.out.println("\t---Received from server: " + message);
            }
        });
    }

    @OnError
    public void onError(Session session, Throwable thr) {
        System.err.println("Error communicating with peer " + session.getId() + ". Detail: " + thr.getMessage());
    }

    public void sendMessage(Message message) throws Exception{
            session.getBasicRemote().sendObject(message);
    }

    @OnClose
    public void onClose(Session session, CloseReason closeReason) {
        System.out.printf("Session %s close because of %s", session.getId(), closeReason);
    }
}
