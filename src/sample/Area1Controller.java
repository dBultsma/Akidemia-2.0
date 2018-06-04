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
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.animation.*;
import javafx.util.Duration;

import java.io.IOException;
import java.util.ResourceBundle;
import java.net.URL;

public class Area1Controller implements Initializable {

    ChangingScene sc = new ChangingScene();
    @FXML public ImageView targetDino;
    @FXML public AnchorPane infoPane;
    @FXML public ImageView spike, speech1, speech2, findadino, almostthere;
    private Timeline speechBubbleTimeline = new Timeline();
    private int speechmode = 0;
    int i =0;

    public void initialize(URL location, ResourceBundle resources) {

        addButtonHandler(infoPane, targetDino);

        AudioClip plonkSound = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());
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
}
