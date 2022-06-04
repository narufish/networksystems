import java.io.*;
import java.lang.StringBuffer;

public class advanced21 {

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
				StringBuffer newStr = new StringBuffer(str);
				
				for(int i=0; i< str.length(); i++) {
					if(Character.isLowerCase(str.charAt(i))) {
						newStr.setCharAt(i,Character.toUpperCase(str.charAt(i)));
					}else if(Character.isUpperCase(str.charAt(i))) {
						newStr.setCharAt(i,Character.toLowerCase(str.charAt(i)));
						
					}
				}
				
				
				
				outPrint.println(newStr);
				
			}
			textread.close();
			outPrint.close();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		

	}

}
