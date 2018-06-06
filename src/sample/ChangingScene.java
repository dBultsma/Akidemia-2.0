package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


// go to a new scene
public class ChangingScene {

    public Scene changeScene(String name, Stage window)  {
        Parent parentToScene = null;
        try {
            parentToScene = FXMLLoader.load(getClass().getResource(name));
        } catch (IOException e) {
            System.err.println(e);
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
        Scene newScene = new Scene(parentToScene, window.getWidth(), window.getHeight());
        window.setScene(newScene);
        window.show();

        return(newScene);
    }
}

