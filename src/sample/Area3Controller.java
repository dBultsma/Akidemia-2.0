package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Area3Controller implements Initializable {

   @FXML public Button button;
   @FXML public AnchorPane pane2, pane3, pane4, pane5, pane6;
   @FXML public ImageView triceratops1, triceratops2;
   @FXML public ImageView spinosaurus1, spinosaurus2;
   @FXML public ImageView trex1;
   @FXML public ImageView suchomimus1;
   @FXML public ImageView spike, speech1, speech2, findadino, almostthere;

    int i = 0;
    private Timeline speechBubbleTimeline = new Timeline();
    private int speechmode = 0;



    public void initialize(URL location, ResourceBundle resources) {
        File path = new File(location.getFile());
        String fileName = path.getName();

        if ("area3b.fxml".equals(fileName)) {
            // Do one thing
            addButtonHandler3b(pane4, spinosaurus2);
        }
        else if ("area3a.fxml".equals(fileName)) {
            // The other thing
            addButtonHandler3a(pane3, triceratops1);
        }
        else if ("area3c.fxml".equals(fileName)) {
            // The other thing
            addButtonHandler3a(pane5, trex1);
        }
        else if ("area3d.fxml".equals(fileName)) {
            // The other thing
            addButtonHandler3c(pane6, suchomimus1);
        }
        AudioClip plonkSound = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());
        AudioClip tri = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());
        AudioClip spi = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());
        AudioClip trex = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());
        AudioClip suc = new AudioClip(getClass().getResource("MediaSweng/spikein.wav").toString());

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

        spike.translateXProperty().addListener((obs, old, val) -> {
            timelinetransition(val.doubleValue());
        });


            spike.setOnMouseClicked(e -> {
                if (i<= 0) {
                    transitions();
                    plonkSound.play();
                    i++;
                }
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





    ChangingScene sc = new ChangingScene();

    public void toMap(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void toArea31(Event event){
        pane2.setVisible(false);
        pane3.setVisible(true);
    }

    public void addButtonHandler3a(AnchorPane anchorPane, ImageView imageView){
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());

            if ((color.getOpacity() != 0)  || (color.getOpacity() != 0) ) {
                anchorPane.setVisible(true);
            }}
        );
    }
    public void addButtonHandler3b(AnchorPane anchorPane, ImageView imageView){
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());

            if ((color.getOpacity() != 0)  || (color.getOpacity() != 0) ) {
                anchorPane.setVisible(true);
            }}
        );
    }

    public void addButtonHandler3c(AnchorPane anchorPane, ImageView imageView){
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());

            if ((color.getOpacity() != 0)  || (color.getOpacity() != 0) ) {
                anchorPane.setVisible(true);
            }}
        );
    }


    public void soundPlay(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Triceratops.wav").toString());
        sound.play();
    }

    public void soundPlayb(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Spinosaurus.wav").toString());
        sound.play();
    }

    public void soundPlayc(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/T-Rex.wav").toString());
        sound.play();
    }

    public void soundPlayd(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Suchomimus.wav").toString());
        sound.play();
    }


}