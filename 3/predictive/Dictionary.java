package predictive;

import java.util.Collection;
/**
 * The class is a interface for Dictionary.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-9
 */
public interface Dictionary {
	public Collection<String> signatureToWords(String signature);
}
