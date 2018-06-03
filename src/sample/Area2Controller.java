/*package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
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

    @FXML public AnchorPane info2a, infotwob, stage4;
    @FXML public ImageView quetzal, imagetwob, oceanimage;

    ChangingScene sc = new ChangingScene();

    public void initialize(URL location, ResourceBundle resources) {

        addButtonHandler(info2a, quetzal);
        addButtonHandler(infotwob, imagetwob);

    }

    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void infotest(ActionEvent event) {
        info2a.setVisible(true);
    }

    public void addButtonHandler(AnchorPane anchorPane, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            if (color.getOpacity() != 0) {
                anchorPane.setVisible(true);
                imageView.setVisible(false);
            }

        });
    }

}*/

package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.animation.*;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Text;


public class Area2Controller implements Initializable {

    @FXML public AnchorPane area2ainfo;
    @FXML public ImageView area2aimage;


    ChangingScene sc = new ChangingScene();

    public void initialize(URL location, ResourceBundle resources) {


        addButtonHandler(area2ainfo, area2aimage);

    }




    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    /*public void MapStage1(ActionEvent event) {
        map.setVisible(false);
        stage1.setVisible(true);
    }

    public void MapStage2(ActionEvent event) {
        map.setVisible(false);
        stage2.setVisible(true);
    }

    public void MapStage3(ActionEvent event)  {
        map.setVisible(false);
        stage3.setVisible(true);
    }

    public void MapStage4(ActionEvent event)  {
        map.setVisible(false);
        stage4.setVisible(true);
    }
*/
    public void addTextHandler(Text text, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            text.setVisible(color.getOpacity() != 0);
        });
        imageView.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
            text.setVisible(false);
        });
    }
    public void addButtonHandler(AnchorPane anchorPane, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            if (color.getOpacity() != 0) {
                anchorPane.setVisible(!anchorPane.isVisible());
            }

        });
    }

}