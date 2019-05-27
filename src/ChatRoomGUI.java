import network.ClientListener;
import network.Communicator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.util.ArrayList;

public class ChatRoomGUI extends JFrame{
    private final String WINDOWS_TITLE = "AUT Chat Room";
    private final int WIDTH = 500, HEIGHT = 500;
    private final int X = 100, Y = 100;
    private ChatArea chatBox = new ChatArea();
    private MessageArea messageArea = new MessageArea();
    private ParticipantsArea participantsArea = new ParticipantsArea();
    private String username;
    private NewMessageListener listener = null;
    private ArrayList<String> onlineUsers;
    private Communicator communicator;
    private ClientListener clientListener = null;

    public ChatRoomGUI(String username) {
        super();
        onlineUsers = new ArrayList<>();
        communicator = new Communicator();
        this.setTitle(WINDOWS_TITLE);
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(WIDTH, HEIGHT);
        this.setLocation(X, Y);
        this.add(new JScrollPane(chatBox), BorderLayout.CENTER);
        this.add(messageArea, BorderLayout.PAGE_END);
        this.add(participantsArea, BorderLayout.WEST);
        this.username = username;
        messageArea.getButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                listener.newMessage(messageArea.getTextField().getText());
                try {
                    communicator.sendMessage(messageArea.getTextField().getText());
                } catch (IOException exception) {
                    exception.printStackTrace();
                }
                messageArea.getTextField().setText("");
            }
        });
        messageArea.getTextField().addActionListener(messageArea.getButton().getActionListeners()[0]);
        messageArea.getTextField().addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                messageArea.getTextField().setText("");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                messageArea.getTextField().setText("");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                messageArea.getTextField().setText("Write your message...");
            }

            @Override
            public void mouseEntered(MouseEvent e) {}

            @Override
            public void mouseExited(MouseEvent e) {}
        });
        this.setVisible(true);
    }

    public void addNewMessageListener(NewMessageListener listener){
        this.listener = listener;
    }

    public void addNewMessage(String username, String message) {
        chatBox.addMessage(username, message);
    }

    public void  addOnlineUser(String username) {
        if (!onlineUsers.contains(username)) {
            onlineUsers.add(username);
            participantsArea.addUser(username);
        } else {
            System.out.println("ERROR: User is already online.");
        }
    }

    public void removeOnlineUser(String username) {
        if (onlineUsers.contains(username)) {
            onlineUsers.remove(username);
            participantsArea.getModel().removeElement(username);
        } else {
            System.out.println("ERROR: User is not online.");
        }
    }

    public String getUsername() {
        return username;
    }

    public void setOnlineUsers(ArrayList<String> onlineUsers) {
        this.onlineUsers = onlineUsers;
        participantsArea.getModel().removeAllElements();
        participantsArea.addUser(this.username);
        for (String username : onlineUsers) {
            if (!username.equals(this.username))
                participantsArea.addUser(username);
        }
    }

    public ArrayList<String> getOnlineUsers() {
        return onlineUsers;
    }
}
