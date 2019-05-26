public class Logic {
    private ChatRoomGUI chatRoom;

    public Logic(ChatRoomGUI chatRoom) {
        this.chatRoom = chatRoom;
        chatRoom.addNewMessageListener(new NewMessageListener() {
            @Override
            public void newMessage(String message) {
                System.out.println("new message to send: " + message);
            }
        });
    }
}
