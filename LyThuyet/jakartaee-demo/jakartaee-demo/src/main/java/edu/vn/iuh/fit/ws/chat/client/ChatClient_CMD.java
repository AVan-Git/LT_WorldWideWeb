package edu.vn.iuh.fit.ws.chat.client;

import edu.vn.iuh.fit.ws.chat.server.Message;

import java.util.Scanner;

public class ChatClient_CMD {

    public static void main(String[] args) throws Exception {
        ChatClientEndPoint client = new ChatClientEndPoint();


        Message msg2 = new Message("coi", "men", "Coi chao men");
        client.sendMessage(msg2);

        Message msg = new Message("coi", "Coi chao ca nhom");
        client.sendMessage(msg);


        System.out.print("Press enter to close session\n");
        new Scanner(System.in).nextLine();
    }

}
