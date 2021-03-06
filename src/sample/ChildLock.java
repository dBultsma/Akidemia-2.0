package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class ChildLock {
    @FXML private Label PasswordLabel;
    @FXML private Label setPasswordLabel;
    @FXML private PasswordField setPassword;
    @FXML private PasswordField confirmPassword;
    @FXML private PasswordField checkPassword;

    private String savedPassword;// = new String();
    public String childLockStatus;// = new String();

    //compare typed password with stored password
    public void passwordChecker(ActionEvent event){
        ReadFile readPassword = new ReadFile();
        readPassword.openFile("password.txt");
        savedPassword = readPassword.readData();
        readPassword.closeFile();
        if(checkPassword.getText().contentEquals(savedPassword)){
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
        }
        else{
            PasswordLabel.setText("Your Password is wrong");
        }
    }

    //store typed password
    public void setPassword(ActionEvent event) {

        //if childlock is in use, don't allow a new password to be created
        if (new ChildLock().childLockStatus().equals("locked")) {
            setPasswordLabel.setText("A password has already been created");
        } else if(setPassword.getText().trim().isEmpty())
         {
            setPasswordLabel.setText("Need to set a password");
        } else if (confirmPassword.getText().trim().isEmpty()) {
            setPasswordLabel.setText("Need to set a password");
        } else if (setPassword.getText().equals(confirmPassword.getText())) {
             CreateFile passwordStorage = new CreateFile();
             passwordStorage.openFile("password.txt");
             passwordStorage.addData(setPassword.getText());
             passwordStorage.closeFile();

             //create file to store locked status of child lock
            CreateFile childLockStatus = new CreateFile();
            childLockStatus.openFile("childLockStatus.txt");
            childLockStatus.addData("locked");
            childLockStatus.closeFile();

            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();

            window.setOnCloseRequest(new EventHandler<WindowEvent>() {

                public void handle(WindowEvent we) {
                    we.consume();
                    Stage window = new Stage();
                    new ChangingScene().changeScene("childLockClose.fxml", window);
                }
            });
            window.close();

        } else {
            setPasswordLabel.setText("Those passwords do not match");
        }
    }

    //request password and unlock
    public void checkPasswordClose(ActionEvent event){
        ReadFile readPassword = new ReadFile();
        readPassword.openFile("password.txt");
        savedPassword = readPassword.readData();
        readPassword.closeFile();
        if(checkPassword.getText().contentEquals(savedPassword)){
            CreateFile childLockStatus = new CreateFile();
            childLockStatus.openFile("childLockStatus.txt");
            childLockStatus.addData("unlocked");
            childLockStatus.closeFile();
            System.exit(0);
        }
        else{
            PasswordLabel.setText("Your Password is wrong");
        }

    }

    // read status of child lock
    public String childLockStatus(){
        ReadFile readChildLockStatus = new ReadFile();
        readChildLockStatus.openFile("childLockStatus.txt");
        childLockStatus = readChildLockStatus.readData();
        readChildLockStatus.closeFile();
        return childLockStatus;
    }
}
