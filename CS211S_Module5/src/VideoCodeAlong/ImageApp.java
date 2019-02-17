package VideoCodeAlong;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImageApp extends Application {

    private Image[] puppyPics;
    private ImageView puppyViewer;
    private CheckBox discriptionCheck;
    private Button nextButton;
    private Text imageDiscripton;
    private VBox mainBox;
    private HBox controllBox;
    private String[] descriptons;
    private Font font = Font.font(12.5);
    private double spacing = 10;
    private int index = 0;

    @Override
    public void start(Stage primaryStage) {

        mainBox = new VBox();
        mainBox.setAlignment(Pos.CENTER);
        mainBox.setSpacing(spacing);
        mainBox.setStyle("-fx-background-color: powderblue");

        controllBox = new HBox();
        controllBox.setAlignment(Pos.BOTTOM_CENTER);
        controllBox.setSpacing(spacing);
        controllBox.setStyle("-fx-background-color: powderblue");

        descriptons = new String[8];
        descriptons[0] = "The best wake-up call";
        descriptons[1] = "A new barkTec storage solution";
        descriptons[2] = "A deep thought to wonder";
        descriptons[3] = "My favorite co-worker";
        descriptons[4] = "Some healthily skepticism";
        descriptons[5] = "The cutest hipster";
        descriptons[6] = "The world's most interesting puppy";
        descriptons[7] = "Questionable investment advice";

        puppyPics = new Image[8];
        puppyPics[0] = new Image("VideoCodeAlong/Images/puppyCall.jpg",300,300,true,true);
        puppyPics[1] = new Image("VideoCodeAlong/Images/megabitePuppy.jpg",300,300,true,true);
        puppyPics[2] = new Image("VideoCodeAlong/Images/teddybearPuppy.jpg",300,300,true,true);
        puppyPics[3] = new Image("VideoCodeAlong/Images/snugglesEmailPuppy.png",300,300,true,true);
        puppyPics[4] = new Image("VideoCodeAlong/Images/skeptical-puppy-meme.jpg",300,300,true,true);
        puppyPics[5] = new Image("VideoCodeAlong/Images/puppyInGlasses.jpeg",300,300,true,true);
        puppyPics[6] = new Image("VideoCodeAlong/Images/brakPuppy.jpg",300,300,true,true);
        puppyPics[7] = new Image("VideoCodeAlong/Images/008-dog-memes.jpg",300,300,true,true);

        puppyViewer = new ImageView(puppyPics[index]);

        imageDiscripton = new Text(descriptons[index]);
        imageDiscripton.setFont(font);

        nextButton = new Button("next");
        nextButton.setFont(font);
        nextButton.setOnAction(this::nextButtonHandle);

        discriptionCheck = new CheckBox("Show description");
        discriptionCheck.setSelected(true);
        discriptionCheck.setFont(font);
        discriptionCheck.setOnAction(this::discriptionCheckHandler);

        controllBox.getChildren().addAll(discriptionCheck,nextButton);

        mainBox.getChildren().addAll(puppyViewer,imageDiscripton,controllBox);


        Scene scene = new Scene(mainBox,400,300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Puppy pictures app");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void nextButtonHandle(ActionEvent nextEvent){
        if (index < 7){
            index++;
        } else {
            index = 0;
        }

        puppyViewer.setImage(puppyPics[index]);
        imageDiscripton.setText(descriptons[index]);
    }

    private void discriptionCheckHandler(ActionEvent checkEvent){
        if(discriptionCheck.isSelected()){
            imageDiscripton.setText(descriptons[index]);
        } else {
            imageDiscripton.setText("");
        }
    }


}//ImageApp

