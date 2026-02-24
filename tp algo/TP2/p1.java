import java.io.ObjectOutputStream;
import java.net.Socket;

public class p1 { // client

    public static void main(String[] args) {

        try {
            System.out.println("Demande de connexion");
            Socket c = new Socket("192.168.161.208", 2004);
            System.out.println("Connected ...");
            ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
            out.writeObject("RSD");
            out.close();
            c.close();
        } catch (Exception e) {
            System.out.println("Exception :" + e.toString());
        }

    }

}