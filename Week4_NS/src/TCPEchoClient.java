import java.net.*;
import java.io.*;

public class TCPEchoClient {

	public static void main(String[] args) {
		
		if(args.length<3) {
			TCPEchoClient.printusage();
			System.exit(1);
		}
		
		try {
			//InetAddress host = InetAddress.getByName(args[0]);
			System.out.println("Connecting to server... sending echo string");
			int port = Integer.parseInt(args[2]);
			Socket socket = new Socket(args[0],port);
			
			InputStream in = socket.getInputStream();
			OutputStream out = socket.getOutputStream();
			BufferedReader serverIn = new BufferedReader(new InputStreamReader(in));
			PrintWriter printOut = new PrintWriter(out, true);
			String received;
			while((received = serverIn.readLine()) != null) {
				System.out.println("Received: " + received);
				//out.println(received);
			}
			
			socket.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void printusage() {
		System.err.println("TCPEchoClient requires 3 arguments: <Server Host> <Char String> <Server Port>");
	}

}
