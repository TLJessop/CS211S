package VideoCodeAlong;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;

public class RubberLine extends Application {

    private Line mouseLine;
    private Pane root;
    private boolean drawing;

    @Override
    public void start(Stage primaryStage) {

        drawing =false;

        root = new Pane();
        root.setStyle("-fx-background-color: paleturquoise");
        root.setOnMouseClicked(this::clickHandler);
        root.setOnMouseMoved(this::mouseMoveHandler);

        mouseLine = new Line(-10,-10,-10,-10);
        mouseLine.setStrokeWidth(2);

        root.getChildren().add(mouseLine);

        Scene scene = new Scene(root,500,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Click Line");
        primaryStage.show();
    }

    private void clickHandler(MouseEvent clickEvent){
        if(!drawing){
            drawing = true;

            mouseLine.setStartX(clickEvent.getX());
            mouseLine.setStartY(clickEvent.getY());
            mouseLine.setEndX(clickEvent.getX());
            mouseLine.setEndY(clickEvent.getY());


        } else if(drawing) {
            drawing = false;
        }
    }

    private void mouseMoveHandler(MouseEvent moveEvent){
        if(drawing){
            mouseLine.setEndX(moveEvent.getX());
            mouseLine.setEndY(moveEvent.getY());
        } else {

        }
    }

    public static void main(String[] args) {
        launch(args);
    }

}//RubberLine
