package sample;

import PWS.Presentation;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Main extends Application {

    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    @Override
    public void start(Stage primarystage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primarystage.setTitle("Akidemia");
        primarystage.setScene(new Scene(root, width, height));
        primarystage.show();


}



    public static void main(String[] args) {
        launch(args);
    }




}

