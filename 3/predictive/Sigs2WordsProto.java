package predictive;

import java.io.IOException;
import java.util.Collection;

public class Sigs2WordsProto {
	public static void main(String[] args) throws IOException {
		for (String s: args) {
			
            System.out.print(s + " : ");
            Collection<String> list = PredictivePrototype.signatureToWords(s);
            for(String word:list){
            	System.out.print(word + " ");
            }
            System.out.println();
        }
	}
}
