import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p2 {

    public static void main(String[] args) {

        try {
            System.out.println("Création du service sur le port 2004...");
            ServerSocket server = new ServerSocket(2004);

            while (true) {
                System.out.println("\nEn attente d'un client...");
                Socket connection = server.accept();

                // Each client handled in its own try-catch
                // so one bad client never stops the server
                try {
                    System.out.println("Client connecté depuis : " + connection.getInetAddress().getHostAddress());

                    // Read message from client
                    ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
                    String clientMessage = (String) in.readObject();
                    System.out.println("Message reçu : " + clientMessage);

                    // Send response back to client
                    ObjectOutputStream out = new ObjectOutputStream(connection.getOutputStream());
                    String response = "Bonjour ! Serveur a reçu : [" + clientMessage + "]";
                    out.writeObject(response);
                    out.flush();
                    System.out.println("Réponse envoyée.");

                    in.close();
                    out.close();

                } catch (Exception clientEx) {
                    System.out.println("Erreur avec ce client : " + clientEx.getMessage());
                } finally {
                    connection.close();
                }
            }

        } catch (Exception e) {
            System.out.println("Erreur fatale du serveur : " + e.getMessage());
        }
    }
}
