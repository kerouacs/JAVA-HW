package predictive;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This class has a dictionary that stores words and signatures in Map.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-12
 */
public class MapDictionary implements Dictionary {
	private Map<String, Set<String>> dict;
	/**
	 * This method is a constructor to create new MapDictionary Object. It stores to a
	 * map for the words and signatures.
	 * 
	 * @param file path
	 */
	public MapDictionary(String path) {
		addWords(path);
	}
	/**
	 * This method is use to add words and signature to a new MapDictionary 
	 * 
	 * @param file path
	 */
	public Map<String, Set<String>> addWords(String path){
		dict = new HashMap<>();		
      try (BufferedReader reader= new BufferedReader(new FileReader(path))){
//          reader = new BufferedReader(new FileReader(file));
          String line;
          while ((line = reader.readLine()) != null) {              
              if (isValidWord(line)) {
            	  line = line.toLowerCase();
                  String signature = wordToSignature(line);
                  if (!dict.containsKey(signature)) {
                	  dict.put(signature, new HashSet<>());
                  }
                  dict.get(signature).add(line);
              }
          }
      } catch (FileNotFoundException e) {
          e.printStackTrace();
      } catch (IOException e) {
		 	e.printStackTrace();
		}
//      } finally {
//          try {
//              reader.close();
//          } catch (IOException e) {
//              e.printStackTrace();
//          }
      
		return dict;
	}
	@Override
	/**
	 * This method is to the given numeric signature and returns a set of 
	 * possible matching words from the dictionary.
     * @param signature The input of the numeric signature.
     * @return The set of possible matching words from the dictionary.
	 */
	public Set<String> signatureToWords(String signature) {
		return dict.getOrDefault(signature, new HashSet<>());
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
}
