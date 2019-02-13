package main.java.com.Tljessop.VideoCodealong;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Averager extends Application {

    private TextField inputField;
    private Text prompt, averageText, minText, maxText, totalText;
    private Button clearButton, calculateButton;
    private double average, min, max, total;
    private List<Double> numList;
    private Font font = Font.font("Times New Roman",15);
    private Font buttonFont = Font.font(10);

    @Override
    public void start(Stage primaryStage) {

        GridPane root = new GridPane();
        root.setStyle("-fx-background-color: powderblue");
        root.setVgap(7.5);

        numList = new ArrayList<>();

        prompt = new Text("Please give numbers to Average : ");
        prompt.setFont(font);

        inputField = new TextField();
        inputField.setOnAction(this::calulateHandler);

        calculateButton = new Button("Calculate");
        calculateButton.setFont(buttonFont);
        calculateButton.setOnAction(this::calulateHandler);

        clearButton = new Button("Clear");
        clearButton.setFont(buttonFont);
        clearButton.setOnAction(this::clearButtonHandler);

        averageText = new Text();
        averageText.setFont(font);

        minText = new Text();
        minText.setFont(font);

        maxText = new Text();
        maxText.setFont(font);

        totalText = new Text();
        totalText.setFont(font);

        TilePane textPane = new TilePane(prompt,inputField);
        textPane.setAlignment(Pos.CENTER);
        textPane.setHgap(10);

        TilePane buttonPane = new TilePane(calculateButton,clearButton,totalText);
        buttonPane.setAlignment(Pos.CENTER_RIGHT);
        buttonPane.setHgap(10);

        TilePane numberPane = new TilePane(averageText, minText, maxText);
        numberPane.setAlignment(Pos.CENTER);
        numberPane.setHgap(10);

        root.add(textPane, 0,0);
        root.add(buttonPane,0,1);
        root.add(numberPane,0,2);

        Scene scene = new Scene(root, 300,200);

        primaryStage.setTitle("Number Average");
        primaryStage.setScene(scene);
        primaryStage.show();
    }//start


    private void clearButtonHandler(ActionEvent e){
        inputField.clear();

        numList.clear();

        averageText.setText("");
        minText.setText("");
        maxText.setText("");
        totalText.setText("");
        prompt.setText("Please give numbers to Average : ");
    }

    private void calulateHandler(ActionEvent e){

        if (inputField.getText() == "") return;



        double userNum = 0;
        try{
            userNum =  Double.parseDouble(inputField.getText());
        } catch (NumberFormatException exception){
            prompt.setText("Please give a number");
            return;
        }
        inputField.clear();
        numList.add(userNum);

        if (numList.isEmpty()){
            prompt.setText("List is empty");
            return;
        }

        min = Collections.min(numList);
        minText.setText("Minimum value given : " + min);

        max = Collections.max(numList);
        maxText.setText("Maximum value give : " + max);


        for (Double num: numList
             ) {
            total += num;

        }

        average = total / (double) numList.size();

        averageText.setText("Average : " + average);
        totalText.setText("Total : " + total);
    }

    public static void main(String[] args) {
        launch(args);
    }//main
}// Averager
