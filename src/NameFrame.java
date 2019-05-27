import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NameFrame extends JFrame {
    private static final String BTN_TXT = " Start Chatting ...";
    private static final String LABEL_TXT = " Choose Your UserName ";
    private static final int WIDTH = 300, HEIGHT = 100;
    private JTextField textField;
    private JButton btn;
    private SwitchFramesListener listener = null;

    public NameFrame() throws HeadlessException {
        super();
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(WIDTH, HEIGHT);
        setTitle("Login");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((dim.width / 2) - (getWidth() / 2), (dim.height / 2) - (getHeight() / 2));
        JLabel label = new JLabel("Choose Your UserName");
        add(label, BorderLayout.PAGE_START);
        textField = new JTextField();
        textField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listener.switchFrames(textField.getText());
            }
        });
        btn = new JButton(LABEL_TXT);
        btn.addActionListener(textField.getActionListeners()[0]);
        add(btn, BorderLayout.PAGE_END);
        add(textField, BorderLayout.CENTER);
        setVisible(true);
    }

    public void setListener(SwitchFramesListener listener) {
        this.listener = listener;
    }
}