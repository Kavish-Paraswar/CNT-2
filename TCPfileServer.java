import java.io.DataInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPfileServer {

    public static void main(String[] args) {
        int port = 6000;
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("File Server started. Waiting for client...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected: " + socket.getInetAddress());

            DataInputStream dinput = new DataInputStream(socket.getInputStream());
            // FileOutputStream foutput = new FileOutputStream(
            FileOutputStream foutput = new FileOutputStream(
                    "D:\\Desktop\\Desktop\\VIT\\TY SEM-1\\CN AND TECH\\recieved.file.txt"
            );

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = dinput.read(buffer)) != -1) {
                foutput.write(buffer, 0, bytesRead);
            }

            foutput.close();
            dinput.close();
            socket.close();

            System.out.println("File received successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
