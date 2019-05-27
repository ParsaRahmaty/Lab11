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
        add(button, BorderLayout.EAST);
        add(textField, BorderLayout.CENTER);
    }

    public JTextField getTextField() {
        return textField;
    }

    public JButton getButton() {
        return button;
    }
}
