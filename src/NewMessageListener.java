import java.util.EventListener;

public interface NewMessageListener extends EventListener {
    void newMessage(String message);
}
