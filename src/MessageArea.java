import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MessageArea extends JPanel{
    private JTextField textField = new JTextField("Write your message...");
    private JButton button = new JButton("Send");

    public MessageArea() {
        super(new BorderLayout());
//        button.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                textField.setText("");
//                this.listener.newMessage(messageToSend);
//            }
//        });
        add(button, BorderLayout.EAST);
//        textField.addActionListener(button.getActionListeners()[0]);
//        textField.addMouseListener(new AbstractMouseListener());
        add(textField, BorderLayout.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }
}
