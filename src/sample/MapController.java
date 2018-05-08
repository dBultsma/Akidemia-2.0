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

    public void initialize(URL location, ResourceBundle resources) {

        transitions();
    }



    public void PressGo(ActionEvent event) throws IOException {

        System.out.println("Go");
        //Getting the layout from file
        Parent ChangeScene = FXMLLoader.load(getClass().getResource("ChooseYourAdventure.fxml"));
        //Used to get the current window
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(ChangeScene, window.getWidth(), window.getHeight()));
        window.show();
    }
    public void toArea1(ActionEvent event) throws IOException {

        //Getting the layout from file
        Parent area1Layout = FXMLLoader.load(getClass().getResource("area1.fxml"));
        //Used to get the current window
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area1Scene = new Scene(area1Layout, window.getWidth(), window.getHeight());
      //  magCursor(area1Scene);
        window.setScene(area1Scene);
        window.show();
    }


    public void toArea2(ActionEvent event) throws IOException {

        //Getting the layout from file
        Parent area2Layout = FXMLLoader.load(getClass().getResource("area2.fxml"));
        //Used to get the current window
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area2Scene = new Scene(area2Layout, window.getWidth(), window.getHeight());
       // magCursor(area2Scene);
        window.setScene(area2Scene);
        window.show();
    }

    public void toArea3(ActionEvent event) throws IOException {

        //Getting the layout from file
        Parent area3Layout = FXMLLoader.load(getClass().getResource("area3.fxml"));
        //Used to get the current window
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area3Scene = new Scene(area3Layout, window.getWidth(), window.getHeight());
      //  magCursor(area3Scene);
        window.setScene(area3Scene);
        window.show();
    }

    public void toArea4(ActionEvent event) throws IOException {

        //Getting the layout from file
        Parent area4Layout = FXMLLoader.load(getClass().getResource("area4.fxml"));
        //Used to get the current window
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene area4Scene = new Scene(area4Layout, window.getWidth(), window.getHeight());
        //magCursor(area4Scene);
        window.setScene(area4Scene);
        window.show();
    }

    public void toArea1a(ActionEvent event) throws IOException {

        //Getting the layout from file
        Parent area1aLayout = FXMLLoader.load(getClass().getResource("area1a.fxml"));
        //Used to get the current window
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(new Scene(area1aLayout, window.getWidth(), window.getHeight()));
        window.show();
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
