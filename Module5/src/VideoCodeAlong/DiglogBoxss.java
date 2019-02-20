package VideoCodeAlong;

import javafx.application.Application;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.InputMismatchException;
import java.util.Optional;

public class DiglogBoxss extends Application {

    private Double inNum, inNum2;

    @Override
    public void start(Stage primaryStage) {

        TextInputDialog inputDialog = new TextInputDialog();

        inputDialog.setHeaderText(null);
        inputDialog.setTitle("Number getter");
        inputDialog.setContentText("Please give a number");

        Optional<ButtonType> repeat;
        do {
            inNum = getNumber(inNum, inputDialog);
            inNum2 = getNumber(inNum2, inputDialog);

            double sum = inNum + inNum2;

            Alert sumAlet = new Alert(Alert.AlertType.INFORMATION);

            sumAlet.setContentText("Sum : " + sum);
            sumAlet.setHeaderText(null);
            sumAlet.showAndWait();

            Alert again = new Alert(Alert.AlertType.CONFIRMATION);
            again.setHeaderText("Again ?");
            again.setContentText(null);
            repeat = again.showAndWait();
            inNum = null;
            inNum2 = null;
        } while (repeat.get() == ButtonType.OK);


    }

    //give a null Double to store input in
    private double getNumber(Double num, TextInputDialog inputDialog){

        while (null == num) {
            Optional<String> input = inputDialog.showAndWait();
            if (input.isPresent()) {
                try {
                    num = Double.parseDouble(input.get());
                } catch (Exception e) {
                    inputDialog.setContentText("That was not a number, Please try again");
                    inputDialog.showAndWait();
                }


            }
            inputDialog.getEditor().clear();
        }
        inputDialog.setContentText("Please give a number");
        return num;
    }

    public static void main(String[] args) {
        launch(args);
    }

}//DiglogBoxss
