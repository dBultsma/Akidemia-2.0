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
    String password;

    public void childLockPassword(ActionEvent event) throws IOException {

        System.out.println("---------------------------Child lock-------------------");
        System.out.println("Password: " + password);
        //Getting the layout from file
        Parent childlock = FXMLLoader.load(getClass().getResource("childLock.fxml"));
        Stage childLockWindow = new Stage();
        childLockWindow.setTitle("Child lock");
        childLockWindow.setScene(new Scene(childlock));
        childLockWindow.show();
        System.out.println("Password: " + password);
    }




    public void CloseWindow(ActionEvent event){

        System.out.println("---------------------Check password--------------------------");
        System.out.println("Password: " + password);
        System.out.println("entred password: " + checkPassword.getText().toString());

        if(password.isEmpty())
        {
            PasswordLabel.setText("Need to set the password in settings");
        }
        else if(checkPassword.getText().contentEquals(password)){
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.close();
        }
        else{
            PasswordLabel.setText("Your Password is wrong");
        }
        //String message  = checkPassword(checkPassword.getText().toString());
        // PasswordLabel.setText(message);

    }

    public void setPassword(ActionEvent event) {

        //System.out.println("Password: " + setPassword.getText() + " confirm password: " + confirmPassword.getText());
        System.out.println("----------------------Setting the password--------------------------");
        if (setPassword.getText().trim().isEmpty()) {
            setPasswordLabel.setText("Need to set a password");
        } else if (confirmPassword.getText().trim().isEmpty()) {
            setPasswordLabel.setText("Need to set a password");
        } else if (setPassword.getText().equals(confirmPassword.getText())) {
            password = setPassword.getText();
            System.out.println("Password: " + password);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.close();


        } else {
            setPasswordLabel.setText("Those passwords do not match");
        }

    }

    public void toSettings(ActionEvent event) throws IOException {

        //Getting the layout from file
        password = "hello";
        System.out.println("-------------------------Settings-------------------------");
        System.out.println("Password: " + password);
        Parent SettingLayout = FXMLLoader.load(getClass().getResource("settings.fxml"));
        //Used to get the current window
        Stage window = new Stage();
        window.setScene(new Scene(SettingLayout));
        window.show();
        password = "hello";
    }

    public String checkPassword(String checkPassword){

        System.out.println("------------------check password method-------------------");
        System.out.println("password: " + password);
        String returnValue;

        //Check if a password has been set
        if(password == null)
        {
            returnValue = "Need to set the password in settings";
        }
        //Check the entered value with the set password
        else if (checkPassword.equals(password)){
            returnValue = null;
        }
        else{
            returnValue = "Your Password is wrong";
        }

        return returnValue;
    }

}
