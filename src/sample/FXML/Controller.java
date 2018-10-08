/******************************************************************************
 * Last Edit: 10/8/2018
 * File: Controller.java
 * Class: CEN 3031 - CRN 80594 - Software Engng. Fundamentals
 * Group 4. Volunteer Guru
 *
 * File Summary: Handles the program's I/O while maintains any state changes of a panel.
 ******************************************************************************/

package sample.FXML;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

  /* ID/Variable Declarations */
  private Stage stage;
  @FXML
  Button btn_Login;
  @FXML
  Button btn_SignUp;
  @FXML
  Button btn_Submit;

  /* Methods / Events*/
  //Home Panel functions
  @FXML //Change homePanel.fxml -> login.fxml
  private void loginBTNClicked() throws IOException {
    System.out.println("[Event](Login Clicked)");
    stage = (Stage) btn_Login.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
  }
  @FXML //Change homePanel -> signUp.fxml
  private void signUpBTNClicked()throws IOException {
    System.out.println("[Event](Sign-Up Clicked)");
    stage = (Stage) btn_SignUp.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("signUp.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);

  }

  //Signin Panel functions
  @FXML  //Change signUp.fxml -> homePanel.fxml
  private void submitBTNClicked()throws IOException {
    System.out.println("[Event](Submit Clicked)");
    stage = (Stage) btn_Submit.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("homePanel.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }

}