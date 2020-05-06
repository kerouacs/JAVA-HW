
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * The following 16 tests for the test of the class Waffle.
 *
 * @author Ruopeng Jiang
 * @version 2019-11-26
 */
class WaffleTest {
    public static final double Tolerance=0.0000000001;
    private Expenditure[] expenditures = new Expenditure[4];
    ArrayList<Integer> number = new ArrayList<Integer>();
    @BeforeEach
    public void init() {
        Expenditure e1=new Expenditure("a",10000);
        expenditures[0]=e1;
        Expenditure e2=new Expenditure("b",5000);
        expenditures[1]=e2;
        Expenditure e3=new Expenditure("c",3000);
        expenditures[2]=e3;
        Expenditure e4=new Expenditure("d",2000);
        expenditures[3]=e4;
        };

    // testing getDescription()
    @Test
    public void test1() {
        String expectedDescription = "a";
        String actualDescription = expenditures[0].getDescription();
        assertEquals(expectedDescription, actualDescription);
      }

    @Test
    public void test2() {
        String expectedDescription = "b";
        String actualDescription = expenditures[1].getDescription();
        assertEquals(expectedDescription, actualDescription);
      }

    @Test
    public void test3() {
        String expectedDescription = "c";
        String actualDescription = expenditures[2].getDescription();
        assertEquals(expectedDescription, actualDescription);
      }

    @Test
    public void test4() {
        String expectedDescription = "d";
        String actualDescription = expenditures[3].getDescription();
        assertEquals(expectedDescription, actualDescription);
      }
    // testing getValue()
    @Test
    public void test5() {
        int expectedDescription = 10000;
        int actualDescription = expenditures[0].getValue();
        assertEquals(expectedDescription, actualDescription);
      }
    @Test
    public void test6() {
        int expectedDescription = 5000;
        int actualDescription = expenditures[1].getValue();
        assertEquals(expectedDescription, actualDescription);
      }
    @Test
    public void test7() {
        int expectedDescription = 3000;
        int actualDescription = expenditures[2].getValue();
        assertEquals(expectedDescription, actualDescription);
      }
    @Test
    public void test8() {
        int expectedDescription = 2000;
        int actualDescription = expenditures[3].getValue();
        assertEquals(expectedDescription, actualDescription);
     }
    // testing numberOfColor()
    @Test
    public void test9() {
    	ArrayList<Integer> number=Waffle.numberOfColor(expenditures,4);
    	int expectednumber=50;
    	int actualnumber = number.get(0);
    	assertEquals(expectednumber, actualnumber);
    }
    @Test
    public void test10() {
    	ArrayList<Integer> number=Waffle.numberOfColor(expenditures,4);
    	int expectednumber=25;
    	int actualnumber = number.get(1);
    	assertEquals(expectednumber, actualnumber);
    }
    @Test
    public void test11() {
    	ArrayList<Integer> number=Waffle.numberOfColor(expenditures,4);
    	int expectednumber=15;
    	int actualnumber = number.get(2);
    	assertEquals(expectednumber, actualnumber);
    }
    @Test
    public void test12() {
    	ArrayList<Integer> number=Waffle.numberOfColor(expenditures,4);
    	int expectednumber=10;
    	int actualnumber = number.get(3);
    	assertEquals(expectednumber, actualnumber);
    }
    // testing setDescription()
    @Test
    public void test13() {
    	String[] description=Waffle.setDescription(expenditures,4);
    	String expectDescription="a";
    	String actualDescription = description[0];
    	assertEquals(expectDescription, actualDescription);
    }
    @Test
    public void test14() {
    	String[] description=Waffle.setDescription(expenditures,4);
    	String expectDescription="b";
    	String actualDescription = description[1];
    	assertEquals(expectDescription, actualDescription);
    }
    @Test
    public void test15() {
    	String[] description=Waffle.setDescription(expenditures,4);
    	String expectDescription="c";
    	String actualDescription = description[2];
    	assertEquals(expectDescription, actualDescription);
    }
    @Test
    public void test16() {
    	String[] description=Waffle.setDescription(expenditures,4);
    	String expectDescription="Other";
    	String actualDescription = description[3];
    	assertEquals(expectDescription, actualDescription);
    }

}