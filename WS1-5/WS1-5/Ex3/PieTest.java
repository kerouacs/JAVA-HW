
import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



/**
 * The following 16 tests for the test of the class Pie.
 *
* @author Ruopeng Jiang
* @version 2019-11-26
 */
class PieTest {
    public static final double Tolerance=0.0000000001;
    private Expenditure[] expenditures = new Expenditure[4];

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
    // testing setAngle()
    @Test
    public void test9() {
    	Double[] Angle=Pie.setAngle(expenditures,4);
    	Double expectedAngle=180.0;
    	Double actualAngle = Angle[0];
    	assertEquals(expectedAngle, actualAngle);
    }
    @Test
    public void test10() {
    	Double[] Angle=Pie.setAngle(expenditures,4);
    	Double expectedAngle=270.0;
    	Double actualAngle = Angle[1];
    	assertEquals(expectedAngle, actualAngle);
    }
    @Test
    public void test11() {
    	Double[] Angle=Pie.setAngle(expenditures,4);
    	Double expectedAngle=324.0;
    	Double actualAngle = Angle[2];
    	assertEquals(expectedAngle, actualAngle);
    }
    @Test
    public void test12() {
    	Double[] Angle=Pie.setAngle(expenditures,4);
    	Double expectedAngle=360.0;
    	Double actualAngle = Angle[3];
    	assertEquals(expectedAngle, actualAngle);
    }
    // testing setDescription()
    @Test
    public void test13() {
    	String[] description=Pie.setDescription(expenditures,4);
    	String expectDescription="a";
    	String actualDescription = description[0];
    	assertEquals(expectDescription, actualDescription);
    }
    @Test
    public void test14() {
    	String[] description=Pie.setDescription(expenditures,4);
    	String expectDescription="b";
    	String actualDescription = description[1];
    	assertEquals(expectDescription, actualDescription);
    }
    @Test
    public void test15() {
    	String[] description=Pie.setDescription(expenditures,4);
    	String expectDescription="c";
    	String actualDescription = description[2];
    	assertEquals(expectDescription, actualDescription);
    }
    @Test
    public void test16() {
    	String[] description=Pie.setDescription(expenditures,4);
    	String expectDescription="Other";
    	String actualDescription = description[3];
    	assertEquals(expectDescription, actualDescription);
    }

}