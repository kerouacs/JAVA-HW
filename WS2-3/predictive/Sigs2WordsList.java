package predictive;

/**
 * The class is to call method of ListDictionary class
 * It is much faster than PredictivePrototype especially the number is large.The run time is 1103ms.
 * @author Ruopeng Jiang
 * @version 2020-2-9
 */
public class Sigs2WordsList {
	    public static void main(String[] args) {
	        ListDictionary ld = new ListDictionary("usr/share/dict/words");
	        for (String s: args)
	            System.out.println(ld.signatureToWords(s));
	        
//	        for(WordSig s:ld.dict) {
//	        	System.out.println(s);
//	        }
	}
}
	
