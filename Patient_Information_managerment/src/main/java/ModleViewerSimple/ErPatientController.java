package ModleViewerSimple;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.List;


public class ErPatientController extends Application {

    //Start of instance variables
    private ErPatientViewer viewer;
    private ErPatient patient;

    public ErPatientController(){
        viewer = new ErPatientViewer();
        viewer.addHandler(this::addHandler);
        viewer.dischrageHandler(this::dischrageHandler);
    }

    private void addHandler(ActionEvent event){
        //Assigned 0 values to keep the ErPatient constructor happy
        int age =0;
        double weight = 0;
        //Used for set the TextInputDialog
        boolean wasInt = true;
        try{

            age = Integer.parseInt(viewer.getAgeValue());
            weight = Double.parseDouble(viewer.getWeightValue());
        } catch (NumberFormatException e){
            e.printStackTrace();
            Alert numberParseError = new Alert(Alert.AlertType.ERROR);
            numberParseError.setTitle(null);
            numberParseError.setHeaderText(null);
            numberParseError.setContentText("A number parse error occurred \nThe number values will be set to 0");
            numberParseError.showAndWait();
        }
        patient = new ErPatient(
                viewer.getFirstName(),
                viewer.getLastName(),
                age,
                weight,
                viewer.getConciuos()
                        );
        patient.setCheifComplaint(viewer.getComplant());
        ErPatient.addPatient(patient);
        writePatientList();

    }//addHandler

    private void dischrageHandler(ActionEvent event){
        ErPatient.removePatient(patient);
        viewer.setOutPut(patient.discharge());
        writePatientList();
    }//dischrageHandler

    //helper method called by the button handlers to avoid repeat code
    private void writePatientList(){
        String listString =Arrays.toString(ErPatient.getList().toArray());
        viewer.setPatientList(listString);
    }//writePatientList

    @Override
    public void start(Stage primaryStage) {

        ErPatientController controller = new ErPatientController();

        Scene scene = new Scene(controller.viewer.getRootNode(),600,600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("ER Patients ");
        primaryStage.show();
    }//start

    public static void main(String[] args) {
        launch(args);
    }//main

}//ErPatientController
