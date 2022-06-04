import java.net.InetAddress;
import java.net.UnknownHostException;

public class MyLocalHost {
	

	public static void main(String[] args) {
		try {
			
		InetAddress ip = InetAddress.getLocalHost();
		String hostname = ip.getHostName();
		String iphost = ip.getHostAddress();
		
		System.out.println("Host name of this machine is: " + hostname);
		System.out.println("IP address of this machine is: " + iphost);
		
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}
	}

}
