import java.net.*;
import java.io.*;

public class adTCPEchoServer {
public static void main(String[] args) {
		
		if(args.length!=1) {
			throw new IllegalArgumentException("Parameter(s): <port>");
		}
		final int port = Integer.parseInt(args[0]);//First argument is the port
		String path = "adlog.txt";//filename of text file
		
		try {
			System.out.printf("run telnet %s %d\n", InetAddress.getLocalHost().getHostName(), port);
			ServerSocket servSocket = new ServerSocket(port); 
			System.out.println("Started server on port " + port);
			
			while(true) {
				
				Socket clientSocket = servSocket.accept();
				SocketAddress clientAddress = clientSocket.getRemoteSocketAddress();
				System.out.printf("Accepted connection from client at %s\n", clientAddress);
				System.out.printf("Handling client from client at %s\n", clientAddress);
				
				
				InputStreamReader ir = new InputStreamReader(new DataInputStream(clientSocket.getInputStream()));
				BufferedReader br = new BufferedReader(ir);//Reads input from client
				
				PrintStream printclient = new PrintStream(clientSocket.getOutputStream());//Output back to client
				
				PrintWriter print_line = new PrintWriter(new FileWriter(path, true));//Ouput into text file
	
				if(ir!=null) {
					System.out.printf("Message received from %s has been appended to %s\n", clientAddress, path);
				}
				
				String input = br.readLine();//string input from client server
				
				if(input!=null) {
					String newinput = input.toLowerCase();
					printclient.printf("Received: %s\n", newinput);//Echo input back to client
					printclient.flush();
					print_line.write(newinput + "\n");//output line into txt file
					print_line.flush();
				}
			
				System.out.printf("Closing connection from client: %s\n", clientAddress);
				br.close();
				printclient.close();
				print_line.close();
				clientSocket.close();
			
			}
		}catch(IOException e) {
			System.out.println("Problems initializing server: " + e);
			System.exit(1);
		}
	}

}
