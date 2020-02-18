package predictive;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
/**
 * This class has a dictionary that stores words and signatures in Tree.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-13
 */
public class TreeDictionary implements Dictionary {
	private treeNode root;
	/**
	 * This class defines a tree node stores the words
	 */
	class treeNode{
		Set<String> words;
		treeNode[] branchs;
		/**
		 * The constructor of treeNode class.
		 */
		public treeNode() {
			branchs = new treeNode[8];
			words = new HashSet<>();
		}
	}
	/**
	 * This method is a constructor to create new treeDictionary Object. It stores to a
	 * tree for the words and signatures.
	 * 
	 * @param file path
	 */
	public TreeDictionary(String path) {
		addWords(path);
	}
	/**
	 * This method is use to add words and signature to a new treeDictionary 
	 * 
	 * @param file path
	 */
	public void addWords(String path){
		root = new treeNode();
		try (Scanner sc = new Scanner(new File(path))){			
			String line = null;
			while(sc.hasNext()) {
				line = sc.nextLine();
				line = line.toLowerCase();
				if(isValidWord(line)) {
					String signature = wordToSignature(line);
					treeNode cur = root;
					for(int i=0;i<signature.length();i++) {
						int num = Integer.parseInt(signature.substring(i,i+1));
						if(cur.branchs[num-2] == null) {
							cur.branchs[num-2] = new treeNode();
						}//treeNode is to store the word of the line if it is the leaf node. 
						cur = cur.branchs[num-2];
						cur.words.add(line);
					}
				}
			}		
		} catch (FileNotFoundException e) {
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
	 * possible matching words from the dictionary.
     * @param signature The input of the numeric signature.
     * @return The set of possible matching words from the dictionary.
	 */
	public Set<String> signatureToWords(String signature) {
		treeNode cur = root;
        Set<String> result = new HashSet<String>();
        for(int i=0;i<signature.length();i++) {
			int num = Integer.parseInt(signature.substring(i,i+1));
			if(cur.branchs[num-2] == null) {
				return new HashSet<String>();
			}else {
				cur = cur.branchs[num-2];
			}
        }
		for(String s : cur.words) {
			if(s.length() > signature.length()) {
				result.add(s.substring(0,signature.length()));
			}else {
				result.add(s);
			}
		}
		return result;
	}
}
