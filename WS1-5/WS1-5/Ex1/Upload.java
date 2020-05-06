import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
* In the following I define the Upload class extends Application
* @author Ruopeng Jiang
* @version 2019-11-26
*/
public class Upload extends Application {
    /**
     * The method to create the new Upload icon on the of scene on the stage.
     * @param stage The stage of the Application
     * @throws Exception The exception would be throw when the method can not be called correctly.
     */
  @Override
  public void start(Stage stage) throws Exception{
    Group root = new Group();
    Scene scene = new Scene(root, 260, 80);
    stage.setScene(scene);
	stage.setWidth(250);
	stage.setHeight(250);
    scene.setRoot(root);
    drawTriangle(root);
    drawRectangle(root);
    stage.show();
  }
  /**
   * The method to draw the Triangle of the whole icon.
   * @param root The Group of the scene.
   */
  public static void drawTriangle(Group root){
	Polygon polygon = new Polygon();
	polygon.getPoints().addAll(new Double[]{
	        100.0, 0.0,
	        60.0, 30.0,
	        140.0, 30.0 });
	root.getChildren().add(polygon);
  }
  /**
   * The method to draw the Rectangle of the whole icon.
   * @param root The Group of the scene.
   */
  public void drawRectangle(Group root) {
  
    Rectangle r1 = new Rectangle();
    r1.setX(87);
    r1.setY(30);
    r1.setWidth(27);
    r1.setHeight(80);
    
    Rectangle r2 = new Rectangle();
    r2.setX(0);
    r2.setY(51);
    r2.setWidth(27);
    r2.setHeight(90);
    
    Rectangle r3 = new Rectangle();
    r3.setX(0);
    r3.setY(140);
    r3.setWidth(200);
    r3.setHeight(27);
    
    Rectangle r4 = new Rectangle();
    r4.setX(173);
    r4.setY(51);
    r4.setWidth(27);
    r4.setHeight(90);
    
    root.getChildren().add(r1);
    root.getChildren().add(r2);
    root.getChildren().add(r3);
    root.getChildren().add(r4);
  }
  
  /**
   * The method is to start the App.
   * @param args the parameter of the main method.
   */
  public static void main(String[] args) {
    launch(args);
  }
}