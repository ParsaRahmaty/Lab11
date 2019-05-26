import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class ParticipantsArea extends JPanel{
    private DefaultListModel model = new DefaultListModel();
    private JList list = new JList(model);
    private static int currentIndex = 0;
    private HashMap<String, Integer> indexes = new HashMap<>();

    public ParticipantsArea() {
        super(new BorderLayout());
        JLabel label = new JLabel();
        label.setText("Online Users:   ");
        add(label, BorderLayout.PAGE_START);
        add(list, BorderLayout.CENTER);
    }

    public void addUser(String username) {
        model.add(currentIndex, username);
        indexes.put(username, currentIndex);
        currentIndex++;
    }

    public DefaultListModel getModel() {
        return model;
    }

    public HashMap<String, Integer> getIndexes() {
        return indexes;
    }
}
