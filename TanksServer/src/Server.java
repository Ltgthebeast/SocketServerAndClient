import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
	
	
	public static void main(String[] args) throws IOException {
        ServerSocket listener = new ServerSocket(9090);
        Scanner s = new Scanner(System.in);
        boolean running = true;
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    ObjectOutputStream out =
                        new ObjectOutputStream(socket.getOutputStream());
                    while(running){
                    	System.out.println("Enter A Number to Send");
                    	int var = s.nextInt();
                    	int vars[] = {var, var+1, var-1, var*10};
                    	if(var == 101){
                    		running = false;
                    	}
                    	out.writeObject(vars);
                    }
                } finally {
                    socket.close();
                }
            }
        }
        finally {
            listener.close();
        }
    }
	
}
