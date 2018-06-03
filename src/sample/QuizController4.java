package sample;

import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.scene.control.Label;


public class QuizController4 implements Initializable{

    @FXML public AnchorPane quizStart;
    @FXML public Button startButton;
    @FXML public Button backButton;

    @FXML public AnchorPane question1;
    @FXML public Button confirmButton1;
    @FXML public Button nextQuestion1;
    @FXML public RadioButton radioB1;
    @FXML public RadioButton radioB2;
    @FXML public RadioButton radioB3;
    @FXML public RadioButton radioB4;

    @FXML public AnchorPane question2;
    @FXML public Button confirmButton2;
    @FXML public Button nextQuestion2;
    @FXML public RadioButton radioB5;
    @FXML public RadioButton radioB6;
    @FXML public RadioButton radioB7;
    @FXML public RadioButton radioB8;

    @FXML public AnchorPane question3;
    @FXML public Button confirmButton3;
    @FXML public Button nextQuestion3;
    @FXML public RadioButton radioB9;
    @FXML public RadioButton radioB10;
    @FXML public RadioButton radioB11;
    @FXML public RadioButton radioB12;

    @FXML public AnchorPane question4;
    @FXML public Button confirmButton4;
    @FXML public Button nextButton;
    @FXML public RadioButton radioB13;
    @FXML public RadioButton radioB14;
    @FXML public RadioButton radioB15;
    @FXML public RadioButton radioB16;

    @FXML public AnchorPane quizFinished;
    @FXML public Button mapButton;

    @FXML public Label score100;
    @FXML public Label score75;
    @FXML public Label score50;
    @FXML public Label score25;
    @FXML public Label score0;

    @FXML public Label correctLabel;
    @FXML public Label incorrectLabel;


    int score = 0;
    int score1;
    int score2;
    int score3;
    int score4;

    ChangingScene sc = new ChangingScene();

    //add in visible to different buttons etc

        public void selectRadioB1to4(ActionEvent event) throws IOException {
            confirmButton1.setDisable((false));
        }
        public void selectRadioB5to8(ActionEvent event) throws IOException {
            confirmButton2.setDisable((false));
        }
        public void selectRadioB9to12(ActionEvent event) throws IOException {
            confirmButton3.setDisable((false));
        }
        public void selectRadioB13to16(ActionEvent event) throws IOException {
            confirmButton4.setDisable((false));
        }

        public void startPressed(ActionEvent event) throws IOException {
            quizStart.setVisible(false);
            question1.setVisible(true);

            confirmButton1.setDisable(true);
            confirmButton2.setDisable(true);
            confirmButton3.setDisable(true);
            confirmButton4.setDisable(true);

            nextQuestion1.setDisable(true);
            nextQuestion2.setDisable(true);
            nextQuestion3.setDisable(true);
            nextButton.setDisable(true);

            score0.setVisible(false);
            score25.setVisible(false);
            score50.setVisible(false);
            score75.setVisible(false);
            score100.setVisible(false);

            correctLabel.setVisible(false);
            incorrectLabel.setVisible(false);
        }

        public void confirm1Pressed(ActionEvent event) throws IOException {
            if (radioB3.isSelected())
            {
                int correct1 = 1;
                score1 = score + 1;
                //correct
                confirmButton1.setDisable(true);
                radioB1.setDisable(true);
                radioB2.setDisable(true);
                radioB3.setDisable(true);
                radioB4.setDisable(true);
                nextQuestion1.setDisable(false);
                correctLabel.setVisible(true);
            }

            else
            {
                int incorrect1 = 0;
                score1 = score + incorrect1;
                confirmButton1.setDisable(true);
                radioB1.setDisable(true);
                radioB2.setDisable(true);
                radioB3.setDisable(true);
                radioB4.setDisable(true);
                nextQuestion1.setDisable(false);
                incorrectLabel.setVisible(true);
            }
        }

