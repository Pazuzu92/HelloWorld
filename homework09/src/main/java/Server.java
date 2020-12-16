import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Server {
    public static Integer SERVER_PORT = 4999;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket socket = serverSocket.accept();
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String message;
        StringBuilder sb = new StringBuilder("");
        while ((message = clientReader.readLine()) != null) {
            System.out.println(message);
            if (message.startsWith("GET")) {

                Files.walk(Paths.get("C:\\Users\\DeadCalm\\Study\\homework6"), FileVisitOption.FOLLOW_LINKS)
                        .map(Path::toFile)
                        .forEach(f -> {
                            sb.append(f.getAbsolutePath()).append(" ");

                        });
                clientWriter.write("\"" + sb + "\" received \n");
            } else {
                clientWriter.write("HTTP1.0\\404 \n");
            }
            clientWriter.flush();

        }
    }
}
