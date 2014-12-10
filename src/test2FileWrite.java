

import java.util.Scanner;//svo citanje pisanje u javi
import java.io.File;//stavaranje i ;itanje fajlova
import java.io.FileNotFoundException;

public class test2FileWrite {
	

	public static void main(String[] args) {
		Scanner fin;
		try{
		
		fin=new Scanner (new File("src/test2FileWrite.java"));//citanje iz fajla 
		while (fin.hasNext()){
			System.out.println(fin.nextLine());
		}
	}	catch (FileNotFoundException e){
		e.printStackTrace();
	}	
	}

}
