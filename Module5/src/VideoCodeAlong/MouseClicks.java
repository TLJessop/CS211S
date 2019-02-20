package VideoCodeAlong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class MouseClicks extends Application {

   private Pane root;
   private Text clickText;
   private int clickCount = 0;
   private double lastClickX = 0;
   private double lastClickY = 0;
   private String clickString = "";

    @Override
    public void start(Stage primaryStage) {
        root = new Pane();

        clickText = new Text(clickString);

        root.setOnMouseClicked(this::clickHandler);

        root.getChildren().add(clickText);

        Scene scene = new Scene(root, 500,300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Tracker");
        primaryStage.show();
    }


    private void clickHandler(MouseEvent click){
        clickCount ++;

        lastClickY = click.getY();
        lastClickX = click.getX();

        clickString = "\n"+"There have been : " + clickCount + " clicks" +
                "\nThe last click was at X: " + lastClickX + " Y: " + lastClickY;

        clickText.setText(clickString);

        Circle circle = new Circle(lastClickX,lastClickY,10);
        circle.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        root.getChildren().add(circle);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
