package edu.vn.iuh.fit.ws.chat.gui;

import edu.vn.iuh.fit.ws.chat.server.Message;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChatClientGUI extends JFrame implements ActionListener {
    private final JTextField tfWsURL;
    private final JTextField tfNickName;
    private final JTextField tfTo;
    private final JTextField tfMessage;
    private final JTextArea taContent;
    private final JButton btnConnect;
    private final JButton btnSend;
    private ChatClient client;


    public ChatClientGUI() {
        setTitle("Chát Chút Chít - @V2H");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                try {
                    client.close();
                    dispose();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
//        setResizable(false);

        Box b = Box.createVerticalBox();
        Box b1 = Box.createHorizontalBox();
        Box b2 = Box.createHorizontalBox();
        Box b3 = Box.createHorizontalBox();
        Box b4 = Box.createHorizontalBox();
        Box b5 = Box.createHorizontalBox();
        JLabel l1, l2, l3, l4, l5;
        b1.add(l1 = new JLabel("WS URL:"));
        b1.add(tfWsURL = new JTextField("ws://localhost:8080/helloworld/chat/"));
        b1.add(btnConnect = new JButton("Connect"));
        b2.add(l2 = new JLabel("Nick name:"));
        b2.add(tfNickName = new JTextField("<anonymous>"));
        b3.add(l3 = new JLabel("Send To:"));
        b3.add(tfTo = new JTextField());
        b4.add(new JScrollPane(taContent = new JTextArea(8, 8)));
        b5.add(l5 = new JLabel("Message:"));
        b5.add(tfMessage = new JTextField());
        b5.add(btnSend = new JButton("Send"));
        tfTo.setToolTipText("Leave blank to send all");
        tfNickName.setToolTipText("You should change the nick name");
        l1.setPreferredSize(l2.getPreferredSize());
        l3.setPreferredSize(l2.getPreferredSize());
        l5.setPreferredSize(l2.getPreferredSize());

        b.add(Box.createVerticalStrut(9));
        b.add(b1);
        b.add(Box.createVerticalStrut(9));
        b.add(b2);
        b.add(Box.createVerticalStrut(9));
        b.add(b3);
        b.add(Box.createVerticalStrut(9));

        b.add(Box.createVerticalStrut(9));
        this.add(b, BorderLayout.NORTH);
        b.add(Box.createVerticalStrut(15));
        this.add(b4, BorderLayout.CENTER);
        this.add(b5, BorderLayout.SOUTH);

        btnConnect.addActionListener(this);
        btnSend.addActionListener(this);
        btnSend.setEnabled(false);

    }

    public static void main(String[] args) {
        new ChatClientGUI().setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if (o.equals(btnConnect)) {
            try {
                if (btnConnect.getText().equals("Connect")) {
                    client = new ChatClient(tfWsURL.getText(), tfNickName.getText(), taContent);

                    btnConnect.setText("Disconnect");
                    btnSend.setEnabled(true);
                    tfWsURL.setEditable(false);
                    tfNickName.setEditable(false);

                } else {
                    btnConnect.setText("Connect");
                    btnSend.setEnabled(false);
                    tfWsURL.setEditable(true);
                    tfNickName.setEditable(true);
                    client.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
        } else if (o.equals(btnSend)) {
            if(!tfMessage.getText().isBlank()) {
                try {
                    Message message = null;
                    if (tfTo.getText().trim().isEmpty())
                        message = new Message(tfNickName.getText(), tfMessage.getText());
                    else {
                        message = new Message(tfNickName.getText(), tfTo.getText(), tfMessage.getText());
                        taContent.append(message.getFrom() + ": " + message.getContent() + "\n");
                    }
                    client.sendMessage(message);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage());
                }
            }
        }
    }
}
