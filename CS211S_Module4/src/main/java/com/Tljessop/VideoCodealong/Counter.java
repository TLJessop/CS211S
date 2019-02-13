package main.java.com.Tljessop.VideoCodealong;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Counter extends Application {

    private Button upButton;
    private Button downButton;
    private Text countText;
    private Text prompt;
    private int count = 0;
    private TextField incField;
    private int chargeRate = 1;
    private Font font = Font.font("Times New Roman", 28);

    @Override
    public void start(Stage primaryStage) {
        VBox mainBox = new VBox();
        mainBox.setStyle("-fx-background-color: darkcyan");
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(20);

        HBox buttonBox = new HBox();
        buttonBox.setPadding(new Insets(20));
        buttonBox.setSpacing(10);
        buttonBox.setAlignment(Pos.BOTTOM_CENTER);

        HBox changeBox = new HBox();
        changeBox.setSpacing(10);
        changeBox.setAlignment(Pos.CENTER);

        incField = new TextField();
        incField.setText("1");
        incField.setMaxWidth(100);

        countText = new Text(Integer.toString(count));
        countText.setFont(font);

        prompt = new Text("Change rate : ");
        prompt.setFont(font);

        upButton = new Button("Up");
        upButton.setFont(font);
        upButton.setOnAction(this::handleButtons);

        downButton = new Button("Down");
        downButton.setFont(font);
        downButton.setOnAction(this::handleButtons);

        buttonBox.getChildren().addAll(upButton,downButton);

        changeBox.getChildren().addAll(prompt,incField);

        mainBox.getChildren().addAll(countText, buttonBox, changeBox);

        Scene scene = new Scene(mainBox,330,300);

        primaryStage.setTitle("Counting Buttons");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private  void handleButtons(ActionEvent e){
        try {
            chargeRate = Integer.parseInt(incField.getText());

        } catch (Exception exception){
            countText.setText("Please give a  whole number");
        }

        if (e.getSource() == upButton){
            count += chargeRate;
        } else {
            count-= chargeRate;
        }
        countText.setText(Integer.toString(count));
    }



}//class
