

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;

public class TCPfileclient {
    public static void main(String[] args) {
        String serverIP = "127.0.0.1"; 
        int port = 6000;

        try (Socket socket = new Socket(serverIP, port)) {
            File file = new File("D:\\Desktop\\Desktop\\VIT\\TY SEM-1\\CN AND TECH\\TCP\\send-file.txt"); // File to send
            FileInputStream finput = new FileInputStream(file);
            DataOutputStream doutput = new DataOutputStream(socket.getOutputStream());

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = finput.read(buffer)) != -1) {
                doutput.write(buffer, 0, bytesRead);
            }

            finput.close();
            doutput.close();
            socket.close();

            System.out.println("File sent successfully.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
