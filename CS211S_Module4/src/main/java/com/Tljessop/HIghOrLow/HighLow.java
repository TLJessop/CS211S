package main.java.com.Tljessop.HIghOrLow;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * This program has the user try to guess a number between 1-100.
 * After guessing the user is told if they guessed too low, too high, or if they guess correctly.
 * When a correct guess is received a reset button will appear
 *
 * @author Thomas Lynn Jessop
 * @since 2019-02-11
 */

public class HighLow extends Application {

    //Instance variables
    private TextField inputBox;
    private Text prompt;
    private Text answer;
    private Button againButton;
    private VBox stacked;
    private int myNum;
    private Font font = Font.font("Times New Roman",15.5);
    //End of Instance variables

    /**
     * This method sets all of the visual elements
     * @param primaryStage This application's only stage
     */
    @Override
    public void start(Stage primaryStage){

        Pane root = new Pane();

        stacked = new VBox();
        stacked.setSpacing(20);
        stacked.setPadding(new Insets(15,15,15,15));


        prompt = new Text("Try to guess my number");
        prompt.setFont(font);
        prompt.setFill(Color.WHITE);


        myNum = (int) ((Math.random() * 100) + 1);

        inputBox = new TextField("Your guess goes here");
        inputBox.setOnAction(this::guessHandler);

        //reset button
        againButton = new Button("Play again?");
        againButton.setFont(font);
        againButton.setOnAction( event -> {
                                myNum = (int) ((Math.random() * 100) + 1);
                                answer.setText("");
                                stacked.getChildren().remove(againButton);
                                });

        answer = new Text("");
        answer.setFont(font);
        answer.setFill(Color.WHITE);

        stacked.getChildren().addAll(prompt,inputBox);
        root.getChildren().add(stacked);


        Scene scene = new Scene(root,300,200);

        root.setStyle("-fx-background-color: lightskyblue");

        primaryStage.setTitle("High or Low");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    /**
     * Action driver
     * @param args
     */
    public static void main(String[] args){
        launch(args);
    }

    /**
     * This method takes the users guess and compares it the random number
     * @param e given from inputBox
     */
    private void guessHandler(ActionEvent e){
        if(stacked.getChildren().contains(answer)){
            stacked.getChildren().remove(answer);
        }
        stacked.getChildren().add(answer);


        try {
            if (Integer.parseInt(inputBox.getText()) == myNum) {
                answer.setText("Great job you guessed the number");
                stacked.getChildren().add(againButton);
            } else if (Integer.parseInt(inputBox.getText()) < myNum) {
                answer.setText("Try guessing higher");
            } else if (Integer.parseInt(inputBox.getText()) > myNum) {
                answer.setText("Try guessing lower");
            }
        } catch (NumberFormatException pareExcepton){
            answer.setText("Please give a whole number value");
            inputBox.clear();
        }

        inputBox.clear();
    }

}//class
