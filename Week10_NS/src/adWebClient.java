import java.io.*;
import java.net.*;
import java.util.*;

public class adWebClient {
	
	public static void main(String[] args) throws MalformedURLException{
		if(args.length<4) {
			throw new IllegalArgumentException("Parameter(s): <url> <request file> <output file> <port>");
		}

		String hostname = args[0];//URL
		String path = args[2];//path to output file
		int port = Integer.parseInt(args[3]);
		try(Socket socket = new Socket(hostname, port)){

			BufferedReader br = new BufferedReader(new FileReader(new File(args[1])));//from file
			BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//from server
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));//request to server
			FileWriter write = new FileWriter(path,true);
			PrintWriter print_response = new PrintWriter(write);//to file
			String Reqline;//input file string
			
			System.out.println("Connected to server. .sending echo string");
			
			Reqline = br.readLine();//read first line
			StringTokenizer parse = new StringTokenizer(Reqline);
			String method = parse.nextToken().toUpperCase();
			String fileRequested = parse.nextToken().toLowerCase();
			String version = parse.nextToken().toUpperCase();
			String request = method + " " + fileRequested + " " + version;
			
			bw.write(request + "\r\n");
			System.out.println(request);
			
			String header;//second line onwards
			while((header=br.readLine())!=null) {;
				bw.write(header);
				bw.write("\r\n");
				bw.flush();
				System.out.println(header);
			}
			bw.flush();
			
			System.out.println("Received:");
			int sum = 0;//sum of bytes received
			String line;
			while((line=in.readLine())!=null){
				System.out.println(line);
				print_response.println(line);
				sum += line.getBytes().length;
			}
			System.out.println("Received: " + sum + " bytes");
			
			br.close();
			in.close();
			bw.close();
			print_response.close();
			socket.close();
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}	
	}

}
