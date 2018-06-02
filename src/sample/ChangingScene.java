package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ChangingScene {
    public Scene changeScene(String name, Stage window) throws IOException {
        Parent parentToScene = FXMLLoader.load(getClass().getResource(name));
        Scene newScene = new Scene(parentToScene, window.getWidth(), window.getHeight());
        window.setScene(newScene);
        window.setMaximized(true);
        window.show();
        return(newScene);

    }
}
