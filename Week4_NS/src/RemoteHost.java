

import java.net.*;

public class RemoteHost {

	public static void main(String[] args) {
		try {
			
			InetAddress ip = InetAddress.getByName(args[0]);
			String ipname = ip.getHostName();
			String ipaddress = ip.getHostAddress();
			System.out.println("Ip address of " + ipname + " is: " + ipaddress );
			System.out.println(ip);
			
		}catch(UnknownHostException e) {
			System.out.println("Unable to find address for " + args[0]);
		}
	}

}
