package sample;

import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.util.ResourceBundle;

public class Area3Controller implements Initializable {

   @FXML public Button button;
   @FXML public AnchorPane pane2, pane3, pane4, pane5, pane6;
   @FXML public ImageView triceratops1, triceratops2;
   @FXML public ImageView spinosaurus1, spinosaurus2;
   @FXML public ImageView trex1;
   @FXML public ImageView suchomimus1;



    public void initialize(URL location, ResourceBundle resources) {

      //  addButtonHandler3a(pane3, triceratops1);
       // addButtonHandler3b(pane4, spinosaurus1);
        File path = new File(location.getFile());
        String fileName = path.getName();

        if ("area3b.fxml".equals(fileName)) {
            // Do one thing
            addButtonHandler3b(pane4, spinosaurus2);
        }
        else if ("area3a.fxml".equals(fileName)) {
            // The other thong
            addButtonHandler3a(pane3, triceratops1);
        }
        else if ("area3c.fxml".equals(fileName)) {
            // The other thong
            addButtonHandler3a(pane5, trex1);
        }
        else if ("area3d.fxml".equals(fileName)) {
            // The other thong
            addButtonHandler3c(pane6, suchomimus1);
        }

        /*if(fileName = "area3a.fxml") {
            addButtonHandler(pane4, spinosaurus1, spinosaurus2);
        }
*/

      //  if( stage.getScene() ==  "area4")//addButtonHandler(pane3, triceratops1, triceratops2);


        //addButtonHandler(pane3, triceratops1, triceratops2);

    }

    ChangingScene sc = new ChangingScene();

    public void toMap(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void toArea31(Event event){
        pane2.setVisible(false);
        pane3.setVisible(true);
    }

    public void addButtonHandler3a(AnchorPane anchorPane, ImageView imageView){
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());

            if ((color.getOpacity() != 0)  || (color.getOpacity() != 0) ) {
                anchorPane.setVisible(true);
            }}
        );
    }
    public void addButtonHandler3b(AnchorPane anchorPane, ImageView imageView){
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());

            if ((color.getOpacity() != 0)  || (color.getOpacity() != 0) ) {
                anchorPane.setVisible(true);
            }}
        );
    }

    public void addButtonHandler3c(AnchorPane anchorPane, ImageView imageView){
        imageView.addEventFilter(MouseEvent.MOUSE_CLICKED, e -> {
            Color color = imageView.getImage().getPixelReader().getColor((int)e.getX(),(int)e.getY());

            if ((color.getOpacity() != 0)  || (color.getOpacity() != 0) ) {
                anchorPane.setVisible(true);
            }}
        );
    }



}