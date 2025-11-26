
import java.io.*;
import java.net.*;

public class TCPhelloclient {
	public static void main(String[] args) {
        String serverIP = "127.0.0.1"; 
        int port = 5000;

        try (Socket socket = new Socket(serverIP, port)) {
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            
            out.println("Hello from Client!");

            String reply = in.readLine();
            System.out.println("Server: " + reply);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

