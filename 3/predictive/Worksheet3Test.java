package predictive;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
/**
 * The class is test for Worksheet3.
 *
 * @author Ruopeng Jiang
 * @version 2020-2-10
 */
class Worksheet3Test {

	String[] values = new String[] {"cg","bg","ch","ag","bh","ci","ah","bi","ai"};
	Set<String> exp= new HashSet<String>(Arrays.asList(values));
	Set<String> res= new HashSet<String>();	
	
	//test for PredictivePrototype.wordToSignature
	@Test
	public void test1(){		
		String exp="4663";
		String res=	PredictivePrototype.wordToSignature("home");
		assertEquals(exp,res);
	}
	@Test	
	public void test2() {
		String exp="";
		String res=	PredictivePrototype.wordToSignature("");
		assertEquals(exp,res);
	}
	@Test	
	public void test3() {
		String exp="     ";
		String res=	PredictivePrototype.wordToSignature("#####");
		assertEquals(exp,res);
	}
	@Test	
	public void test4() {
		String exp="22233344455566677778889999";
		String res=	PredictivePrototype.wordToSignature("abcdefghijklmnopqrstuvwxyz");
		assertEquals(exp,res);
	}
	@Test	
	public void test5() {
		String exp="22233344455566677778889999";
		String res=	PredictivePrototype.wordToSignature("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
		assertEquals(exp,res);
	}
	@Test	
	public void test6() {
		String exp="2  2         ";
		String res=	PredictivePrototype.wordToSignature("A$$A)($$$$$$$");
		assertEquals(exp,res);
	}
	//test for PredictivePrototype.signatureToWords
	@Test	
	public void test7()  {
		exp= new  HashSet<String>();
		try {
			res =PredictivePrototype.signatureToWords("");
		} catch (IOException e) {		
			e.printStackTrace();
		}
		assertEquals(exp,res);
	}
	@Test	
	public void test8()  {
		exp= new HashSet<String>(Arrays.asList(values));
		try {
			res =	PredictivePrototype.signatureToWords("24");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(exp,res);
	}
	@Test	
	public void test9() {
		values = new String[] {"t","u","v"};
		exp= new HashSet<String>(Arrays.asList(values));
		try {
			res =	PredictivePrototype.signatureToWords("8");
		} catch (IOException e) {
			e.printStackTrace();
		}
		assertEquals(exp,res);
	}
	@Test	
	public void test10()  {
		exp= new  HashSet<String>();
		try {
			res =PredictivePrototype.signatureToWords("kobe");
		} catch (IOException e) {		
			e.printStackTrace();
		}
		assertEquals(exp,res);
	}
	//test for PredictivePrototype.isValidWord
	@Test	
	public void test11() {
		boolean exp=false;
		boolean res=PredictivePrototype.isValidWord("24");
		assertEquals(exp,res);
	}
	@Test	
	public void test12() {
		boolean exp=true;
		boolean res=PredictivePrototype.isValidWord("kb");
		assertEquals(exp,res);
	}
	//test for WordSig.getSignature
	@Test	
	public void test13() {
		WordSig test=new WordSig("laker");
		String res=test.getSignature();
		String exp="52537";
		assertEquals(exp,res);
	}
	@Test	
	public void test14() {
		WordSig test=new WordSig("Los Angeles");
		String res=test.getSignature();
		String exp="567 2643537";
		assertEquals(exp,res);
	}
	@Test	
	public void test15() {
		WordSig	test=new WordSig("1234567");
		String res=test.getSignature();
		String exp="       ";
		assertEquals(exp,res);
	}
	//test for ListDictionary.signatureToWords
	@Test	
	public void test16()  {
		ListDictionary  test=new ListDictionary("testing.txt");	
		exp= new  HashSet<String>();
		res =	(Set<String>) test.signatureToWords("");
		assertEquals(exp,res);
	}
	@Test	
	public void test17()  {
		ListDictionary  test=new ListDictionary("testing.txt");	
		String[] values = new String[] {"cg","bg","ch","ag","bh","ci","ah","bi","ai"};
		Set<String> exp= new HashSet<String>(Arrays.asList(values));
		Set<String> res= new HashSet<String>();		
		res =	(Set<String>) test.signatureToWords("24");
		assertEquals(exp,res);
	}
	@Test	
	public void test18()  {
		ListDictionary  test=new ListDictionary("testing.txt");	
		exp= new  HashSet<String>();
		res =	(Set<String>) test.signatureToWords("1");
		assertEquals(exp,res);
	}
	//test for ListDictionary.signatureToWords
	@Test	
	public void test19()  {
		WordSig a=new WordSig("a");
		WordSig d=new WordSig("d");
		int res=a.compareTo(a);
		assertEquals(0,res);
	}
	@Test	
	public void test20()  {
		WordSig a=new WordSig("a");
		WordSig d=new WordSig("d");
		int res=a.compareTo(d);
		assertEquals(-1,res);
	}
	@Test	
	public void test21()  {
		WordSig a=new WordSig("a");
		WordSig d=new WordSig("d");
		int res=d.compareTo(a);
		assertEquals(1,res);
	}
}
