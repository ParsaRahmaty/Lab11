package network;

import java.util.EventListener;

public interface ClientListener extends EventListener{
    void recieveMessage(String message);
}
