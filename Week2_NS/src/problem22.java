import java.io.*;

public class problem22 {
	

	public static void main(String[] args) {
		String str = "Information Networking Laboratory";
		
		try {
			FileWriter outFile =  new FileWriter(args[0]);
			BufferedWriter outBuffered = new BufferedWriter(outFile);
			PrintWriter outPrint = new PrintWriter(outBuffered);
			
			outPrint.println(str);
			outPrint.close();
			
			
			
		}catch(Exception e) {
			System.out.println("Error detected.");
			e.printStackTrace();
			
		}
	}

}
