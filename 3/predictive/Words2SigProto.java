package predictive;
/**
 * The class is to call method of PredictivePrototype class
 *
 * @author Ruopeng Jiang
 * @version 2020-2-9
 */
public class Words2SigProto {
	public static void main(String[] args) {
		for (String s: args) {
            System.out.println(s + " : " + PredictivePrototype.wordToSignature(s));
        }
	}
}
