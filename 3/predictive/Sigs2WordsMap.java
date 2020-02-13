package predictive;

public class Sigs2WordsMap {

	public static void main(String[] args) {
		MapDictionary md = new MapDictionary("usr/share/dict/words");
		for (String s : args) {
			System.out.println(md.signatureToWords(s));
		}
	}
}
