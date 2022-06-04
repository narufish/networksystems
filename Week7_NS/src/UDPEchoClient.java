import java.net.*;
import java.io.*;

public class UDPEchoClient {

	public static void main(String[] args) {
		
		try {
			
			if((args.length<3 || args.length>3)) {
				throw new IllegalArgumentException("Usage: <server address> <port> <server>");
			}
			InetAddress address = InetAddress.getByName(args[0]);
			int servPort = Integer.parseInt(args[1]);
			byte[] bufSend = args[2].getBytes();
			boolean receivedResponse = false;
			
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket sendPacket = new DatagramPacket(bufSend, bufSend.length, address, servPort);
			DatagramPacket receivePacket = new DatagramPacket(new byte[255], 255);
			
			socket.send(sendPacket);
			socket.receive(receivePacket);
					
			if(!receivePacket.getAddress().equals(address)) {
				System.out.println("Received packet from an unknown source");
			}else {
				receivedResponse = true;
			}
			if(receivedResponse) {
				String input = new String(receivePacket.getData(),0,receivePacket.getLength());
				System.out.println("Received: " + input);
			}else {
				System.out.println("No response");
			}	
			
			socket.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}

}
