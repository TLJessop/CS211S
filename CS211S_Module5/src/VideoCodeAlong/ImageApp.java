package VideoCodeAlong;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ImageApp extends Application {

    private Image[] puppyPics;
    private Image[] evilPics;
    private ImageView memeViewer;
    private CheckBox discriptionCheck;
    private Button nextButton;
    private Text imageDiscripton;
    private VBox mainBox;
    private HBox controllBox;
    private String[] puppyDescriptions;
    private String[] evilDescriptions;
    private RadioButton puppiesRButton;
    private RadioButton evilRButton;
    private ToggleGroup puppiesOrEvil;
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

        puppyDescriptions = new String[8];
        puppyDescriptions[0] = "The best wake-up call";
        puppyDescriptions[1] = "A new barkTec storage solution";
        puppyDescriptions[2] = "A deep thought to wonder";
        puppyDescriptions[3] = "My favorite co-worker";
        puppyDescriptions[4] = "Some healthily skepticism";
        puppyDescriptions[5] = "The cutest hipster";
        puppyDescriptions[6] = "The world's most interesting puppy";
        puppyDescriptions[7] = "Questionable investment advice";

        evilDescriptions = new String[8];
        evilDescriptions[0] = "There goes your productivity";
        evilDescriptions[1] = "No, power for you! Until my evil plans are made reality";
        evilDescriptions[2] = "This is why your friends dog has a bad rap";
        evilDescriptions[3] = "It is the only true sustenance for them";
        evilDescriptions[4] = "Why cats are not allowed in heaven";
        evilDescriptions[5] = "The thoughts they hide behind their cuteness";
        evilDescriptions[6] = "Of course you are";
        evilDescriptions[7] = "Yeah, this is how your cat sees you";

        puppyPics = new Image[8];
        puppyPics[0] = new Image("VideoCodeAlong/Images/puppyCall.jpg",300,300,true,true);
        puppyPics[1] = new Image("VideoCodeAlong/Images/megabitePuppy.jpg",300,300,true,true);
        puppyPics[2] = new Image("VideoCodeAlong/Images/teddybearPuppy.jpg",300,300,true,true);
        puppyPics[3] = new Image("VideoCodeAlong/Images/snugglesEmailPuppy.png",300,300,true,true);
        puppyPics[4] = new Image("VideoCodeAlong/Images/skeptical-puppy-meme.jpg",300,300,true,true);
        puppyPics[5] = new Image("VideoCodeAlong/Images/puppyInGlasses.jpeg",300,300,true,true);
        puppyPics[6] = new Image("VideoCodeAlong/Images/brakPuppy.jpg",300,300,true,true);
        puppyPics[7] = new Image("VideoCodeAlong/Images/008-dog-memes.jpg",300,300,true,true);

        evilPics = new Image[8];
        evilPics[0] = new Image("VideoCodeAlong/Images/plugPuller.jpg",300,300,true,true);
        evilPics[1] = new Image("VideoCodeAlong/Images/chragerHosheg.jpg",300,300,true,true);
        evilPics[2] = new Image("VideoCodeAlong/Images/blameShifting.jpg",300,300,true,true);
        evilPics[3] = new Image("VideoCodeAlong/Images/soulEater.jpg",300,300,true,true);
        evilPics[4] = new Image("VideoCodeAlong/Images/theKittenPrayer.jpg",300,300,true,true);
        evilPics[5] = new Image("VideoCodeAlong/Images/voicesInTheirMinds.jpg",300,300,true,true);
       evilPics[6] = new Image("VideoCodeAlong/Images/iAmDarkness.jpg",300,300,true,true);
       evilPics[7] = new Image("VideoCodeAlong/Images/lazzy.jpg",300,300,true,true);

        memeViewer = new ImageView(puppyPics[index]);

        imageDiscripton = new Text(puppyDescriptions[index]);
        imageDiscripton.setFont(font);

        nextButton = new Button("next");
        nextButton.setFont(font);
        nextButton.setOnAction(this::buttonHandler);

        puppiesOrEvil = new ToggleGroup();

        puppiesRButton = new RadioButton("Puppies!");
        puppiesRButton.setFont(font);
        puppiesRButton.setToggleGroup(puppiesOrEvil);
        puppiesRButton.setOnAction(this::buttonHandler);

        evilRButton = new RadioButton("Kittens");
        evilRButton.setFont(font);
        evilRButton.setToggleGroup(puppiesOrEvil);
        evilRButton.setOnAction(this::buttonHandler);

        puppiesOrEvil.selectToggle(puppiesRButton);

        discriptionCheck = new CheckBox("Show description");
        discriptionCheck.setSelected(true);
        discriptionCheck.setFont(font);
        discriptionCheck.setOnAction(this::discriptionCheckHandler);

        controllBox.getChildren().addAll(puppiesRButton, evilRButton, discriptionCheck,nextButton);

        mainBox.getChildren().addAll(memeViewer,imageDiscripton,controllBox);

        Scene scene = new Scene(mainBox,400,300);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Cute memes");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

    private void buttonHandler(ActionEvent nextEvent){
        if (index < 7){
            index++;
        } else {
            index = 0;
        }
        if(puppiesOrEvil.getSelectedToggle() == puppiesRButton) {
            memeViewer.setImage(puppyPics[index]);
            imageDiscripton.setText(puppyDescriptions[index]);
        }else if(puppiesOrEvil.getSelectedToggle() == evilRButton){
            memeViewer.setImage(evilPics[index]);
            imageDiscripton.setText(evilDescriptions[index]);
        }
    }

    private void discriptionCheckHandler(ActionEvent checkEvent){
        if(discriptionCheck.isSelected()){
            imageDiscripton.setVisible(true);
        } else {
            imageDiscripton.setVisible(false);
        }
    }

}//ImageApp

