package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * The class is to use the digits 1-9 to simulate the dialing phone numbers.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-8
 */
public class PredictivePrototype {

	/**
	 * The reason why String Buffer more efficient : 
	 * Because String invariability causes strings to be created repeatedly during String manipulation
	 * And StringBuffer can be modified(such as append operation) multiple times without
     * generating new objects.
     * 
	 * The method takes a word and returns a numeric signature 
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
				buffer.append(' ');
			}
		}
		return buffer.toString();
	}
	/**
	 * This method is inefficient because it has to open the file 'words' and 
	 * check every word in the file.IO processes are quite slow.
	 * 
	 * This method is to the given numeric signature and returns a set of 
	 * possible matching words from the dictionary.
     * @param signature The input of the numeric signature.
     * @return The set of possible matching words from the dictionary.
	 */
	public static Set<String> signatureToWords(String signature) throws IOException {
        Set<String> res = new HashSet<String>();
        try {
            Scanner sc = new Scanner(new File("usr/share/dict/words"));
            while (sc.hasNext()) {
            	String line = sc.nextLine().toLowerCase();
                if (line.length() == signature.length()
                        && isValidWord(line)
                        && signature.equals(wordToSignature(line))) {
                    res.add(line);
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return res;
}
	/**
	 * This method returns a boolean indicating that the given string is a valid word
	 * @param word A string containing a single word.
	 * @return A boolean indicating whether the word given is valid.
	 */
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