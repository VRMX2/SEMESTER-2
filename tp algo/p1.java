import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class p1 {

    public static void main(String[] args) {

        try {
            System.out.println("p1 demande une connexion...");
            Socket c = new Socket("localhost", 2004);
            System.out.println("p1 est connecté !");

            // Send message to server
            ObjectOutputStream out = new ObjectOutputStream(c.getOutputStream());
            out.writeObject("RSD");
            out.flush();
            System.out.println("Message envoyé : RSD");

            // Read server's response BEFORE closing
            ObjectInputStream in = new ObjectInputStream(c.getInputStream());
            String response = (String) in.readObject();
            System.out.println("Réponse du serveur : " + response);

            in.close();
            out.close();
            c.close();

        } catch (Exception e) {
            System.out.println("Exception - p1 : " + e.getMessage());
        }
    }
}
