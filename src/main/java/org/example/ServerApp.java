package org.example;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {
    public static void main(String[] args) {


        int port = 8088;

        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket socket = serverSocket.accept();
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))){

            System.out.println("New connection accepted\n");


            final String name = in.readLine();

            out.println(String.format("Привет %s ваш порт: %d", name, socket.getPort()));


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}