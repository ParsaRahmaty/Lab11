package network;

import com.sun.security.ntlm.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Communicator implements ClientListener {
    private Socket socket;

    @Override
    public void recieveMessage(String message) {

    }

    public void sendMessage(String message) throws IOException{
        socket = new Socket("localhost", 1234);
//        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println(message);
    }
}
