package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;



public class MapDictionary implements Dictionary {
	Map<String, Set<String>> map;
	
	public MapDictionary(String path) {
		addWords(path);
	}
	public Map<String, Set<String>> addWords(String path){
		map = new HashMap<>();
		File file =new File(path);
		BufferedReader reader = null;
      try {
          reader = new BufferedReader(new FileReader(file));
          String line = null;
          while ((line = reader.readLine()) != null) {              
              if (isValidWord(line)) {
            	  line = line.toLowerCase();
                  String signature = wordToSignature(line);
                  if (!map.containsKey(signature)) {
                      map.put(signature, new HashSet<>());
                  }
                  map.get(signature).add(line);
              }
          }
      } catch (IOException e) {
          e.printStackTrace();
      } finally {
          try {
              reader.close();
          } catch (IOException e) {
              e.printStackTrace();
          }
      }
		return map;
	}
	@Override
	public Set<String> signatureToWords(String signature) {
		return map.getOrDefault(signature, new HashSet<>());
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
