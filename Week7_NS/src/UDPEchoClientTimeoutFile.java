import java.net.*;
import java.io.*;

public class UDPEchoClientTimeoutFile {

	public static void main(String[] args) {
		
		try {
			
			if((args.length<4 || args.length>4)) {
				throw new IllegalArgumentException("Usage: <server address> <port> <input> <output>");
			}
			InetAddress address = InetAddress.getByName(args[0]);// address of server
			int servPort = Integer.parseInt(args[1]);//port number
			File file = new File(args[2]);//input file name
			BufferedReader fileread = new BufferedReader(new FileReader(file));//read file
			String output = args[3];//output file name
			BufferedWriter writefile = new BufferedWriter(new FileWriter(output, true));
			PrintWriter outPrint = new PrintWriter(output);//output into text file
			
			boolean receivedResponse = false;
			final int timeout = 3000;
			String nextline;
			byte[]input;
			
			DatagramSocket socket = new DatagramSocket();
			DatagramPacket receivePacket = new DatagramPacket(new byte[255], 255);
			socket.setSoTimeout(timeout);
			
			do {
				while((nextline = fileread.readLine())!=null){
					input = nextline.getBytes();
					socket.send(new DatagramPacket(input, input.length, address, servPort));
					try {
						socket.receive(receivePacket);
						
						if(!receivePacket.getAddress().equals(address)) {
							System.out.println("Received packet from an unknown source");
						}else {
							receivedResponse = true;
						}
						if(receivedResponse) {
							System.out.println("Received: " + receivePacket.getLength() + " bytes");
							outPrint.write(new String(receivePacket.getData(),0,receivePacket.getLength()) + "\n");
							outPrint.flush();
						}else {
							System.out.println("No response");
						}
					}catch(InterruptedIOException e) {
						System.out.println("Timed out. Retransmitting. . . ");
					}
				}
				}while(!receivedResponse);
				
			fileread.close();
			writefile.close();
			outPrint.close();
			socket.close();
			
		}catch(IOException e){
			e.printStackTrace();
			
		}
	}

}


