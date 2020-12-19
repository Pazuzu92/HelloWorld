import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Server {
    public static Integer SERVER_PORT = 8080;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
        Socket socket = serverSocket.accept();
        BufferedReader clientReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedWriter clientWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        String message;
        StringBuilder sb = new StringBuilder("");
        while ((message = clientReader.readLine()) != null) {
            System.out.println(message);
            Pattern pattern = Pattern.compile("GET [\\s]*[/\\w]* HTTP/1.0");
            Matcher matcher = pattern.matcher(message);

            if (matcher.find()) {

                Files.walk(Paths.get("C:\\Users\\DeadCalm\\Study\\homework6"), FileVisitOption.FOLLOW_LINKS)
                        .map(Path::toFile)
                        .forEach(f -> {
                            sb.append(f.getAbsolutePath()).append(" ");

                        });
                clientWriter.write("\"" + sb + "\" received \n");
            } else {
                clientWriter.write("HTTP/1.0 404 Not Found\n");
            }
            clientWriter.flush();

        }
    }
}
