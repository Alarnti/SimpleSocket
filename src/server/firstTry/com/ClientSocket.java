package server.firstTry.com;

import java.io.*;
import java.net.*;

public class ClientSocket extends Thread {
    public static void main(String[] args) throws IOException {
        ClientSocket clientSocket = new ClientSocket();
        clientSocket.start();

    }

    public void run(){
        try {
            Socket skt = new Socket("localhost",8080);

        PrintStream sktPrStream = new PrintStream(skt.getOutputStream());

        sktPrStream.println("Hello, Server");

        BufferedReader inputSkt = new BufferedReader(new InputStreamReader(skt.getInputStream()));

        String input = inputSkt.readLine();
        System.out.println(input);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}