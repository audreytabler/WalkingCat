package com.example.catspriteproject;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.effect.BlendMode;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;



public class MoveCat extends Application{
    //cat image sources
    Image catforward = new Image(System.getProperty("user.dir") + "/image/frontidle.gif");
    Image catback = new Image(System.getProperty("user.dir") + "/image/backidle.gif");
    Image catright =new Image(System.getProperty("user.dir") + "/image/rightwalkcycle.gif");
    Image catleft = new Image(System.getProperty("user.dir") + "/image/leftwalkcycle.gif");
    Image bgImage = new Image(System.getProperty("user.dir") + "/image/background.png");
    //Group group = new Group(catforward,catback,catright,catleft);

    ImageView image = new ImageView(catforward);
    ImageView background = new ImageView(bgImage);
    ImageView shadow = new ImageView(System.getProperty("user.dir") + "/image/shadow.png");
    ImageView foreground = new ImageView(System.getProperty("user.dir") + "/image/foregroundgrass.png");
    public void start(Stage primaryStage){
        Pane pane = new Pane();

        pane.getChildren().add(background);
        pane.getChildren().add(shadow);
        pane.getChildren().add(image);
        pane.getChildren().add(foreground);

        image.setX(350);
        image.setY(100);
        shadow.setX(350);
        shadow.setY(100);
        shadow.setBlendMode(BlendMode.MULTIPLY);
        //pane.getChildren().add(catright);

        image.setOnKeyPressed(e -> {
            if ((e.getCode() == KeyCode.DOWN) ||(e.getCode() == KeyCode.S)){
                image.setImage(catforward);
                if (image.getY() <=600){
                image.setY(image.getY() + 7);
                shadow.setY(image.getY() + 7);}
            }
            else if ((e.getCode() == KeyCode.UP) ||(e.getCode() == KeyCode.W)) {
                //image = catback;
                image.setImage(catback);
                if (image.getY() >=-125){
                image.setY(image.getY() - 7);
                shadow.setY(image.getY() - 7);}
            }
            else if ((e.getCode() == KeyCode.RIGHT) ||(e.getCode() == KeyCode.D)){
                image.setImage(catright);
                if (image.getX() <=900){
                image.setX(image.getX() + 7);
                shadow.setX(image.getX() + 7);}
            }

            else if ((e.getCode() == KeyCode.LEFT) ||(e.getCode() == KeyCode.A)){
                image.setImage(catleft);
                if (image.getX() >=-100){
                image.setX(image.getX() - 7);
                shadow.setX(image.getX() - 7);}
            }
        });
        image.setOnKeyReleased(e->{
            if (image.getImage() == catback){
                image.setImage(catback);
            }
            else
            image.setImage(catforward);
        });


        //pane.setAlignment(Pos.CENTER);
        Scene scene = new Scene(pane, 1000, 700);
        primaryStage.setTitle("c a t"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show();
        image.requestFocus();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
