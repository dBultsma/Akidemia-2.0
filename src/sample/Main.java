package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import java.awt.*;

public class Main extends Application {

    //get the window size of the device being used
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    int width = gd.getDisplayMode().getWidth();
    int height = gd.getDisplayMode().getHeight();

    @Override
    public void start(Stage primaryStage) throws Exception{
        //choose start scene
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Akidemia");

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {

            public void handle(WindowEvent we) {
                //request password if childlock is in use
                if (new ChildLock().childLockStatus().equals("locked")) {
                    we.consume();
                    Stage window = new Stage();
                    window.setAlwaysOnTop(true);
                    new ChangingScene().changeScene("childLockClose.fxml", window);
                }
                //childlock not in use
                else {
                    CreateFile childLockStatus = new CreateFile();
                    childLockStatus.openFile("childLockStatus.txt");
                    childLockStatus.addData("unlocked");
                    childLockStatus.closeFile();
                    System.exit(0);
                }
            }
        });

        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}



