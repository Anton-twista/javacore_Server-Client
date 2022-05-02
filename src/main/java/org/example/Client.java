package org.example;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {
    public static void main(String[] args) {

        String host = "localhost";
        int port = 8088;

        try (Socket socket = new Socket(host,port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            out.println("Ихтиандры!\n");
            String resp = in.readLine();

            System.out.println(resp);


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}