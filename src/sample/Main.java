package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main extends Application {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Sound sound = new Sound("src/sample/MediaSweng/Dinosaur1.wav");
//        sound.play();

        File xml = openFile(primaryStage);

        if(xml == null){
            System.out.println("No file chosen. Exiting.");
            stop();
        }
        else{
            Parser parser = new Parser();
            parser.Parser(xml);

            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            primaryStage.setTitle("Akidemia");
            primaryStage.setScene(new Scene(root, width, height));
            //primaryStage.setMaximized(true);
            primaryStage.show();
        }
    }

    

    public static void main(String[] args) {
        launch(args);
    }

    private File openFile(Stage stage){
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PWS (*.pws)", "*.pws"));
        return fileChooser.showOpenDialog(stage);
    }

}

