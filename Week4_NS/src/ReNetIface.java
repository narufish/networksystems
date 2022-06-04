import java.net.*;

public class ReNetIface {

	public static void main(String[] args) {
		try {
			InetAddress[] ip = InetAddress.getAllByName(args[0]);
			
			for(int i = 0; i<ip.length ;i++) {
				if(ip[i] instanceof Inet6Address) {
					System.out.printf(" \t %s  (v6)\n ", ip[i]);
				}else if(ip[i] instanceof Inet4Address) {
					System.out.printf(" \t %s (v4)\n ", ip[i]);
				}
				
			}
				
		}catch(UnknownHostException e) {
			System.out.println("Unable to find address for " + args[0]);
		}

	}

}
