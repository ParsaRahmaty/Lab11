import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ChatRoomGUI extends JFrame{
    private final String WINDOWS_TITLE = "AUT Chat Room";
    private final int WIDTH = 500, HEIGHT = 500;
    private final int X = 100, Y = 100;
    private ChatArea chatBox = new ChatArea();
    private MessageArea messageArea = new MessageArea();
    private ParticipantsArea participantsArea = new ParticipantsArea();
    private String username;
    private NewMessageListener listener = null;

    public ChatRoomGUI(String username) {
        super();
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
            public void actionPerformed(ActionEvent e) {
                listener.newMessage(messageArea.getTextField().getText());
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

    public void  addNewParticipant(String username) {
        participantsArea.addUser(username);
    }

    public void removeParticipant(String username) {
        participantsArea.getModel().removeElement(username);
    }

    public String getUsername() {
        return username;
    }
}
