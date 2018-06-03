package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.stage.Stage;
import sample.Controller;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.animation.*;
import javafx.util.Duration;

import javax.annotation.Resources;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Area2Controller {

    ChangingScene sc = new ChangingScene();

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

}