package com.Tljessop.HomeWork;

import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.event.*;
import javafx.geometry.Pos;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class CustomerInput extends Application {

    private Stage primaryStage;
    private Text statusText, resultText;
    private Button uploadButton;

    private final static Font RESULT_FONT = Font.font("Helvetica", 24);
    private final static Font INPUT_FONT = Font.font("Helvetica", 20);

    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;

        VBox primaryBox = new VBox();
        primaryBox.setAlignment(Pos.CENTER);
        primaryBox.setSpacing(20);
        primaryBox.setStyle("-fx-background-color: white");

        VBox uploadBox = new VBox();
        uploadBox.setAlignment(Pos.CENTER);
        uploadBox.setSpacing(20);
        Text uploadLabel = new Text("Upload a comma-separated file with customer data.");
        uploadLabel.setFont(INPUT_FONT);
        uploadButton = new Button("Upload data");
        uploadButton.setOnAction(this::processDataUpload);

        uploadBox.getChildren().add(uploadLabel);
        uploadBox.getChildren().add(uploadButton);
        primaryBox.getChildren().add(uploadBox);

        VBox resultsBox = new VBox();
        resultsBox.setAlignment(Pos.CENTER);
        resultsBox.setSpacing(20);
        statusText = new Text("");
        statusText.setVisible(false);
        statusText.setFont(RESULT_FONT);
        statusText.setFill(Color.RED);
        resultText = new Text("");
        resultText.setVisible(false);
        resultText.setFont(RESULT_FONT);
        resultsBox.getChildren().add(statusText);
        resultsBox.getChildren().add(resultText);
        primaryBox.getChildren().add(resultsBox);

        Scene scene = new Scene(primaryBox, 475, 200, Color.TRANSPARENT);
        primaryStage.setTitle("Customer Data Upload");
        primaryStage.setScene(scene);
        //I found this property to be an issue in testing, so I disabled it
       // primaryStage.setResizable(false);
        primaryStage.show();
    }

    private void processDataUpload(ActionEvent event) {
        statusText.setVisible(false);
        resultText.setVisible(false);
        FileChooser fileChooser = new FileChooser();
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("CSV files (*.csv)", "*.csv");
        fileChooser.getExtensionFilters().add(extFilter);
        File file = fileChooser.showOpenDialog(primaryStage);
        parseFile(file);

    }

    private void parseFile(File file) {

        if(file == null){
            setError("Upload failed");
        } else {

            List<Customer> customers = new ArrayList<>();

            //counter used for more helpful error messages
            int parsedLines = 0;

            int totalOrders = 0;

            boolean exceptionFlag = false;

            try (FileReader fileReader = new FileReader(file)) {
                Scanner fileScanner = new Scanner(fileReader);

                while (fileScanner.hasNext()) {

                    Scanner lineScaner = new Scanner(fileScanner.nextLine());
                    lineScaner.useDelimiter(",");

                     String customerId = lineScaner.next();

                     //Throws custom error if the customer id hold any character that is not alphanumeric or whitespace
                     if(customerId.matches(".*[^\\w\\s].*")){
                        System.out.println("regx");
                         throw new IllegalCharacterException(parsedLines+1);
                     }

                    int orderNumber = Integer.parseInt(lineScaner.next());

                   //Getting to this code means that we can be reasonably sure of data integrity
                    Customer customer = new Customer(customerId,orderNumber);
                    System.out.println(customerId);
                    customers.add(customer);
                    System.out.println(Arrays.toString(customers.toArray()));
                    parsedLines++;
                }
            } catch (NumberFormatException e) {
                exceptionFlag=true;
                setError("An invalid order number was found on line :" + (parsedLines + 1));
            } catch (IOException e) {
                exceptionFlag = true;
                setError("An IOException occurred");
            }catch (NoSuchElementException e){
                exceptionFlag = true;
                setError("Missing field while parsing line" + (parsedLines+1));
            } catch (IllegalCharacterException e){
                exceptionFlag = true;
                setError(e.getMessage());
            }

           // Positive data set actions
            if(!exceptionFlag) {
                for (Customer customer : customers) {
                    totalOrders += customer.getNumberOfOrders();
                }

                statusText.setVisible(true);
                statusText.setText("Secessfulliy created " + customers.size() + " customer objects");
                statusText.setFill(Color.BLUE);

                resultText.setVisible(true);
                resultText.setText("There a " + totalOrders + " total orders in this data set");

                uploadButton.setDisable(true);
            }
        }//else file is null
    }//parseFile

    private void setError(String errorMessage){
        statusText.setText(errorMessage);
        statusText.setVisible(true);
    }

    public static void main(String[] args) {
        launch(args);
    }

}