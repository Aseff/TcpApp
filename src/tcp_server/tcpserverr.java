package tcp_server;


import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class tcpserverr {

    public static void main(String[] args) throws Exception {
        readAsByte();
    }

    public static void readAsByte() throws IOException, Exception {
        ServerSocket oursocket = new ServerSocket(8888);

        while (true) {
            System.out.println("Searching for Client...");
            Socket connection = oursocket.accept();
            System.out.println("connection uucceeded ");
            
            InputStream in = connection.getInputStream();
            OutputStream output = new FileOutputStream("/Users/asefn/OneDrive/Desktop/pana.jpg");
            byte[] buffer = new byte[80000];
            int bytesRead = 0;
            while ((bytesRead = in.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }

            connection.close();
            System.out.println("File sent");
        }
    }
}
