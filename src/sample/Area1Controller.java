
package sample;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.animation.*;
import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

public class Area1Controller {
    ChangingScene sc = new ChangingScene();

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);


    }
}
