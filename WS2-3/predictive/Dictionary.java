package predictive;

import java.util.Set;
/**
 * The class is a interface for Dictionary.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-9
 */
public interface Dictionary {
	public Set<String> signatureToWords(String signature);
}
