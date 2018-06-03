package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;

//imports from Video main

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;


import java.awt.*;
import java.nio.file.Paths;

public class Main extends Application {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Sound sound = new Sound("src/sample/MediaSweng/Dinosaur1.wav");
//        sound.play();

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Akidemia");
        primaryStage.setScene(new Scene(root, width, height));
        //primaryStage.setMaximized(true);
        primaryStage.show();
    }

    

    public static void main(String[] args) {
        launch(args);
    }


}

//main from ther groups video main (below)

/*
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Video player example");

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 1000, 768);

       // VideoPlayer video = new VideoPlayer(scene);
        //VideoPlayer video = new VideoPlayer(scene, "Welcome");
        VideoPlayer video = new VideoPlayer(scene, "Welcome", Paths.get("src/sample/MediaSweng/").toString());

        // Enable the provided evideo controls for the video player
        video.enableVideoControls();

        root.setCenter(video.getPane());


        // GUI test elements
        VBox test = new VBox(5);

        test.setPadding(new Insets(1));
        Rectangle r1 = new Rectangle(10, 10);
        Rectangle r2 = new Rectangle(20, 100);
        Rectangle r3 = new Rectangle(50, 20);
        Rectangle r4 = new Rectangle(20, 50);

        test.getChildren().addAll(r1, r2, r3, r4);

        root.setBottom(test);
        root.setTop(addHBox());
        root.setLeft(addHBox());
        root.setRight(addHBox());

        primaryStage.setScene(scene);
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public HBox addHBox() {
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(15, 25, 15, 12));
        hbox.setSpacing(10);
        hbox.setStyle("-fx-background-color: #336699;");

        Button buttonCurrent = new Button("Current");

        Button buttonProjected = new Button("Projected");
        hbox.getChildren().addAll(buttonCurrent, buttonProjected);

        return hbox;
    }

}
*/

