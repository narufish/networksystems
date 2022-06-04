import java.net.*;
import java.io.*;

public class ReplyMessage implements Runnable{
	private Socket sock;
	
	public ReplyMessage(Socket sock) {
		this.sock = sock;
	}
	public void run() {
		try {
			String message;
			SocketAddress clientAddress = sock.getRemoteSocketAddress();
			String preString = "Received: ";
			byte []prefix = preString.getBytes();
			InputStreamReader ir = new InputStreamReader(new DataInputStream(sock.getInputStream()));
			BufferedReader br = new BufferedReader(ir);
			PrintStream printclient = new PrintStream(sock.getOutputStream());
			
			printclient.write(prefix, 0, prefix.length);
			String input = br.readLine();//string input from client server
			if(input!=null) {
				if(input.length()<10) {
					message = input.toLowerCase();
				}else {
					message = input.toUpperCase();
				}
				printclient.printf(message);//Echo input back to client
				printclient.flush();
				
			}
			System.out.printf("Client %s, echoed %d bytes.\n", clientAddress, input.length());//Display message on server side
			ir.close();
			printclient.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
