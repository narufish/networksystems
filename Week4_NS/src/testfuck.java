
import java.io.*;
import java.net.*;

public class testfuck {

	public static void main(String[] args) {
		try {
				//FileInputStream weblogfile = new FileInputStream(args[0]);
				//InputStreamReader weblogread = new InputStreamReader(weblogfile, "UTF-8");
				String str = "This program is lame bro";
				//BufferedReader weblog = new BufferedReader(str);
				
				
				
				
				StringBuffer inputBuffer = new StringBuffer(str) ;
				String butt = "Tomatobutt";
				
				//for(String line = weblog.readLine(); line != null ;line = weblog.readLine()) {
					
					int index = str.indexOf(' ');
					String ip = str.substring(0,index);
					String theRest = str.substring(index);
					inputBuffer.replace(0, index, butt);
					System.out.println(inputBuffer);
					
					//String hostname = InetAddress.getByName(ip).getHostName();
					//bw.append(hostname + " " + theRest);
					
					
				
				
				
				
				
				
				
				
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}

	}


