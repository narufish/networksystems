import java.io.*;

public class problem23 {

	public static void main(String[] args) {
		
		
		try {
			File text = new File(args[0]);
			FileReader textfile = new FileReader(text);
			BufferedReader textread = new BufferedReader(textfile);
			
			FileWriter outFile =  new FileWriter(args[1]);
			BufferedWriter outBuffered = new BufferedWriter(outFile);
			PrintWriter outPrint = new PrintWriter(outBuffered);
			
			while(textread.ready()) {
				String str = textread.readLine();
				outPrint.println(str.toUpperCase());
				
			}
			textread.close();
			outPrint.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		

	}

}
