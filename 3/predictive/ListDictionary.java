package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
/**
 * This class has a dictionary that stores words and signatures in an ArrayList.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-9
 */
public class ListDictionary implements Dictionary{
	public ArrayList<WordSig> dict= new ArrayList<>();;
	/**
	 * This method is a constructor to create new ListDictionary Object. It stores to a
	 * ArrayList for the words and signatures to be stored as pairs in WordSig.
	 * 
	 * @param file path
	 */
	public ListDictionary(String path) {
		addWords(path);
		Collections.sort(dict);
    }
	/**
	 * This method is use to add words and signature to a new MapDictionary 
	 * 
	 * @param file path
	 */
	public void addWords(String path) {   
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (isValidWord(line)) {
                    String linesignature = wordToSignature(line);
                    dict.add(new WordSig(line, linesignature));
                }
            }
        } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
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

	/**
	 * The method takes a word and returns a numeric signature 
	 * @param word A String containing a single word
	 * @return A string representing the numeric signature of word
	 */
	public String wordToSignature(String word) {
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
	@Override
	/**
	 * This method is to the given numeric signature and returns a set of 
	 * possible matching words from the dictionary.Use binary search
     * @param signature The input of the numeric signature.
     * @return The set of possible matching words from the dictionary.
	 */
	public Set<String> signatureToWords(String signature) {
		Set<String> res = new HashSet<>();
        WordSig ws = new WordSig("", signature);
        int index = Collections.binarySearch(dict, ws);
        int max = dict.size();
        if (index >= 0) {
            int temp = index;
            while (temp >= 0 && dict.get(temp).getSignature().equals(signature)) {
                res.add(dict.get(temp).getWords());
                temp--;
            }
            temp = index;
            while (temp < max && dict.get(temp).getSignature().equals(signature)) {
                res.add(dict.get(temp).getWords());
                temp++;
            }
        }
        return res;
	}
}
