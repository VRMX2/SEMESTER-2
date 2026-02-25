package TP3;

import java.net.*;
import java.io.*;

public class p4 {

    public static void main(String[] args) {

        try {

            ServerSocket server = new ServerSocket(5004);

            System.out.println("P4 waiting...");

            Socket socketP3 = server.accept();

            ObjectInputStream in = new ObjectInputStream(socketP3.getInputStream());

            ObjectOutputStream out = new ObjectOutputStream(socketP3.getOutputStream());

            int N = (Integer) in.readObject();

            N = N * 30;

            System.out.println("P4 send result: " + N);

            out.writeObject(N);

            socketP3.close();
            server.close();

        }

        catch (Exception e) {
            e.printStackTrace();
        }

    }

}