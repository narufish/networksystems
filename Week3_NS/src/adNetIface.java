import java.net.*;
import java.util.*;


public class adNetIface {

	public static void main(String[] args) {
		try {
			Enumeration <NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			
			
			for(NetworkInterface netint : Collections.list(interfaceList)) {
					displayInterfaceInformation(netint);
			}
				
			
			
			
		}catch(SocketException e) {
			System.out.println("Error getting network interfaces: " + e.getMessage());
			
		}

	}
	
	static void displayInterfaceInformation(NetworkInterface netint) {
		System.out.printf("Interface %s\n :", netint.getName());
		Enumeration<InetAddress> addresses = netint.getInetAddresses();
		
		for(InetAddress inetaddress : Collections.list(addresses)) {
			String ip = inetaddress.getHostAddress();
			
			if(inetaddress instanceof Inet6Address) {
				System.out.printf(" \t Address (v6): %s\n ", ip);
			}else if(inetaddress instanceof Inet4Address) {
				System.out.printf(" \t Address (v4): %s\n ", ip);
			}
			
		}
	}

	}


