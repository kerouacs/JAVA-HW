package predictive;

/**
 * The class Sigs2WordsTree is to test the class TreeDictionary.
 *
 * Sigs2WordsProto 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m0.938s
 * user    0m1.691s
 * sys     0m0.192s
 *
 * Sigs2WordsList 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m0.353s
 * user    0m0.725s
 * sys     0m0.063s
 *
 * Sigs2WordsMap 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m0.827s
 * user    0m4.156s
 * sys     0m0.073s
 *
 * Sigs2WordsTree 4663 329
 * [hood, ione, ioof, good, hond, inne, gond, hone, hoof, gone, goof, home, gome]
 * [dbw, dax, daw, fax, day, fcy, fay]
 *
 * real    0m1.194s
 * user    0m7.535s
 * sys     0m0.117s
 *
 * @author Ruopeng Jiang
 * @version 2020-2-14
 */
public class Sigs2WordsTree {
	public static void main(String[] args) {
        TreeDictionary td = new TreeDictionary("usr/share/dict/words");
        for (String s: args) {
            System.out.println(td.signatureToWords(s));
        }
    }
}
