package sample;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import PWS.*;

import java.io.File;

public class PWS extends Application{

    Presentation presentation;

    Pane currentSlide;

    public static void main(String[] args){
        launch(args);
    }

    @Override
    public void start(Stage stage){
        stage.setTitle("Presentation");

        Group root = new Group();
        Scene scene = new Scene(root, 1280, 720); // opens new window for new presentation

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PWS (*.pws)", "*.pws"));

        File xml = fileChooser.showOpenDialog(stage);

        Parser parser = new Parser(); // sets up parser

        presentation = parser.Parser(xml); // parses xml, returns presentation object


        if (presentation != null) {
            stage.setScene(scene);
            stage.show();

            currentSlide = presentation.getFirstSlide();

            root.getChildren().add(currentSlide);

            scene.setOnKeyPressed((keyEvent) -> { //defines arrow key navigation
                switch (keyEvent.getCode()) {
                    case RIGHT:
                        root.getChildren().remove(currentSlide);
                        currentSlide = presentation.getNextSlide();
                        root.getChildren().add(currentSlide);
                        break;
                    case LEFT:
                        root.getChildren().remove(currentSlide);
                        currentSlide = presentation.getPreviousSlide();
                        root.getChildren().add(currentSlide);
                        break;
                }
            });
        }
    }

}