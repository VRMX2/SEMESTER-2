import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class p3 {

    public static void main(String[] args) {
        String serverIP = "192.168.163.66"; 
        int port = 2004;

        try {
            System.out.println("Connexion au serveur " + serverIP + ":" + port + " ...");
            Socket client = new Socket(serverIP, port);
            System.out.println("Connecté au serveur !");

            // Send a message to the server
            ObjectOutputStream out = new ObjectOutputStream(client.getOutputStream());
            out.writeObject("Salut Serveur, c'est le Client !");
            out.flush();
            System.out.println("Message envoyé au serveur.");

            // Read the server's response
            ObjectInputStream in = new ObjectInputStream(client.getInputStream());
            String response = (String) in.readObject();
            System.out.println("Réponse du serveur : " + response);

            // Close everything
            in.close();
            out.close();
            client.close();

        } catch (Exception e) {
            System.out.println("Exception - Client : " + e.getMessage());
        }
    }
}
