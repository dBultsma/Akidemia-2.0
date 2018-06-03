package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;



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



