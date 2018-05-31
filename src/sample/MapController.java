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
    @FXML public AnchorPane stage1, stage2, stage3, stage4, map;
    @FXML public Text oceanlabel, plainslabel, mountainslabel, woodlandlabel;
    @FXML public ImageView mountainimage, oceanimage, plainsimage, woodlandimage;
    @FXML public ImageView area3aimage, area3bimage, area3cimage, area3dimage;
    @FXML public ImageView area2aimage, area2bimage, area2cimage, area2dimage;
    @FXML public ImageView area1aimage, area1bimage, area1cimage, area1dimage;
    @FXML public Text threelabela, threelabelb, threelabelc, threelabeld;
    @FXML public Text onelabela, onelabelb, onelabelc, onelabeld;
    @FXML public Text twolabela, twolabelb, twolabelc, twolabeld;



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

//        if(map.setVisible(false) = true) {
//            addTextHandler(threelabela, area3aimage);
//            addTextHandler(threelabelb, area3bimage);
//            addTextHandler(threelabelc, area3cimage);
//            addTextHandler(threelabeld, area3dimage);
//        }


    }



    public void PressGo(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("ChooseYourAdventure.fxml", window);

    }
    public void toMap(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void toArea3a(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3a.fxml", window);
    }
    public void toArea3b(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3b.fxml", window);
    }
    public void toArea3c(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3c.fxml", window);
    }
    public void toArea3d(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area3d.fxml", window);
    }
    public void toArea1a(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1a.fxml", window);
    }
    public void toArea1b(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1b.fxml", window);
    }
    public void toArea1c(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1c.fxml", window);
    }
    public void toArea1d(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area1d.fxml", window);
    }
    public void toArea2a(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2a.fxml", window);
    }
    public void toArea2b(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2b.fxml", window);
    }
    public void toArea2c(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2c.fxml", window);
    }
    public void toArea2d(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area2d.fxml", window);
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
