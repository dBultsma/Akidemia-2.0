package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.animation.*;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Area4Controller implements Initializable {

    @FXML public AnchorPane infoa, infob, info3, infod, infoc;
    @FXML public ImageView pica, picbb, pic3, picd, picc3;

    ChangingScene sc = new ChangingScene();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File path = new File(location.getFile());
        String fileName = path.getName();

        if("4a.fxml".equals(fileName)){
            addButtonHandlerA(infoa, pica);
        }
        else if ("4b.fxml".equals(fileName)){
            addButtonHandlerA(infob, picbb);
        }
        else if ("4c2.fxml".equals(fileName)){
            addButtonHandlerB(info3, infoc, picc3);
        }
        else if ("4d.fxml".equals(fileName)){
            addButtonHandlerA(infod, picd);
        }

    }

    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void addButtonHandlerA(AnchorPane anchorPane, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            if (color.getOpacity() != 0) {
                anchorPane.setVisible(true);
            }

        });
    }

    public void addButtonHandlerB(AnchorPane anchorPane, AnchorPane anchorPane1, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            if (color.getOpacity() != 0) {
                anchorPane.setVisible(true);
                anchorPane1.setVisible(false);
            }

        });
    }

    public void soundPlayBasilosaurus(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Basilosaurus.wav").toString());
        sound.play();
    }

    public void soundPlayKronosaurus(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Kronosaurus.wav").toString());
        sound.play();
    }

    public void soundPlayLiopleurdon(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Liopleurdon.wav").toString());
        sound.play();
    }

    public void soundPlayMauisaurus(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Mauisaurus.wav").toString());
        sound.play();
    }
}