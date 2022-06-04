import java.net.*;

public class AddressType {

	public static void main(String[] args) {
		try {
			InetAddress ip = InetAddress.getByName(args[0]);
			
				if(ip.isLoopbackAddress()) {
					System.out.println(ip + " is a loopback address.");
				}
				if(ip.isAnyLocalAddress()) {
					
					if(ip.isLinkLocalAddress()) {
						System.out.println(ip + " is a link-local address.");
					}
					if(ip.isSiteLocalAddress()) {
						System.out.println(ip + " is a site-local address.");
					}
				}else {
					System.out.println(ip + " is a global address.");
				}
				
				if(ip.isLinkLocalAddress()) {
					System.out.println(ip + " is a link-local address.");
				}
				if(ip.isSiteLocalAddress()) {
					System.out.println(ip + " is a site-local address.");
				}
				if(ip.isMulticastAddress()) {
					
					if(ip.isMCGlobal()) {
						System.out.println(ip + " is a global mulitcast address.");
					}
					if(ip.isMCNodeLocal()) {
						System.out.println(ip + " is an interface-local multicast address.");
					}
					if(ip.isMCLinkLocal()) {
						System.out.println(ip + " is a link-local multicast address .");
					}
					if(ip.isMCSiteLocal()) {
						System.out.println(ip + " is a site-wide mutlicast address.");
					}
					if(ip.isMCOrgLocal()) {
						System.out.println(ip + " is a organization-wide address.");
					}
				}else {
					System.out.println(ip + " is a unicast address.");

				}
				
				
			
				
		}catch(UnknownHostException e) {
				System.out.println("Could not resolve: " + args[0]);
			}
		

	}

}
