import java.util.ArrayList;
import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
/**
* In the following I define the Waffle class extends the class Application
* @author Ruopeng Jiang
* @version 2019-11-26
*/
public class Waffle extends Application{	
	final static double cubeGap=5;// the two cubes gap
	final static double cubeLength=20;// the cube length
	private static String[] description;//store description
	private static ArrayList<Rectangle> cubes;
    /**
     * The method to create a arraylist to store colors.
     * @return colors The arraylist of stored colors..
     */
	public static ArrayList<Color> color() {
		ArrayList<Color> colors = new ArrayList<Color>();
		colors.add(Color.BLACK);
		colors.add(Color.BLUE);
		colors.add(Color.RED);
		colors.add(Color.YELLOW);
		colors.add(Color.GREEN);
		colors.add(Color.BROWN);
		colors.add(Color.MIDNIGHTBLUE);
		colors.add(Color.SKYBLUE);
		colors.add(Color.GOLDENROD);
		colors.add(Color.PURPLE);
		colors.add(Color.CORNSILK);
		colors.add(Color.LIGHTYELLOW);
		colors.add(Color.PERU);
		colors.add(Color.ROYALBLUE);
		return colors;
		}//Cause Similar colors are hard to tell apart,so I set 14 colors.
    /**
     * The method is to crate 100 cunbes for the Waffle chart.
     * @return number The ArrayList which store 100 cubes.
     */
	public static ArrayList<Rectangle> setCube() {
		ArrayList<Rectangle> cubes = new ArrayList<Rectangle>();
		for(int i=0;i<100;i++) {
			Rectangle cube = new Rectangle();
			cubes.add(cube);
		}
		return cubes;
	}

    /**
    /**
     * The method to get cube numbers of corresponding expenditures.
     * @param expenditures The expenditures[] from expenditure class
     * @param maximum The maximum categories of waffle chart display.
     * @return number The arraylist of cube numbers of corresponding expenditures.
     */
	public static ArrayList<Integer> numberOfColor(Expenditure[] expenditures,int maximum) {
		int total=0;
		int temp=0;//temp is stored (maximum-1)  expenditures cube numbers.
		ArrayList<Integer> number = new ArrayList<Integer>();
		for (int i=0;i<expenditures.length;i++) {
			total+=expenditures[i].getValue();
		}
		if (maximum<expenditures.length) {
			for(int i=0;i<maximum-1;i++) {
				number.add((int)(Math.round(1.0*expenditures[i].getValue()/total*100)));	
				temp+=(int)(Math.round(1.0*expenditures[i].getValue()/total*100));
			}
			number.add(100-temp);
		}
		else {
			for(int i=0;i<expenditures.length;i++) {
				number.add((int)(Math.round(1.0*expenditures[i].getValue()/total*100)));
			}
		}
		return number;
	}
    /**
     * The method to get cubes their cooresponding colors.
     * @param expenditures The expenditures[] from expenditure class
     * @param maximum The maximum categories of waffle chart display.
     * @return cubes The arraylist of colored cubes.
     */
	public static ArrayList<Rectangle>  setColor(Expenditure[] expenditures,int maximum){
		int k=0;
		ArrayList<Rectangle> cubes = setCube();
		ArrayList<Color> colors = color();
		ArrayList<Integer> number=numberOfColor(expenditures,maximum);
		for (int i=0;i<maximum;i++) {
			for(int j=0;j<number.get(i);j++,k++) {				
				cubes.get(k).setFill(colors.get(i));
			}			
		}
		return cubes;
	}
    /**
     * @param expenditures The expenditures[] from expenditure class
     * @param maximum The maximum categories of waffle chart display.
     * The method to get cubes their coresponding coordinates.
     */
	public static void drawCubes(Group root) {
		for (int i=0;i<100;i++) {							
				cubes.get(i).setX(cubeGap*(i%10)+cubeLength*(i%10));
				cubes.get(i).setY(100+cubeGap*(i/10)+cubeLength*(i/10));
				cubes.get(i).setWidth(cubeLength);
				cubes.get(i).setHeight(cubeLength);
				root.getChildren().add(cubes.get(i));
			}
		}
    /**
     * The method is to create the description from the array expenditures.
     * @param expenditures The expenditures[] from expenditure class
     * @param maximum The maximum categories of waffle chart display.
     * @return description The String array which store the all Description.
     */
    public static String[] setDescription(Expenditure[] expenditures, int maximum) {
        String[] description = new String[maximum];
        for (int i = 0; i < expenditures.length && i < maximum - 1; i++) {
            description[i] = expenditures[i].getDescription();
        }
        description[maximum - 1] = "Other";
        return description;
    }
    /**
     * The method is to draw the description on the sence.
     * @param root Group of the sence
     * @param description The String array which store the all Description.
     */
    private static void drawtext(Group root) {
        Text text;
        int maximum = description.length;
        ArrayList<Color> colors = color();
        for (int i = 0; i < maximum; i++) {
            Rectangle rectangle = new Rectangle(12*cubeLength+9*cubeGap,100+(1+i)*(cubeLength+cubeGap),cubeLength,cubeLength);
            rectangle.setFill(colors.get(i));
            root.getChildren().add(rectangle);
            text = new Text(13*cubeLength+10*cubeGap,
                    100+(1+i)*(cubeLength+cubeGap)+cubeLength-cubeGap,
                    String.format("%s", description[i]));
            text.setFont(Font.font ("Dialog", 18));
            root.getChildren().add(text);
        }
    }
    /**
     * The method is to display whole chart.
     * @param root Group of the sence
     * @param expenditures The expenditures[] from expenditure class.
     * @param maximum The maximum categories of waffle chart display.
     */
    public static void display(Expenditure[] expenditures,int maximum) {
    	description=setDescription(expenditures, maximum);
    	cubes=setColor(expenditures,maximum);
    }
    /**
     * The method to create the new Waffle on the of scene on the stage.
     * @param stage The stage of the Application
     * @throws Exception The exception would be throw when the method can not be called correctly.
     */
	@Override
	public void start(Stage stage) throws Exception {
		Group root =new Group();	
		Scene scene = new Scene(root, 260, 80);
	    stage.setScene(scene);
	    stage.setTitle("Waffle");
		stage.setWidth(500);
		stage.setHeight(500);
		scene.setRoot(root);
		drawCubes(root);
		drawtext(root);
		stage.show();
    	}
	  /**
	   * The method is to start the App.
	   * @param args the parameter of the main method.
	   */
	public static void main(String[] args) {
		Expenditure[] expenditures =
				new Expenditure[]
				{new Expenditure("Salaries", 11000),
				new Expenditure("Paper", 2000),
				new Expenditure("Rent", 5000),
				new Expenditure(
				"Most popular books on Java etc.",
				10000),
				new Expenditure("Heating", 3000),
				new Expenditure("Coffee/Tea", 7000),
				new Expenditure("Biscuits", 8000),
				new Expenditure("Travel", 18000),
				new Expenditure("Electricity", 1000),
				new Expenditure("Pencils", 3000)
				};
		Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) ->exp2.getValue() - exp1.getValue());
		int maximum=8;
		display(expenditures,maximum);
		launch(args);
	}
}