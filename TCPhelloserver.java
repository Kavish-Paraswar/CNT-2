

import java.io.*;
import java.net.*;

public class TCPhelloserver {
    public static void main(String[] args) {
        int port = 5000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Server is waiting for connection...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            String msgFromClient = in.readLine();
            System.out.println("Client: " + msgFromClient);

            out.println("Hello from Server!");

            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
