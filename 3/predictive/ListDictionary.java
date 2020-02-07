package predictive;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ListDictionary {
	private ArrayList<WordSig> dict;

	public ListDictionary() {
		Scanner scan=null;
		dict = new ArrayList<WordSig>();
		try {
		    File file = new File("/usr/share/dict/words");
		    scan = new Scanner(new FileReader(file));
		    String line = null;
		    while (scan.hasNextLine()) {		    	
		    	line=line.toLowerCase();
		    	if(isValidWord(line)) {
		    		dict.add(new WordSig(line));
		    	}
		    }

		} catch (IOException e) {
		    System.out.println("File not found.");
		} finally {
		    scan.close();
		}
	}
	protected static boolean isValidWord(String word){
		word = word.toLowerCase();
		char check;
		for(int i=0; i<word.length(); i++){
			check = word.charAt(i);
			if((check<97 || check>122)){
				return false;
			}
		}
		return true;
	}
}
