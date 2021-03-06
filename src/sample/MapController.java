package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.text.Text;

public class MapController implements Initializable {

    @FXML public Circle circle;
    @FXML public AnchorPane stage1, stage2, stage3, stage4, map;
    @FXML public Text oceanlabel, plainslabel, mountainslabel, woodlandlabel;
    @FXML public ImageView mountainimage, oceanimage, plainsimage, woodlandimage;
    @FXML public ImageView area3aimage, area3bimage, area3cimage, area3dimage;
    @FXML public ImageView area2aimage, area2bimage, area2cimage, area2dimage;
    @FXML public ImageView area1aimage, area1bimage, area1cimage, area1dimage;
    @FXML public ImageView area41image, area42image, area43image, area44image;
    @FXML public Text threelabela, threelabelb, threelabelc, threelabeld;
    @FXML public Text onelabela, onelabelb, onelabelc, onelabeld;
    @FXML public Text twolabela, twolabelb, twolabelc, twolabeld;
    @FXML public Text area4one, area4two, area4three, area4four;

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

            addTextHandler(threelabela, area3aimage);
            addTextHandler(threelabelb, area3bimage);
            addTextHandler(threelabelc, area3cimage);
            addTextHandler(threelabeld, area3dimage);

            addTextHandler(onelabela, area1aimage);
            addTextHandler(onelabelb, area1bimage);
            addTextHandler(onelabelc, area1cimage);
            addTextHandler(onelabeld, area1dimage);

            addTextHandler(twolabela, area2aimage);
            addTextHandler(twolabelb, area2bimage);
            addTextHandler(twolabelc, area2cimage);
            addTextHandler(twolabeld, area2dimage);

            addTextHandler(area4one, area41image);
            addTextHandler(area4two, area42image);
            addTextHandler(area4three, area43image);
            addTextHandler(area4four, area44image);

            area1aimage.setOnMouseClicked(e -> toArea1a(e));
            area1bimage.setOnMouseClicked(e -> toArea1b(e));
            area1cimage.setOnMouseClicked(e -> toArea1c(e));
            area1dimage.setOnMouseClicked(e -> toArea1d(e));
            area2aimage.setOnMouseClicked(e -> toArea2a(e));
            area2bimage.setOnMouseClicked(e -> toArea2b(e));
            area2cimage.setOnMouseClicked(e -> toArea2c(e));
            area2dimage.setOnMouseClicked(e -> toArea2d(e));
            area3aimage.setOnMouseClicked(e -> toArea3a(e));
            area3bimage.setOnMouseClicked(e -> toArea3b(e));
            area3cimage.setOnMouseClicked(e -> toArea3c(e));
            area3dimage.setOnMouseClicked(e -> toArea3d(e));
            area41image.setOnMouseClicked(e -> toArea4a(e));
            area42image.setOnMouseClicked(e -> toArea4b(e));
            area43image.setOnMouseClicked(e -> toArea4c(e));
            area44image.setOnMouseClicked(e -> toArea4d(e));
    }

    public void PressGo(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("ChooseYourAdventure.fxml", window);

    }
    public void toMap(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void toArea3a(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3a.fxml", window);
    }
    public void toArea3b(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3b.fxml", window);
    }
    public void toArea3c(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3c.fxml", window);
    }
    public void toArea3d(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3d.fxml", window);
    }

    public void toArea1a(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1a.fxml", window);
    }
    public void toArea1b(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1b.fxml", window);
    }
    public void toArea1c(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1c.fxml", window);
    }
    public void toArea1d(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1d.fxml", window);
    }

    public void toArea2a(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2a.fxml", window);
    }
    public void toArea2b(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2b.fxml", window);
    }
    public void toArea2c(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2c.fxml", window);
    }
    public void toArea2d(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2d.fxml", window);
    }
    public void toArea4a(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("4a.fxml", window);
    }
    public void toArea4b(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("4b.fxml", window);
    }
    public void toArea4c(Event event) {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("4c2.fxml", window);
    }
    public void toArea4d(Event event)  {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("4d.fxml", window);
    }

    public void MapStage1(ActionEvent event) {
        map.setVisible(false);
        stage1.setVisible(true);
    }

    public void MapStage2(ActionEvent event) {
        map.setVisible(false);
        stage2.setVisible(true);
    }

    public void MapStage3(ActionEvent event)  {
        map.setVisible(false);
        stage3.setVisible(true);
    }

    public void MapStage4(ActionEvent event)  {
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

    public void toQuiz1(Event event)  {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz1.fxml", window);
    }

    public void toQuiz2(Event event)  {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz2.fxml", window);
    }

    public void toQuiz3(Event event)  {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz3.fxml", window);
    }

    public void toQuiz4(Event event)  {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("Quiz4.fxml", window);
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
