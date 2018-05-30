package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.animation.*;
import javafx.util.Duration;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Text;


public class MapController implements Initializable {


    @FXML public Circle circle;
    @FXML public ImageView backg;
    @FXML public AnchorPane stage1;
    @FXML public AnchorPane stage2;
    @FXML public AnchorPane stage3;
    @FXML public AnchorPane stage4;
    @FXML public AnchorPane map;
    @FXML public Text oceanlabel;
    @FXML public Text plainslabel;
    @FXML public Text mountainslabel;
    @FXML public Text woodlandlabel;
    @FXML public ImageView mountainimage, oceanimage, plainsimage, woodlandimage ;



    ChangingScene sc = new ChangingScene();

    public void initialize(URL location, ResourceBundle resources) {

        transitions();

        addTextHandler(mountainslabel, mountainimage);
        addTextHandler(oceanlabel, oceanimage);
        addTextHandler(woodlandlabel, woodlandimage);
        addTextHandler(plainslabel, plainsimage);
        addButtonHandler(stage1, plainsimage);
        addButtonHandler(stage2, woodlandimage);
        addButtonHandler(stage3, mountainimage);
        addButtonHandler(stage4, oceanimage);
    }


    public void PressGo(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("ChooseYourAdventure.fxml", window);

    }
    public void toMap(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }
    public void toArea1(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1.fxml", window);
    }

    public void toArea2(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2.fxml", window);
    }

    public void toArea3(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3.fxml", window);
    }

    public void toArea4(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area4.fxml", window);
    }

    public void toArea1a(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1a.fxml", window);
    }


    public void MapStage1(ActionEvent event) throws IOException {
        map.setVisible(false);
        stage1.setVisible(true);
    }

    public void MapStage2(ActionEvent event) throws IOException {
        map.setVisible(false);
        stage2.setVisible(true);
    }

    public void MapStage3(ActionEvent event) throws IOException {
        map.setVisible(false);
        stage3.setVisible(true);
    }

    public void MapStage4(ActionEvent event) throws IOException {
        map.setVisible(false);
        stage4.setVisible(true);
    }

    public void addTextHandler(Text text, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_MOVED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            text.setVisible(color.getOpacity() != 0);
        });
        imageView.addEventFilter(MouseEvent.MOUSE_EXITED, e -> {
            text.setVisible(false);
        });
    }
    public void addButtonHandler(AnchorPane anchorPane, ImageView imageView) {
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());
            if (color.getOpacity() != 0) {
                anchorPane.setVisible(true);
                map.setVisible(false);
            }

        });
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
