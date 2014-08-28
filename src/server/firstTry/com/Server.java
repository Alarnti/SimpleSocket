package server.firstTry.com;

import java.net.*;
import java.io.*;

public class Server extends Thread {

    public static void main(String[] args) throws IOException {
        Server server = new Server(8080);
        server.start();
    }

    private ServerSocket serverSocket;

    public Server(int port) throws IOException
    {
        serverSocket = new ServerSocket(port);
    }

    public void run() {
        try {
            Socket socket = serverSocket.accept();

            BufferedReader socketBufReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            String temp = socketBufReader.readLine();

            System.out.println(temp);

            if(temp != null) {
                PrintStream sktPrintStream = new PrintStream(socket.getOutputStream());
                sktPrintStream.println("I've got it!");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
 }

