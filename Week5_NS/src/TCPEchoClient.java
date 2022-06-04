import java.net.*;
import java.io.*;

public class TCPEchoClient {
	//Week 5

	public static void main(String[] args) {
		
		if(args.length<3) {
			TCPEchoClient.printusage();
			System.exit(0);
		}
		
		System.out.println("Connecting to server... sending echo string");
		
		int port = Integer.parseInt(args[2]); // port string
		
		try {
			
			Socket socket = new Socket(args[0],port);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			String received = args[1];
			
			if(received != null) {
				System.out.println("Received: " + received);
				out.println(received);
			}
			
			in.close();
			out.close();
			socket.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void printusage() {
		System.err.println("TCPEchoClient requires 3 arguments: <Server Host> <Char String> <Server Port>");
	}

}
