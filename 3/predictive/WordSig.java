package predictive;

public class WordSig {
	private String words;
	private String signature;
	public WordSig (String words) { 
		this.words = words;
		this.signature = PredictivePrototype.wordToSignature(words);
	}
	public WordSig(String words, String signature) {
		super();
		this.words = words;
		this.signature = signature;
	}
	public int compareTo(WordSig ws) {
		return 0;
	}
}
