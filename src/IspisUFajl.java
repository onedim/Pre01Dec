
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class IspisUFajl {
	
	
	public static void main(String[] args) {
		FileWriter fn;
		try{
			fn = new FileWriter(new File("test.txt"));
			fn.append("Evo jedan red");
			fn.append('\n');
			fn.flush();
			fn.append("Drugi red\nTreci red");
			fn.close();
		} catch (IOException e){
			
			e.printStackTrace();
		}
		
	}		
}
	


