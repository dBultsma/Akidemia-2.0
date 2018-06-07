package sample;

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
import javafx.animation.*;
import javafx.util.Duration;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Text;

public class Area2Controller implements Initializable {

    ChangingScene sc = new ChangingScene();
    @FXML public AnchorPane area2ainfo;
    @FXML public ImageView area2aimage;
    @FXML public ImageView spike, speech1, speech2, findadino, almostthere;
    private Timeline speechBubbleTimeline = new Timeline();
    private int speechmode = 0;
    int i =0;

    AudioClip plonkSound = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());

    public void initialize(URL location, ResourceBundle resources) {

        addButtonHandler(area2ainfo, area2aimage);
        starterBubble();

        // spike sound on mouse hover
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

    // spike move and sound on mouse click
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

    // spike speech bubble
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

    //transition distance
    public void transitions() {
        final Duration SEC_3 = Duration.millis(3000);
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
        tt.setFromX(0);
        tt.setToX(-200);

        SequentialTransition seqT = new SequentialTransition(spike , tt );
        seqT.play();
    }

    // to Island
    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void addButtonHandler(AnchorPane anchorPane, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            if (color.getOpacity() != 0) {
                anchorPane.setVisible(!anchorPane.isVisible());
            }
        });
    }

    // play dimorphodon information script
    public void soundPlayDimorphodon(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Dimorphodon.wav").toString());
        sound.play();
    }

    // play hatzegopteryx information script
    public void soundPlayHatzegopteryx(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Hatzegopteryx.wav").toString());
        sound.play();
    }

    // play pterodactyl information script
    public void soundPlayPterodactyl(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Pterodactyl.wav").toString());
        sound.play();
    }

    // play quetzalcoatlus information script
    public void soundPlayQuetzalcoatlus(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Quetzalcoatlus.wav").toString());
        sound.play();
    }
}