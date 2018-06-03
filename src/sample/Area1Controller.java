package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.animation.*;
import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

public class Area1Controller implements Initializable {

    ChangingScene sc = new ChangingScene();
    @FXML public ImageView targetDino;
    @FXML public AnchorPane infoPane;

    public void initialize(URL location, ResourceBundle resources) {

        addButtonHandler(infoPane, targetDino);
    }

    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);

    }

    public void addButtonHandler(AnchorPane anchorPane, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            anchorPane.setVisible(!anchorPane.isVisible());
        });
    }
}
