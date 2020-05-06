import java.util.Arrays;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * The class Pie extends the class Application. 
* @author Ruopeng Jiang
* @version 2019-11-26
 */
public class Pie extends Application {
    private static final int centreX = 350;//the Center X coordinates of the circle
    private static final int centreY = 250;//the Center Y coordinates of the circle
    private static final int GAP = 10;//The GAP between the text and the circle.
    private static final int RADIUS = 100;
    private static String[] description;//store description 
    private static Double[] angle;//store angle
    Line[] lines = new Line[angle.length];//store lines
    Text[] texts = new Text[angle.length];//store texts
    
//	public static ArrayList<Double> setAngle(Expenditure[] expenditures,int maximum) {
//		double total=0;
//		double temp=0;//temp is stored (maximum-1)  expenditures cube numbers.
//		ArrayList<Double> angle = new ArrayList<Double>();
//		for (int i=0;i<expenditures.length;i++) {
//			total+=expenditures[i].getValue();
//		}
//		if (maximum<expenditures.length) {
//			for(int i=0;i<maximum-1;i++) {
//				number.add((double)(Math.round(1.0*expenditures[i].getValue()/total*100*3.6)));	
//				temp+=(double)(Math.round(1.0*expenditures[i].getValue()/total*100*3.6));
//			}
//			number.add(100-temp);
//		}
//		else {
//			for(double i=0;i<expenditures.length;i++) {
//				number.add((double)(Math.round(1.0*expenditures[i].getValue()/total*100*3.6)));
//			}
//		}
//		return angle;
//	}I do not know why use arraylist will cause error when draw text and line.
   
    /**
     * The method is to calculate the certain angle of The corresponding expenditure.
     * @param expenditures all expenditures of the company.
     * @param maximum The maximum category in the table.
     * @return The array which store the certain angle of the expenditure.
     */
    public static Double[] setAngle(Expenditure[] expenditures, int maximum) {
        angle = new Double[maximum];
        int total = 0;
        for (int i=0;i<expenditures.length;i++) {
        	total+=expenditures[i].getValue();
        }
        for (int i = 0; i < maximum ; i++) {
            angle[i] = (double) Math.round(expenditures[i].getValue() * 360.0 / total ) ;
        }
        for (int i = 1; i < maximum; i++) {
            angle[i] += angle[i - 1];// to make the current angle equal to previous angle total
        }
        return angle;
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
     * The method is to draw the circle chart.
     * @param root The group of the sence.
     */
    private void drawPie(Group root) {
        Circle circle = new Circle(centreX, centreY, RADIUS);
        circle.setFill(null);
        circle.setStroke(Color.BLACK);
        root.getChildren().add(circle);
        Line[] lines = new Line[angle.length];
        Text[] texts = new Text[angle.length];
        lines[0] = new Line(centreX, centreY,centreX +RADIUS,centreY);
        texts[0] = new Text(
                centreX+1.2*RADIUS*Math.cos(angle[0]/2*Math.PI/180 ) ,
                centreY-1.2*RADIUS*Math.sin(angle[0]/2*Math.PI/180 ) ,
                String.format("%s", description[0])
        );
        for (int i = 1; i < angle.length; i++) {
            lines[i] = new Line(centreX,centreY,
                    centreX + RADIUS*Math.cos(angle[i-1]*Math.PI/180),
                    centreY - RADIUS*Math.sin(angle[i-1]*Math.PI/180)
            );
            texts[i] = new Text(
                    centreX + 1.2 * RADIUS*Math.cos(
                            (angle[i-1]+angle[i])/2*Math.PI/180 ) ,
                    centreY - 1.2 * RADIUS*Math.sin(
                            (angle[i-1]+angle[i])/2*Math.PI/180 ) ,
                    String.format("%s", description[i])
            );

        }
        root.getChildren().addAll(lines);
        for (int i = 0; i < texts.length; i++) {
            adjustTextPosition(texts[i], i);
        }
        root.getChildren().addAll(texts);
    }

    /**
     * The method is to adjust the position of the text to avoid overlap
     * @param text The position of the text is to adjust.
     * @param i temp varibles
     */
    private void adjustTextPosition(Text text, int i) {
        if (text.getX() >= centreX) {
        	return;
        }
        while (text.getX() + text.getLayoutBounds().getWidth() - centreX >
               RADIUS*Math.cos((angle[i-1]+angle[i])/2*Math.PI / 180 )) {
               text.setX(text.getX()-GAP);
        }
    }

    /**
     *  The method gives values to the static variables angle, description by the
     *  parameter of the method setAngle and setDescription respectively.
     *  @param expenditures The details of the expenditure.
     *  @param maximum The maximum number of points on the polyline.
     */
    private static void display(Expenditure[] expenditures, int maximum) {
        angle = setAngle(expenditures, maximum);
        description = setDescription(expenditures, maximum);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root,550, 450);
        drawPie(root);
        stage.setScene(scene);   
        stage.show();
    }

    /**
     * The method is to start the AppFX.
     * @param args the parameter of the main method.
     */
    public static void main(String[] args) {
        Expenditure[] expenditures = new Expenditure[]{
                new Expenditure("Salaries", 11000),
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
        Arrays.sort(expenditures, (Expenditure exp1, Expenditure exp2) ->
                exp2.getValue() - exp1.getValue());
        int maximum = 8;
        display(expenditures,maximum);
        launch(args);
    }
}