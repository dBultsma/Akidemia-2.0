package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.io.IOException;

public class ChildLock {
    @FXML
    private Label PasswordLabel;
    @FXML private Label setPasswordLabel;
    @FXML private PasswordField setPassword;
    @FXML private PasswordField confirmPassword;
    @FXML private PasswordField checkPassword;

    private String savedPassword = new String();

    public void passwordChecker(ActionEvent event){

        System.out.println("---------------------Check password--------------------------");


        ReadFile readPassword = new ReadFile();
        readPassword.openFile("password.txt");
        savedPassword = readPassword.readData();
        readPassword.closeFile();

       /* if(savedPassword == "")
        {
            PasswordLabel.setText("Need to set the password in settings");
        }*/ //revist later
        if(checkPassword.getText().contentEquals(savedPassword)){
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
        }
        else{
            PasswordLabel.setText("Your Password is wrong");
        }

    }

    public void setPassword(ActionEvent event) {
        System.out.println("----------------------Setting the password--------------------------");
        if (setPassword.getText().trim().isEmpty()) {
            setPasswordLabel.setText("Need to set a password");
        } else if (confirmPassword.getText().trim().isEmpty()) {
            setPasswordLabel.setText("Need to set a password");
        } else if (setPassword.getText().equals(confirmPassword.getText())) {
             CreateFile passwordStorage = new CreateFile();
             passwordStorage.openFile("password.txt");
             passwordStorage.addData(setPassword.getText());
             passwordStorage.closeFile();
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();
        } else {
            setPasswordLabel.setText("Those passwords do not match");
        }

    }

}
