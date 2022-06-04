
import java.io.*;
import java.net.*;

public class WebLog {

	public static void main(String[] args) {
		try {
			File weblogfile = new File(args[0]);
			FileReader weblogread = new FileReader(weblogfile);
			BufferedReader weblog = new BufferedReader(weblogread);
			
			//For testing purposes is outputted into output.txt file
			FileWriter fw = new FileWriter("output.txt");
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			
			for(String line = weblog.readLine(); line != null ;line = weblog.readLine()) {
			
				StringBuilder newStr = new StringBuilder(line);
				int index = line.indexOf(' ');
				
				if(index>7) {
					//Identify ip address string and obtain hostname from it
					String ip = line.substring(0,index);
					String hostname = InetAddress.getByName(ip).getHostName();
					newStr.replace(0,index, hostname);
					pw.println(newStr);
					//print result on after running
					System.out.println(newStr.toString());
				
				}
			}
			weblog.close();
			bw.close();
			
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
