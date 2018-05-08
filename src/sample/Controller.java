package sample;


//import java.awt.event.ActionEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;

import java.io.IOException;

import static javafx.scene.image.ImageView.*;

public class Controller {

    public Scene changeScene(String name, Stage window) throws IOException {
        Parent parentToScene = FXMLLoader.load(getClass().getResource(name));
        Scene newScene = new Scene(parentToScene, window.getWidth(), window.getHeight());
        window.setScene(newScene);
        window.show();
        return(newScene);

    }

    public void PressGo(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changeScene("ChooseYourAdventure.fxml", window);
    }

    public void toSettings(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changeScene("settingmenu.fxml", window);
    }

    public void BackToMainScene(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changeScene("sample.fxml", window);
    }

    public void toWelcomePicture(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changeScene("welcomePicture.fxml", window);
    }

    public void toMap(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changeScene("map.fxml", window);
    }

    public void toArea1(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area1Scene = changeScene("area1.fxml", window);
        magCursor(area1Scene);
    }


    public void toArea2(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area2Scene = changeScene("area2.fxml", window);
        magCursor(area2Scene);
    }

    public void toArea3(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area3Scene = changeScene("area3.fxml", window);
        magCursor(area3Scene);
    }

    public void toArea4(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area4Scene = changeScene("area4.fxml", window);
        magCursor(area4Scene);
    }

    public void toArea1a(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        changeScene("area1a.fxml", window);
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

}