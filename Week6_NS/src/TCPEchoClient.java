import java.net.*;
import java.io.*;

public class TCPEchoClient {
	//Week 6

	public static void main(String[] args) {
		
		if(args.length<3) {
			TCPEchoClient.printusage();
			System.exit(0);
		}
		
		System.out.println("Connected to server... sending echo string");
		
		int port = Integer.parseInt(args[2]); // port string
		String path = "log.txt";//filename of text file
		
		try {
			
			Socket socket = new Socket(args[0],port);
			
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
			FileWriter write = new FileWriter(path, true);
			PrintWriter print_line = new PrintWriter(write);

			String received = args[1];
			out.println(received);

			String str;
			if((str = in.readLine()) != null) {
				System.out.println(str);
			}
			
			in.close();
			out.close();
			print_line.close();
			socket.close();
			
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void printusage() {
		System.err.println("TCPEchoClient requires 3 arguments: <Server Host> <Char String> <Server Port>");
	}

}
