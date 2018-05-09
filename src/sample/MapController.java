package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
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


public class MapController implements Initializable {



    // I think this is where all the timeline stuff which interacts with the fxml will go. I hope so anyway!
    // Otherwise, I will look further into how to use css in order to do stuff! From the graphics module, it can be
    // seen that objects can have a duration- though this isn't entirely useful for what we need transitions to do.
    // Rather than using timelines, it may be more appropriate to use sequential transitions.
    @FXML private Button area1;
    @FXML private Button area2;
    @FXML private Button area3;
    @FXML private Button area4;
    @FXML public Circle circle;
    @FXML public ImageView backg;

    ChangingScene sc = new ChangingScene();

    public void initialize(URL location, ResourceBundle resources) {

        transitions();
    }



    public void PressGo(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("ChooseYourAdventure.fxml", window);
    }

    public void toArea1(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1.fxml", window);
      //  magCursor(area1Scene);

    }


    public void toArea2(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2.fxml", window);
       // magCursor(area2Scene);
    }

    public void toArea3(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3.fxml", window);
      //  magCursor(area3Scene);
    }

    public void toArea4(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area4.fxml", window);
        //magCursor(area4Scene);
    }

    public void toArea1a(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1a.fxml", window);
    }

    public void MapStage2(ActionEvent event) throws IOException {
        // Here I need to make the previous images and buttons unclickable and invisible
        area1.setManaged(false);
        area1.setVisible(false);
        area2.setManaged(false);
        area2.setVisible(false);
        area3.setManaged(false);
        area3.setVisible(false);
        area4.setManaged(false);
        area4.setVisible(false);
        backg.setVisible(false);

        // how do I make these unable to be clicked?
    }

    public void transitions(){
        System.out.println(circle);

        final Duration SEC_3 = Duration.millis(3000);

        PauseTransition pt = new PauseTransition(Duration.millis(1000));
        FadeTransition ft = new FadeTransition(SEC_3);
        ft.setFromValue(1.0);
        ft.setToValue(0.3);
        ft.setCycleCount(2);
        ft.setAutoReverse(true);
        TranslateTransition tt = new TranslateTransition(Duration.millis(2000));
        tt.setFromX(-100);
        tt.setToX(100);
        tt.setCycleCount(2);
        tt.setAutoReverse(true);
        RotateTransition rt = new RotateTransition(SEC_3);
        rt.setByAngle(180);
        rt.setCycleCount(4);
        rt.setAutoReverse(true);
        ScaleTransition st = new ScaleTransition(Duration.millis(4000));
        st.setByX(1.5);
        st.setByY(1.5);
        st.setCycleCount(2);
        st.setAutoReverse(true);

        SequentialTransition seqT = new SequentialTransition (circle, pt, ft, tt, rt, st);
        seqT.play();
    }




}
