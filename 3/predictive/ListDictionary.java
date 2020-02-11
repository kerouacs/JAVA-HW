package predictive;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ListDictionary implements Dictionary{
	private ArrayList<WordSig> dict;

	public ListDictionary() {
		dict = new ArrayList<>();
        File file =
                new File("usr/share/dict/words");
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                if (isValidWord(line)) {
                    String linesignature = wordToSignature(line);
                    dict.add(new WordSig(line, linesignature));
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
        Collections.sort(dict);
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
	
	public String wordToSignature(String word) {
        if (word == null || word.length() == 0) {
            return " ";
        }

        StringBuffer sb = new StringBuffer();
        for (char c: word.toCharArray()) {
            if (c == 'a' || c == 'b' || c == 'c') {
                sb.append(2);
            } else if (c == 'd' || c == 'e' || c == 'f') {
                sb.append(3);
            } else if (c == 'g' || c == 'h' || c == 'i') {
                sb.append(4);
            } else if (c == 'j' || c == 'k' || c == 'l') {
                sb.append(5);
            } else if (c == 'm' || c == 'n' || c == 'o') {
                sb.append(6);
            } else if (c == 'p' || c == 'q' || c == 'r' || c == 's') {
                sb.append(7);
            } else if (c == 't' || c == 'u' || c == 'v') {
                sb.append(8);
            } else if (c == 'w' || c == 'x' || c == 'y' || c == 'z') {
                sb.append(9);
            }
        }
        return sb.toString();
    }
	@Override
	public Collection<String> signatureToWords(String signature) {
		Set<String> res = new HashSet<>();
        WordSig ws = new WordSig("", signature);
        int index = Collections.binarySearch(dict, ws);
        int max = dict.size();
        if (index >= 0) {
            int tempindex = index;
            while (tempindex >= 0 && dict.get(tempindex).getSignature().equals(signature)) {
                res.add(dict.get(tempindex).getWord());
                tempindex--;
            }
            tempindex = index;
            while (tempindex < max && dict.get(tempindex).getSignature().equals(signature)) {
                res.add(dict.get(tempindex).getWord());
                tempindex++;
            }
        }
        return res;
	}

}
