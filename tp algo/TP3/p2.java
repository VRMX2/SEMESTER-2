package TP3;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p2 {
    public static void main(String[] args) {
        try {
          
            ServerSocket ss = new ServerSocket(2002);
            System.out.println("P2 en attente...");

            Socket c = ss.accept();
            System.out.println("P1 connecté");

            ObjectInputStream in = new ObjectInputStream(c.getInputStream());
            String N = (String) in.readObject();

       
            String S = Integer.toString(Integer.parseInt(N) * 10);
            System.out.println("Résultat calculé : " + S);

            in.close();
            c.close();
            ss.close();

        
            Socket socketP3 = new Socket("192.168.14.156", 2003);
            ObjectOutputStream outP3 = new ObjectOutputStream(socketP3.getOutputStream());

            outP3.writeObject(S);
            outP3.flush();

            outP3.close();
            socketP3.close();

            System.out.println("S envoyé à P3");

        } catch (Exception e) {
            System.out.println("Exception : " + e.toString());
        }
    }
}
