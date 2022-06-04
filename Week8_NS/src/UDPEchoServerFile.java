import java.net.*;
import java.io.*;

public class UDPEchoServerFile {
	final static int MAXBYTES = 255;

	public static void main(String[] args) {
		if (args.length < 2) {
            throw new IllegalArgumentException("Parameter(s): <Port> <output text file>");
        }
		
		try {
			
			int port = Integer.parseInt(args[0]);
			InetAddress serverAddress = InetAddress.getLocalHost();
			String hostname = serverAddress.getHostName();
			DatagramSocket socket = new DatagramSocket(port);
			File file = new File(args[1]);
			BufferedWriter writefile = new BufferedWriter(new FileWriter(file, true));
			PrintWriter outPrint = new PrintWriter(file);//output into text file
			
			System.out.printf("run at %s on %d\n", hostname, port);
			DatagramPacket packet = new DatagramPacket(new byte[MAXBYTES], MAXBYTES);
			while(true) {
				socket.receive(packet);
				String message = new String(packet.getData());
				String filetext = "Receiving: " + message + " (" + packet.getLength() 
				+ " bytes) from client at " + packet.getAddress().getHostAddress() 
				+ " on port " + packet.getPort();
				System.out.println(filetext);
				outPrint.write(filetext + "\n");
				outPrint.flush();
				byte[] send =  message.getBytes();
				packet.setData(send, 0, packet.getLength());
				socket.send(packet);
				
			}	
			
		}catch(IOException e) {
			e.printStackTrace();
		}

	}

}
