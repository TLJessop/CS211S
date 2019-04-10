package VideoCodeAlong;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class ColorChangingRectangle extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        VBox root = new VBox();

        Rectangle rectangle = new Rectangle(80,80,Color.BLACK);
        Button colorChange = new Button("Change Color");
        colorChange.setOnAction(e ->{
            rectangle.setFill(Color.color(Math.random(),Math.random(),Math.random()));
        });

        root.getChildren().addAll(rectangle,colorChange);
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);


        Scene scene = new Scene(root,150,150, Color.LIGHTBLUE);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Rectangle app");
        primaryStage.show();
    }
}
