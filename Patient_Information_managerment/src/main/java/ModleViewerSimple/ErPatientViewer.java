package ModleViewerSimple;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ErPatientViewer {
    //Start of instance variables
    private BorderPane rootNode;
    private Text fristNamePrompt, lastNamePrompt,agePrompt
            ,concioosPrompt,complantPrompt,outPut,listTile,patientList, weightPrompt;
    private TextField fNameField, lNameField, ageField, weightField;
    private TextArea  complant;
    private CheckBox conciuosCheck;
    private Button addPatienntButton, dischrageButton;
    //End of instance variables

    //Constructor
    public ErPatientViewer() {

        rootNode = new BorderPane();
        rootNode.setPadding(new Insets(15));
        GridPane inputsAndPrompts = new GridPane();
        inputsAndPrompts.setVgap(7.5);
        inputsAndPrompts.setHgap(5);
        VBox listBox = new VBox();
        VBox buttionBox = new VBox();




        rootNode.setLeft(buttionBox);
        rootNode.setRight(listBox);
        addPatienntButton = new Button("Add Patient");
        dischrageButton = new Button("Discharge");

        //Text assignment
        fristNamePrompt = new Text("First Name :");
        lastNamePrompt = new Text("Last Name : ");
        agePrompt = new Text("Age :");
        weightPrompt = new Text("Weight :");
        concioosPrompt = new Text("Is the patient conscious :");
        complantPrompt = new Text("Describe the patient's chief complaint(s) :");
        listTile = new Text("Current Patients");
        listTile.setFont(Font.font(20));
        patientList = new Text("");
        outPut = new Text("");

        fNameField = new TextField();
        fNameField.setPrefWidth(30);
        lNameField = new TextField();
        ageField = new TextField();
        weightField = new TextField();
        complant = new TextArea();
        conciuosCheck = new CheckBox();

        buttionBox.getChildren().addAll(addPatienntButton,dischrageButton);

        listBox.getChildren().addAll(listTile,patientList);
        rootNode.setBottom(outPut);
        rootNode.setCenter(inputsAndPrompts);

        inputsAndPrompts.add(fristNamePrompt,0,0);
        inputsAndPrompts.add(fNameField,1,0);
        inputsAndPrompts.add(lastNamePrompt,0,1);
        inputsAndPrompts.add(lNameField,1,1);
        inputsAndPrompts.add(agePrompt,0,2);
        inputsAndPrompts.add(ageField,1,2);
        inputsAndPrompts.add(weightPrompt,0,3);
        inputsAndPrompts.add(weightField,1,3);
        inputsAndPrompts.add(concioosPrompt,0,4);
        inputsAndPrompts.add(conciuosCheck,1,4);
        inputsAndPrompts.add(complantPrompt,0,5);
        inputsAndPrompts.add(complant,1,5);
    }//ErPatientViewer Constructor

    //Communication methods
    public String getFirstName(){
        return fNameField.getText();
    }

    public String getLastName(){
        return lNameField.getText();
    }

    public String getAgeValue(){
        return ageField.getText();
    }

    public String getWeightValue(){
        return weightField.getText();
    }

    public String getComplant(){
        return complant.getText();
    }

    public boolean getConciuos(){
        return conciuosCheck.isSelected();
    }
    public void setOutPut(String outPut){
        this.outPut.setText(outPut);
    }
    public void setPatientList(String listOfPatients){
        patientList.setText(listOfPatients);
    }
    public void addHandler(EventHandler<ActionEvent> handler){
        addPatienntButton.setOnAction(handler);
    }
    public void dischrageHandler(EventHandler<ActionEvent> handler){
        dischrageButton.setOnAction(handler);
    }
    public Pane getRootNode(){
        return rootNode;
    }
    //Communication methods
 }//ErPatientViewer
