import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class p2 {

    public static void main(String[] args){

        try{
        System.out.print("Creation de service sure le port 2004 \n");    
        ServerSocket s = new ServerSocket(2004);
        while(true){
        System.out.print("Waiting ....\n"); 
        Socket connection = s.accept();
        System.out.print("Service Accepted ....\n"); 
        ObjectInputStream in = new ObjectInputStream(connection.getInputStream());
        String ch = (String)in.readObject();
        System.out.print("Ch = " + ch + "\n");
        }
        }
        catch(Exception e){
            System.out.print("Exception - server\n");
        }
    } 
}

