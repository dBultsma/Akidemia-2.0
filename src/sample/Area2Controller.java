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
import javafx.scene.ImageCursor;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
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
import javafx.scene.text.Text;



public class Area2Controller implements Initializable {

    @FXML public AnchorPane area2ainfo;
    @FXML public ImageView area2aimage;
    @FXML public ImageView spike, speech1, speech2, findadino, almostthere;
    private Timeline speechBubbleTimeline = new Timeline();
    private int speechmode = 0;
    int i =0;
    AudioClip plonkSound = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());

    ChangingScene sc = new ChangingScene();

    public void initialize(URL location, ResourceBundle resources) {






        addButtonHandler(area2ainfo, area2aimage);
     //   AudioClip plonkSound = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());
        starterBubble();

        spike.setOnMouseEntered(e ->
                {
                    AudioClip spikeHello = null;



                    switch ((int) Math.round(Math.random() * 3 )) {
                        case 0:
                            spikeHello = new AudioClip(getClass().getResource("MediaSweng/Spike_Here_To_Help.wav").toString());
                            break;
                        case 1:
                            spikeHello = new AudioClip(getClass().getResource("MediaSweng/Spike_Hello.wav").toString());
                            break;
                        case 2:
                            spikeHello = new AudioClip(getClass().getResource("MediaSweng/Spike_Hi_im_Spike.wav").toString());
                            break;
                        case 3:
                            spikeHello = new AudioClip(getClass().getResource("MediaSweng/Spike_Hiya.wav").toString());
                            break;
                    }

                    if (spikeHello != null) {
                        spikeHello.play();
                    }
                }
        );


        spike.setOnMouseClicked(e -> {
            if (i<= 0) {
                transitions();
                plonkSound.play();
                i++;
            }
        });


        spike.translateXProperty().addListener((obs, old, val) -> {
            timelinetransition(val.doubleValue());
        });


//        area2aimage.setOnMouseClicked(e -> {
//                File path = new File(location.getFile());
//                String fileName = path.getName();
//
//                if ("area4b.fxml".equals(fileName)) {
//                    // Do one thing
//                    new CreateFile().writeFile("Are4b", "2");
//                    plonkSound.play();
//                }
//                else if ("area4a.fxml".equals(fileName)) {
//                    // The other thong
//                    new CreateFile().writeFile("Area3a", "1");
//                    plonkSound.play();
//                }
//                else if ("area4c.fxml".equals(fileName)) {
//                    new CreateFile().writeFile("Area4c", "3");
//                    // The other thong
//                    plonkSound.play();
//
//
//                }
//                else if ("area3d.fxml".equals(fileName)) {
//                    new CreateFile().writeFile("Area4d", "4");
//                    // The other thong
//                    plonkSound.play();
//                    //AudioClip plonkSound = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());
//
//                }
//
//        });
    }

    public void timelinetransition(double x) {
        int speechmode = -1;
        if (this.speechmode != 1) {
            speechmode = 1;
            speechBubbleTimeline.stop();
            speechBubbleTimeline.getKeyFrames().clear();
            speech1.setVisible(false);
            speech2.setVisible(false);
            speechBubbleTimeline.getKeyFrames().addAll(
                    new KeyFrame(Duration.ZERO, e -> speech1.setVisible(false)),
                    new KeyFrame(Duration.seconds(2), e -> findadino.setVisible(true)),
                    new KeyFrame(Duration.seconds(5), e -> findadino.setVisible(false)),
                    new KeyFrame(Duration.seconds(7), e -> almostthere.setVisible(true)),
                    new KeyFrame(Duration.seconds(10), e -> almostthere.setVisible(false)));

        }

        if (this.speechmode != speechmode) {
            this.speechmode = speechmode;
            speechBubbleTimeline.play();
        }
    }



    public void starterBubble(){ speech1.setVisible(true);}

    public void transitions() {
        final Duration SEC_3 = Duration.millis(3000);
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
        tt.setFromX(0);
        tt.setToX(-200);


        SequentialTransition seqT = new SequentialTransition(spike , tt );
        seqT.play();
    }



    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

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

    public void magCursor(Scene x) {
        Image image = new Image(getClass().getResource("MediaSweng/cursor.png").toExternalForm(),
                20, 20, false, true);
        x.setCursor(new ImageCursor(image, 1, 1));
    }

    public void excCursor(MouseEvent evt) {

        Image image = new Image(getClass().getResource("MediaSweng/exclamation.png").toExternalForm(),
                20,20,false,true);
        ((Node)evt.getSource()).getScene().setCursor(new ImageCursor(image, 1, 1));
    }




}