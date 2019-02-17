package VideoCodeAlong;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class RectangleTransformations extends Application {
    private Rectangle[] rectangles = new  Rectangle[50];
    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();
        Group recGroup = new Group();


        for (int i = 0; i < rectangles.length ; i++) {
            rectangles[i] = new Rectangle(100,100, Color.TRANSPARENT);
            rectangles[i].setTranslateX(i*5);
            rectangles[i].setTranslateY(i*5);
            rectangles[i].setStroke(Color.color(Math.random(),Math.random(),Math.random()));
            rectangles[i].setStrokeWidth(5);
            rectangles[i].setRotate(Math.random() * 361);
            rectangles[i].setScaleX(Math.random());
            rectangles[i].setScaleY(Math.random());
            recGroup.getChildren().add(rectangles[i]);

        }

        root.getChildren().add(recGroup);

        Scene scene = new Scene(root,300,300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectangles");
        primaryStage.show();

    }

    public static void main(String[] args){
        launch(args);
    }
}//Class RectangleTransformations 
