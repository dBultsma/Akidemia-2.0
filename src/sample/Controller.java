package sample;

import PWS.Presentation;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    ChangingScene sc = new ChangingScene();
    Presentation presentation;
    Pane currentSlide;


    @FXML public Button goButton;

    public void dinoSelected (ActionEvent event) throws IOException {
        goButton.setDisable((false));
    }

    public void BackToMainScene(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("sample.fxml", window);
    }

    public void toWelcomePicture(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("welcomePicture.fxml", window);
    }

    public void toMap(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void toPasswordsettings(ActionEvent event) throws IOException {
        Stage window = new Stage();
        sc.changeScene("SettingPassword.fxml", window);
    }

    public void quiz1Pressed(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz1.fxml", window);
    }

    public void quiz2Pressed(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz2.fxml", window);
    }

    public void quiz3Pressed(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz3.fxml", window);
    }

    public void quiz4Pressed(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz4.fxml", window);
    }
    public void soundPlaywelcome(){
        AudioClip sound = new AudioClip(getClass().getResource("MediaSweng/Welcome_Audio.wav").toString());
        sound.play();
    }
    public void startVideo(Event event) throws IOException{
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

        StackPane root = new StackPane();

        MediaPlayer player = new MediaPlayer( new Media(getClass().getResource("MediaSweng/WelcomeFixedAudio.mp4").toExternalForm()));
        MediaView mediaView = new MediaView(player);
        player.setVolume(1);
        player.setMute(false);
        player.setAutoPlay(true);
        player.setOnError(() -> {
            System.err.println(player.getError());
        });

        root.getChildren().add(mediaView);

        Scene scene = new Scene(root, window.getWidth(), window.getHeight());

        window.setScene(scene);
        window.show();

        player.setOnEndOfMedia(() -> {
            try {
                sc.changeScene("ChooseYourAdventure.fxml", window);
            }
            catch(Exception e) {
                System.err.println(e);
            }
        });
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private File openFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PWS (*.pws)", "*.pws"));
        return fileChooser.showOpenDialog(stage);
    }

    public void pwsparser(){
        PWS pws = new PWS();
        pws.start(new Stage());
    }

    public void parser(Stage window) throws IOException {

        Parser parser = new Parser();
        Group group = new Group();
        File xml = openFile(window);
        presentation = parser.Parser(xml);

        if (presentation != null) {
            Scene scene = new Scene(group, window.getWidth(), window.getHeight());
            window.setScene(scene);

            currentSlide = presentation.getFirstSlide();

            group.getChildren().add(currentSlide);

            scene.setOnKeyPressed((keyEvent) -> {
                switch (keyEvent.getCode()) {
                    case RIGHT:
                        group.getChildren().remove(currentSlide);
                        currentSlide = presentation.getNextSlide();
                        group.getChildren().add(currentSlide);
                        break;
                    case LEFT:
                        group.getChildren().remove(currentSlide);
                        currentSlide = presentation.getPreviousSlide();
                        group.getChildren().add(currentSlide);
                        break;
                }
            });
        }
    }

}

