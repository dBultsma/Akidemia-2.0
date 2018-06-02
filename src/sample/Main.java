package sample;

import PWS.Presentation;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
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

    Presentation presentation;
    Pane currentSlide;

    @Override
    public void start(Stage primaryStage) throws Exception{
//        Sound sound = new Sound("src/sample/MediaSweng/Dinosaur1.wav");
//        sound.play();

        primaryStage.setTitle("Akidemia");
        Group group = new Group();

        File xml = openFile(primaryStage);

        if(xml == null){
            System.out.println("No file chosen. Exiting.");
            stop();
        }
        else{
            Parser parser = new Parser();
            presentation = parser.Parser(xml);

            if(presentation != null){
                Scene scene = new Scene(group, width, height);
                primaryStage.setScene(scene);

                currentSlide = presentation.getFirstSlide();

                group.getChildren().add(currentSlide);

                scene.setOnKeyPressed((keyEvent) -> {
                    switch(keyEvent.getCode()){
                        case RIGHT:
                            group.getChildren().remove(currentSlide);
                            currentSlide = presentation.getNextSlide();
                            group.getChildren().add(currentSlide);
                            break;
                        case LEFT:
                            group.getChildren().remove(currentSlide);
                            currentSlide = presentation.getPreviousSlide();
                            group.getChildren().add(currentSlide);
                            break;
                    }
                });
            }
            else {
                Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
                primaryStage.setScene(new Scene(root, width, height));
            }

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

