import java.net.*;
import java.io.*;


public class UDPEchoServer {
	final static int MAXBYTES = 255;

	public static void main(String[] args) {
		if (args.length != 1) {
            throw new IllegalArgumentException("Parameter(s): <Port>");
        }
		
		try {
			
			int port = Integer.parseInt(args[0]);
			InetAddress serverAddress = InetAddress.getLocalHost();
			String hostname = serverAddress.getHostName();
			DatagramSocket socket = new DatagramSocket(port);
			
			System.out.printf("run at %s on %d\n", hostname, port);
			DatagramPacket packet = new DatagramPacket(new byte[MAXBYTES], MAXBYTES);
			
			while(true) {
				socket.receive(packet);
				String message = new String(packet.getData());
				System.out.println("Receiving: " + message + " (" + packet.getLength() 
				+ " bytes) from client at " + packet.getAddress().getHostAddress() 
				+ " on port " + packet.getPort());
				byte[] send = (message).getBytes();
				packet.setData(send, 0, packet.getLength());
				socket.send(packet);
				packet.setData(new byte[255]);

			}
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
