import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class ClientB {
    public static void main(String[] args) {
        new ClientB();
    }
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public ClientB() {

        Scanner scan = new Scanner(System.in);
        try {

            socket = new Socket("localhost", 8080);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            System.out.println("Enter your nickname:");
            out.println(scan.nextLine());


            Resender resend = new Resender();
            resend.start();

            String str = "";
            while (!str.equals("quit")) {
                str = scan.nextLine();
                out.println(str);
            }
            resend.setStop();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            close();
        }
    }


    private void close() {
        try {
            in.close();
            out.close();
            socket.close();
        } catch (Exception e) {
            System.err.println("Close error!");
        }
    }

    private class Resender extends Thread {

        private boolean stopped;


        public void setStop() {
            stopped = true;
        }

        @Override
        public void run() {
            try {
                while (!stopped) {
                    String str = in.readLine();
                    System.out.println(str);
                }
            } catch (IOException e) {
                System.err.println("getMsg Error!");
                e.printStackTrace();
            }
        }
    }

}