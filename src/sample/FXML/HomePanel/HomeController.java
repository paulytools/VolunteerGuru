/******************************************************************************
 * Last Edit: 10/8/2018
 *
 * Class: CEN 3031 - CRN 80594 - Software Engng. Fundamentals
 * Group 4. Volunteer Guru
 *
 * File Summary: Handles the program's I/O while maintains any state changes of a panel.
 ******************************************************************************/

package sample.FXML.HomePanel;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;


public class HomeController {

  /* ID/Variable Declarations */
  private Stage stage;
  @FXML
  private Button btn_Login;
  @FXML
  private Button btn_OpenLogin;
  @FXML
  private Button btn_SignUp;
  @FXML
  private Button btn_Submit;


  /* Methods / Events*/
  //Home Panel functions
  @FXML //Change homePanel.fxml -> login.fxml
  private void OpenLoginBTNClicked() throws IOException {
    System.out.println("[Event](OPEN-Login Clicked)");
    stage = (Stage) btn_OpenLogin.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("/sample/FXML/login.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
  }

  @FXML //Change homePanel -> signUp.fxml
  private void signUpBTNClicked()throws IOException {
    System.out.println("[Event](Sign-Up Clicked)");
    stage = (Stage) btn_SignUp.getScene().getWindow();
    Parent root = FXMLLoader.load(getClass().getResource("/sample/FXML/SignUpPanel/signUp.fxml"));
    Scene scene = new Scene(root);
    stage.setScene(scene);
  }
  //SignUP Panel functions



}