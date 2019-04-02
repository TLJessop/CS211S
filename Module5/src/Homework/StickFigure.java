package Homework;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class StickFigure extends Application {

    private Circle head, leftEye, rightEye;
    private Ellipse mouth;
    private Line body, leftArm, leftLeg, rightArm, rightLeg;
    private Rectangle sky,ground;
    private Text phase;
    private Color eyeColor = Color.LIGHTSEAGREEN;
    private double eyeRadius = 10;
    private double stroke = 2.5;
    private double libLenght = 90;
    private double eyeHeight = 40;
    private double armHeight = 120;
    private double bodyHeight = 100;
    private double bodyLenght = (bodyHeight+(libLenght*1.5));
    private double armLenght = armHeight + libLenght;
    private double legHeight = bodyLenght;
    private double legLenght = legHeight + libLenght;
    private double startCenterX = 50;
    private double leftLibOfset = (startCenterX * 1.5);
    private double rightLibOfset = (startCenterX - (startCenterX * 0.5));
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        Pane root = new Pane();

        head = new Circle(startCenterX,50,50);
        head.setFill(Color.LIGHTSALMON);
        head.setStrokeWidth(stroke);
        head.setStroke(Color.BLACK);

        leftEye = new Circle(30, eyeHeight, eyeRadius);
        leftEye.setFill(Color.TRANSPARENT);
        leftEye.setStrokeWidth(stroke);
        leftEye.setStroke(Color.BLACK);
        leftEye.setFill(eyeColor);

        rightEye = new Circle(70, eyeHeight,eyeRadius);
        rightEye.setFill(Color.TRANSPARENT);
        rightEye.setStrokeWidth(stroke);
        rightEye.setStroke(Color.BLACK);
        rightEye.setFill(eyeColor);

        mouth = new Ellipse(startCenterX,70,30,10);
        mouth.setFill(Color.TRANSPARENT);
        mouth.setStrokeWidth(stroke);
        mouth.setStroke(Color.BLACK);
        mouth.setFill(Color.LIGHTPINK);

        phase = new Text("Hi");
        phase.setFill(Color.YELLOW);
        phase.setFont(Font.font(20));
        phase.setX(startCenterX+60);
        phase.setY(70);

        sky = new Rectangle(400,400);
        sky.setFill(Color.LIGHTBLUE);
        sky.widthProperty().bind(primaryStage.widthProperty());
        sky.heightProperty().bind(primaryStage.heightProperty());

        ground = new Rectangle(400,40);
        ground.setFill(Color.BROWN);
        ground.widthProperty().bind(primaryStage.widthProperty());
        ground.setY(legLenght);




        body = new Line(startCenterX,bodyHeight, startCenterX,bodyLenght);
        body.setStrokeWidth(stroke);

        leftArm = new Line(startCenterX, armHeight,leftLibOfset, armLenght);
        leftArm.setStrokeWidth(stroke);

        rightArm = new Line(startCenterX,armHeight,rightLibOfset,armLenght);
        rightArm.setStrokeWidth(stroke);

        leftLeg = new Line(startCenterX, legHeight,leftLibOfset,legLenght);
        leftLeg.setStrokeWidth(stroke);

        rightLeg = new Line(startCenterX, legHeight,rightLibOfset,legLenght);
        rightLeg.setStrokeWidth(stroke);



        Group face = new Group(head,leftEye,rightEye, mouth, phase);
        Group bodyLines = new Group(body,leftArm,rightArm,leftLeg,rightLeg);
        Group figure = new Group(face, bodyLines);
        Group background = new Group(sky,ground);

        figure.setTranslateX(150);
        figure.setTranslateY(40);
        ground.setTranslateY(40);

        root.getChildren().addAll(background, figure);
        Scene scene = new Scene(root,400,400);

        primaryStage.setScene(scene);
        primaryStage.setTitle("StickFigure");
        primaryStage.show();
    }
}//StickFigure
