import java.net.*;
import java.io.*;


public class TCPEchoServerThread {
	
	public static void main(String[] args) throws IOException {
		if(args.length!=1) {
			throw new IllegalArgumentException("Parameter(s): <port>");
		}
		
		final int port = Integer.parseInt(args[0]);
		ServerSocket servSocket = new ServerSocket(port);
		System.out.printf("run at %s %d\n", InetAddress.getLocalHost().getHostName(), port);
		
		while(true) {
			Socket clientSock = servSocket.accept();
			Thread thread = new Thread(new PrintAddress(clientSock));
			Thread thread1 = new Thread(new ReplyMessage(clientSock));
			thread.start();
			thread1.start();
		}

	}

	

}
