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


public class HelperController implements Initializable {

    @FXML public ImageView companion;

    public void initialize(URL location, ResourceBundle resources) {

    }

    public void transitions(){
        System.out.println(companion);

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

        SequentialTransition seqT = new SequentialTransition (companion, pt, ft, tt, rt, st);
        seqT.play();
    }




}
