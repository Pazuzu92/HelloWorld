import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Server {
    public static void main(String[] args) {
        Server server = new Server();
    }

    private final List<Connection> connections =
            Collections.synchronizedList(new ArrayList<Connection>());
    private ServerSocket server;

    public Server() {
        try {
            server = new ServerSocket(8080);

            while (true) {
                Socket socket = server.accept();

                Connection con = new Connection(socket);
                connections.add(con);

                con.start();

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeAll();
        }
    }


    private void closeAll() {
        try {
            server.close();

            synchronized(connections) {
                for (Connection connection : connections) {
                    connection.close();
                }
            }
        } catch (Exception e) {
            System.err.println("closeAll Error!");
        }
    }


    private class Connection extends Thread {
        private BufferedReader in;
        private PrintWriter out;
        private final Socket socket;


        public Connection(Socket socket) {
            this.socket = socket;

            try {
                in = new BufferedReader(new InputStreamReader(
                        socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

            } catch (IOException e) {
                e.printStackTrace();
                close();
            }
        }


        @Override
        public void run() {
            try {
                String name = in.readLine();

                synchronized(connections) {
                    for (Connection connection : connections) {
                        connection.out.println(name + " was connected");
                    }
                }

                String str = "";
                while (true) {
                    str = in.readLine();
                    if(str.equals("quit")) break;

                    synchronized(connections) {
                        for (Connection connection : connections) {
                            connection.out.println(name + ": " + str);
                        }
                    }
                }

                synchronized(connections) {
                    for (Connection connection : connections) {
                        connection.out.println(name + " has left");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close();
            }
        }


        public void close() {
            try {
                in.close();
                out.close();
                socket.close();

                connections.remove(this);

            } catch (Exception e) {
                System.err.println("close Error on Server");
            }
        }
    }
}

