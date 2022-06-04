import java.io.*;
import java.io.FileReader;

public class problem21 {
	
	

	public static void main(String[] args) {
		
		try {
			File text = new File(args[0]);
			FileReader textfile = new FileReader(text);
			BufferedReader textread = new BufferedReader(textfile);
			
			while(textread.ready()) {
			String str = textread.readLine();
			System.out.println(str);
			
			}
			textfile.close();
			
			
		}catch(Exception e) {
			System.out.println("Error detected.");
			e.printStackTrace();
			
		}

	}

}
