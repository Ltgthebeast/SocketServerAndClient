import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

import javax.swing.JOptionPane;

public class Client {

	public static void main(String argsp[]){


		String serverAddress = JOptionPane.showInputDialog("Enter IP Address of a machine that is\n" +
				"running the date service on port 9090:");
		Socket s = null;
		int vars[] = null;
		try {
			s = new Socket(serverAddress, 9090);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ObjectInputStream input = null;
		try {
			input = new ObjectInputStream(s.getInputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while(true){

			if(input != null){

				try {
					vars = (int[]) input.readObject();
				} catch (IOException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				int numTimes = 0;
				for(int i = 0; i < vars.length; i++){
					
					System.out.println("Position: "+i+" | "+vars[i]);
				}
				System.out.println("");
			}
		}

	}

}
