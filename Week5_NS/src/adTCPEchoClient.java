import java.io.*;
import java.net.*;

public class adTCPEchoClient {

	public static void main(String[] args) {
		
		if(args.length<3) {
			adTCPEchoClient.printusage();
			System.exit(0);
		}
		
		System.out.println("Connected to server... sending echo string");
		
		int port = Integer.parseInt(args[3]); // port string
		String arg = args[2];

		try {
			FileReader input = new FileReader(new File(args[1]));
			BufferedReader fileread = new BufferedReader(input);
			BufferedWriter output = new BufferedWriter(new FileWriter(arg));
			PrintWriter outPrint = new PrintWriter(output);
			
			Socket socket = new Socket(args[0],port);
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

			String str;
			while((str = fileread.readLine())!=null) {
				System.out.println(str);
				out.println(str);
				outPrint.println(str);
				byte[] bytes = str.getBytes("UTF-8");
				int sizeBytes = bytes.length;
				System.out.println("Received: " + sizeBytes + " bytes" );
				
			}
			
			System.out.println("Created output file: " + arg);
			
			fileread.close();
			outPrint.close();
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


