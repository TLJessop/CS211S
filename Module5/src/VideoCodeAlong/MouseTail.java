package VideoCodeAlong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class MouseTail extends Application {

    Pane root;

    @Override
    public void start(Stage primaryStage) {

        root = new Pane();
        root.setOnMouseMoved(this::tailMaker);

        Scene scene = new Scene(root, 400,400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Mouse Tail");
        primaryStage.show();
    }

    private void tailMaker(MouseEvent event){
        Circle circle = new Circle(event.getX(),event.getY(),19);
        circle.setFill(Color.color(Math.random(),Math.random(),Math.random()));

        if(root.getChildren().size()>500){
            root.getChildren().remove(0);
            root.getChildren().add(circle);
        } else {
            root.getChildren().add(circle);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}//MouseTail
