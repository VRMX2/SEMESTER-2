import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p2 { // Serveur

    public static void main(String[] args) {
        try {
            System.out.println("Creation de service sur le port 2004");
            ServerSocket s = new ServerSocket(2004);
            while (true) {
                System.out.println("Waiting .....");
                Socket connection = s.accept();
                System.out.println("Accpeted ....");
                ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
                String ch = (String) in.readObject();
                System.out.println("Ch = " + ch);
            }
            // s.close();in.close();connection.close();
        } catch (Exception e) {
            System.out.println("Exception");
        }
    }

}