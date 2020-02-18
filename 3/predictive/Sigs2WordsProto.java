package predictive;

import java.io.IOException;
/**
 * The class is to call method of PredictivePrototype class
 *
 * @author Ruopeng Jiang
 * @version 2020-2-9
 */
public class Sigs2WordsProto {
	public static void main(String[] args) throws IOException {
		for (String s: args) {		
	            System.out.println(PredictivePrototype.wordToSignature(s));
        }
	}
}
