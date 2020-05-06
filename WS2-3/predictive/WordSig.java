package predictive;
/**
 * The class is to get pairs of words and signature.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-9
 */
public class WordSig implements Comparable<WordSig>{
	private String words;
	private String signature;
	/**
	 * Constructs an WordSig.
	 * @param word A string containing a single word.
	 */
	public WordSig (String words) { 
		this.words = words;
		this.signature = PredictivePrototype.wordToSignature(words);
	}
	/**
	 * Constructs an WordSig.
	 * @param word A string containing a single word.
	 */
	public WordSig(String words, String signature) {
		super();
		this.words = words;
		this.signature = signature;
	}
	/**
	 * Returns a String of the word contained in WordSig Object
	 * @return A String
	 */
	public String getWords() {
		return words;
	}
	/**
	 * Returns a String of the signature contained in WordSig Object
	 * @return A String
	 */
	public String getSignature() {
		return signature;
	}
	/**
	 *
	 * This method is to Return -1, 0, 1 as this WordSig's signature is less than, equal to or greater than
	 * the specified WordSig's signature.
	 * @param ws A WordSig Object
	 * @return A -1, 0, 1 as this WordSig's signature is less than, equal to or larger than
	 * the specified WordSig's signature.
	 */
	public int compareTo(WordSig ws){		
		if(this.signature.length()<ws.signature.length()){
			return -1;
		}else if(this.signature.length()>ws.signature.length()){
			return 1;
		}else{
			return this.signature.compareTo(ws.signature);
		}				
	}
	@Override
	/**
	 * This method returns a string representing the word and signature of the WordSig Object.
	 */
	public String toString() {
		return words + " : " + signature;
	}
	/**
	 * Compares this WordSig's signature with given WordSig's signature.
	 * @param other A WordSig Object
	 * @return If signatures of the two WordSig's are equal returns true, else false.
	 */
	public boolean equals(WordSig other) {
		if((this.signature.equals(other.signature))){
			return true;
		}
		return false;
	}
}
