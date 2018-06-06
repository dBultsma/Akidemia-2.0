package sample;

import javafx.event.Event;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class Area4Controller implements Initializable {

    @FXML public AnchorPane infoa, infob, info3, infod, infoc;
    @FXML public ImageView pica, picbb, picd, picc3;

    ChangingScene sc = new ChangingScene();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        File path = new File(location.getFile());
        String fileName = path.getName();

        // reads fxml file in use
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

    // to Island
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

    // play basilosaurus information script
    public void soundPlayBasilosaurus(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Basilosaurus.wav").toString());
        sound.play();
    }

    // play kronosaurus information script
    public void soundPlayKronosaurus(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Kronosaurus.wav").toString());
        sound.play();
    }

    // play liopleurodon information script
    public void soundPlayLiopleurdon(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Liopleurdon.wav").toString());
        sound.play();
    }

    // play mauisaurus information script
    public void soundPlayMauisaurus(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Mauisaurus.wav").toString());
        sound.play();
    }
}