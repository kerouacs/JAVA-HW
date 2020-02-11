package predictive;

public class WordSig implements Comparable<WordSig>{
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
	public String getWord() {
		return words;
	}
	public String getSignature() {
		return signature;
	}
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
	public String toString() {
		return words + " : " + signature;
	}
	

	public boolean equals(WordSig other) {
		if((this.signature.equals(other.signature))){
			return true;
		}
		return false;
	}
}
