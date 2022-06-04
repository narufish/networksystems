import java.net.*;
import java.util.*;



public class NetIface {
	

	public static void main(String[] args) {
		
		try {
			Enumeration <NetworkInterface> interfaceList = NetworkInterface.getNetworkInterfaces();
			
			while(interfaceList.hasMoreElements()) {

				NetworkInterface iface = interfaceList.nextElement();
				String addrName = iface.getName();
				System.out.println("Interface " + addrName + ":" );
				
				Enumeration<InetAddress> addresses = iface.getInetAddresses();
				while(addresses.hasMoreElements()) {
					InetAddress addr = addresses.nextElement();
					String ip = addr.getHostAddress();
					System.out.printf("\t Address: ");
					System.out.print(ip + "\n");
				}
				
			}
			
			
		}catch(SocketException e) {
			System.out.println("Error getting network interfaces: " + e.getMessage());
			
		}

	}
	
	
	}


