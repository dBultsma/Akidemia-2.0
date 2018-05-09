package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import java.io.IOException;

public class Controller {

    ChangingScene sc = new ChangingScene();

    public void PressGo(ActionEvent event) throws IOException {

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("ChooseYourAdventure.fxml", window);
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

    public void mag2Cursor(MouseEvent evt) {
        magCursor(((Node)evt.getSource()).getScene());
    }

//    public void unlockAnimation(Stage primaryStage) throws Exception {
//        ImageView.setStyle("-fx-image: url(\"MediaSweng/unlock.png\");");
//    }

}