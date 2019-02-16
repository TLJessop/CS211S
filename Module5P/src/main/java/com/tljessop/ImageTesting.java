package com.tljessop;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImageTesting extends Application {


    @Override
    public void start(Stage primaryStage) {
        Pane root = new Pane();

        Image image = new Image("com/Tljessop/images/girl.png");
       ImageView view = new ImageView(image);

        root.getChildren().add(view);

        Scene scene = new Scene(root,300,300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}//Class ImageTesting
