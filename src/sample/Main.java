package sample;

import PWS.Presentation;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.*;
import javafx.scene.image.*;
import javafx.stage.WindowEvent;
import sun.awt.OSInfo;
import java.io.*;
import java.util.*;



import javax.swing.*;
import java.awt.*;


public class Main extends Application {

    public GetOS type = new GetOS();


    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource(
                "map.fxml"));
        primaryStage.setTitle("Akidemia");

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {


            public void handle(WindowEvent we) {
                if (new ChildLock().childLockStatus().equals("locked")) {
                    we.consume();
                    Stage window = new Stage();
                    window.setAlwaysOnTop(true);
                    new ChangingScene().changeScene("childLockClose.fxml", window);
                } else {
                    CreateFile childLockStatus = new CreateFile();
                    childLockStatus.openFile("childLockStatus.txt");
                    childLockStatus.addData("unlocked");
                    childLockStatus.closeFile();
                    System.exit(0);
                }
            }
        });

        primaryStage.setScene(new Scene(root, width, height));
        //primaryStage.setMaximized(true);
        primaryStage.show();
        //type.returnOSType();
    }



    public static void main(String[] args) {
        launch(args);
    }




}



