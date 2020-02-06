package predictive;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PredictivePrototype {
	/**
	 * Keyboard layout for phone. +----+----+----+ | 1 | 2 | 3 | | |abc |def |
	 * +----+----+----+ | 4 | 5 | 6 | |ghi |jkl |mno | +----+----+----+ | 7 | 8 | 9
	 * | |pqrs|tuv |wxyz| +----+----+----+
	 * 
	 */
	/**
	 * The method takes a word and returns a numeric signature 
	 * The reason why String Buffer more efficient : 
	 * Because String invariability causes strings to be created repeatedly during String manipulation
	 * 
	 * @param word A String containing a single word
	 * @return A string representing the numeric signature of word
	 */
	public static String wordToSignature(String word) {
		StringBuffer buffer = new StringBuffer();
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++) {
			char c = word.charAt(i);
			if (c == 'a' || c == 'b' || c == 'c') {
				buffer.append('2');
			} else if (c == 'd' || c == 'e' || c == 'f') {
				buffer.append('3');
			} else if (c == 'g' || c == 'h' || c == 'i') {
				buffer.append('4');
			} else if (c == 'j' || c == 'k' || c == 'l') {
				buffer.append('5');
			} else if (c == 'm' || c == 'n' || c == 'o') {
				buffer.append('6');
			} else if (c == 'p' || c == 'q' || c == 'r' || c == 's') {
				buffer.append('7');
			} else if (c == 't' || c == 'u' || c == 'v') {
				buffer.append('8');
			} else if (c == 'w' || c == 'x' || c == 'y' || c == 'z') {
				buffer.append('9');
			} else {
				return " ";
			}
		}
		return buffer.toString();
	}

	public static Set<String> signatureToWords(String signature) throws IOException {
		HashSet<String> match = new HashSet<String>();
		Scanner scan = null;
		try {
		    File file = new File("/usr/share/dict/words");
		    scan = new Scanner(new FileReader(file));
		    String line = null;
		    while (scan.hasNextLine()) {		    	
		    	if(line.length()==signature.length() && isValidWord(line)){
		    		if(wordToSignature(line).equals(signature)){
		    			line = line.toLowerCase();
		    			if(!(match.contains(line)))
		    				match.add(line);
		    		}
		    	}
		    }

		} catch (IOException e) {
		    System.out.println("Words file not found.");
		} finally {
		    scan.close();
		}
		return match;		
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

	public static void main(String[] args) {
		System.out.println(wordToSignature("home"));
		
	}
}
