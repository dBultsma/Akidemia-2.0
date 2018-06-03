package sample;

import PWS.Presentation;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import java.io.File;
import java.io.IOException;



public class Controller {

    ChangingScene sc = new ChangingScene();
    Presentation presentation;
    Pane currentSlide;

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

    public void mag2Cursor(MouseEvent evt) {
        magCursor(((Node)evt.getSource()).getScene());
    }

//    public void unlockAnimation(Stage primaryStage) throws Exception {
//        ImageView.setStyle("-fx-image: url(\"MediaSweng/unlock.png\");");
//    }

    private File openFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("open xml");
        fileChooser.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PWS (*.pws)", "*.pws"));
        return fileChooser.showOpenDialog(stage);
    }


    public void parser(ActionEvent event, Stage window) throws IOException {


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