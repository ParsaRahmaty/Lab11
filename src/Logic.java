import java.awt.event.WindowEvent;

public class Logic {
    private ChatRoomGUI chatRoom;
    private NameFrame nameFrame;

    public Logic() {
        nameFrame = new NameFrame();
        nameFrame.setListener(new SwitchFramesListener() {
            @Override
            public void switchFrames(String username) {
                nameFrame.dispose();
                chatRoom = new ChatRoomGUI(username);
                chatRoom.addNewParticipant(username);
                chatRoom.addNewMessageListener(new NewMessageListener() {
                    @Override
                    public void newMessage(String message) {
                        chatRoom.addNewMessage(chatRoom.getUsername(), message);
                    }
                });
            }
        });
    }
}
