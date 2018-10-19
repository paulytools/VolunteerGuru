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
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.users.Organization;
import sample.users.User;

// implements Initializable
public class HomeController {

  /* ID/Variable Declarations */
  private Stage stage;
  @FXML private TableView<User> TV_Results;
  @FXML private TableColumn<User, String> TC1_Organization_Name;
  @FXML private TableColumn <User, String> TC2_Description;
  @FXML private TableColumn<User, String> TC3_City;
  @FXML private Button btn_OpenLogin;
  @FXML private Button btn_SignUp;

  /* Methods / Events*/
  //Home Panel functions
  @FXML //Change homePanel.fxml -> login.fxml /sample/FXML/LoginPanel/login.fxml"
  private void OpenLoginBTNClicked() throws IOException {
    System.out.println("[Event](OPEN-Login Clicked)");
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/FXML/LoginPanel/login.fxml"));
      Parent LoginRoot = (Parent) fxmlLoader.load();
      Stage loginStage = new Stage();
      loginStage.setTitle("Login");
      loginStage.setScene(new Scene(LoginRoot));
      loginStage.show();
    }catch(Exception e) {
    e.printStackTrace();
  }
  }

  @FXML //Change homePanel.fxml -> signUp.fxml /sample/FXML/SignUpPanel/signUp.fxml
  private void signUpBTNClicked()throws IOException {
    try{
      FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample/FXML/SignUpPanel/signUp.fxml"));
      Parent SignUpRoot = (Parent) fxmlLoader.load();
      Stage signUpStage = new Stage();
      signUpStage.setTitle("SignUp");
      signUpStage.setScene(new Scene(SignUpRoot));
      signUpStage.show();
    }catch(Exception e) {
      e.printStackTrace();
    }
  }
//Setting up Objects to table. Need help, Objects are not created yet from the database. CP
// Tab1 Find Organization

// @Override
//    public void initialize(URL url, ResourceBundle rb){
//      TC1_Organization_Name.setCellValueFactory(new PropertyValueFactory<User, String>(
//          "username"));
//      TC2_Description.setCellValueFactory(new PropertyValueFactory<User, String>(
//          "Description"));
//      TC3_City.setCellValueFactory(new PropertyValueFactory<User, String>(
//          "City"));
//      TV_Results.setItems(getGroup());
//
//    }
//    public ObservableList<User>getGroup(){
//      ObservableList<User>Group = FXCollections.observableArrayList();
//      Group.add(new User ( "ORGANIZATION","f","f","f","f","f","f"));
//      return Group;
//
//    }
  }


