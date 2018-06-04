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
        Scene scene = new Scene(root, 1280, 720);
        File xml = openFile(stage);

        Parser parser = new Parser();

        presentation = parser.Parser(xml);


        if (presentation != null) {
            stage.setScene(scene);
            stage.show();

            currentSlide = presentation.getFirstSlide();

            root.getChildren().add(currentSlide);

            scene.setOnKeyPressed((keyEvent) -> {
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

    private File openFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PWS (*.pws)", "*.pws"));
        return fileChooser.showOpenDialog(stage);
    }
}