        public void nextQ1Pressed(ActionEvent event) throws IOException {
            question1.setVisible(false);
            question2.setVisible(true);

            correctLabel.setVisible(false);
            incorrectLabel.setVisible(false);
        }

    public void confirm2Pressed(ActionEvent event) throws IOException {
        if (radioB8.isSelected())
        {
            int correct2 = 1;
            score2 = score1 + correct2;
            //correct
            confirmButton2.setDisable(true);
            radioB5.setDisable(true);
            radioB6.setDisable(true);
            radioB7.setDisable(true);
            radioB8.setDisable(true);
            nextQuestion2.setDisable(false);
            correctLabel.setVisible(true);
        }

        else
        {
            int incorrect2 = 0;
            score2 = score1 + incorrect2;
            confirmButton2.setDisable(true);
            radioB5.setDisable(true);
            radioB6.setDisable(true);
            radioB7.setDisable(true);
            radioB8.setDisable(true);
            nextQuestion2.setDisable(false);
            incorrectLabel.setVisible(true);
        }
    }

    public void nextQ2Pressed(ActionEvent event) throws IOException {
        question2.setVisible(false);
        question3.setVisible(true);

        correctLabel.setVisible(false);
        incorrectLabel.setVisible(false);
    }

    public void confirm3Pressed(ActionEvent event) throws IOException {
        if (radioB9.isSelected())
        {
            int correct3 = 1;
            score3 = score2 + correct3;
            //correct
            confirmButton3.setDisable(true);
            radioB9.setDisable(true);
            radioB10.setDisable(true);
            radioB11.setDisable(true);
            radioB12.setDisable(true);
            nextQuestion3.setDisable(false);
            correctLabel.setVisible(true);
        }

        else
        {
            int incorrect3 = 0;
            score3 = score2 + incorrect3;
            confirmButton3.setDisable(true);
            radioB9.setDisable(true);
            radioB10.setDisable(true);
            radioB11.setDisable(true);
            radioB12.setDisable(true);
            nextQuestion3.setDisable(false);
            incorrectLabel.setVisible(true);
        }
    }

    public void nextQ3Pressed(ActionEvent event) throws IOException {
        question3.setVisible(false);
        question4.setVisible(true);

        correctLabel.setVisible(false);
        incorrectLabel.setVisible(false);
    }

    public void confirm4Pressed(ActionEvent event) throws IOException {
        if (radioB15.isSelected())
        {
            int correct4 = 1;
            score4 = score3 + correct4;
            //correct
            confirmButton4.setDisable(true);
            radioB13.setDisable(true);
            radioB14.setDisable(true);
            radioB15.setDisable(true);
            radioB16.setDisable(true);
            nextButton.setDisable(false);
            correctLabel.setVisible(true);
        }

        else
        {
            int incorrect4 = 0;
            score4 = score3 + incorrect4;
            confirmButton4.setDisable(true);
            radioB13.setDisable(true);
            radioB14.setDisable(true);
            radioB15.setDisable(true);
            radioB16.setDisable(true);
            nextButton.setDisable(false);
            incorrectLabel.setVisible(true);
        }
    }

    public void nextPressed(ActionEvent event) throws IOException {
        question4.setVisible(false);
        quizFinished.setVisible(true);

        correctLabel.setVisible(false);
        incorrectLabel.setVisible(false);

        if(score4 == 0) {
            score0.setVisible(true);
        }
        else if(score4 == 1) {
            score25.setVisible(true);
        }
        else if(score4 == 2) {
            score50.setVisible(true);
        }
        else if(score4 == 3) {
            score75.setVisible(true);
        }
        else if(score4 == 4) {
            score100.setVisible(true);
        }
    }


    public void mapButtonPressed(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("map.fxml", window);
    }

    public void backPressed(ActionEvent event) throws IOException {
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        sc.changeScene("area4.fxml", window);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
