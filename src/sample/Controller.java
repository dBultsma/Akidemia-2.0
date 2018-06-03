package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    ChangingScene sc = new ChangingScene();


    @FXML public Button goButton;

    public void PressGo(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("ChooseYourAdventure.fxml", window);
        //start();
    }

    public void dinoSelected (ActionEvent event) throws IOException {
        goButton.setDisable((false));
    }

    public void toSettings(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("settings.fxml", window);
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

    public void toChildLock(ActionEvent event)throws IOException {
        Stage window = new Stage();
        sc.changeScene("childLock.fxml", window);
    }

    public void mag2Cursor(MouseEvent evt) {
        magCursor(((Node)evt.getSource()).getScene());
    }

//    public void unlockAnimation(Stage primaryStage) throws Exception {
//        ImageView.setStyle("-fx-image: url(\"MediaSweng/unlock.png\");");
//    }

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

        root.getChildren().add( mediaView);

        Scene scene = new Scene(root, 1280, 720);

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


}
