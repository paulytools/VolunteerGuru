package sample.FXML.HomePanel.tabController;

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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.users.Organization;

public class tab2Controller extends HomeController implements Initializable {

  /* ID/Variable Declarations */
  @FXML public Button btn_OpenLogin;
  @FXML public Button btn_SignUp;

  @FXML private Stage stage;
  @FXML private TableView<Organization> TV_Results;
  @FXML private TableColumn<Organization, String> TC1_Organization_Name;
  @FXML private TableColumn<Organization, String> TC2_City;
  @FXML private TableColumn<Organization, String> TC3_Description;

  /* Methods / Events*/
  //Home Panel functions

  @FXML //homePanel.fxml -> login.fxml .fxml"
  public void OpenLoginBTNClicked() throws IOException {
    super.OpenLoginBTNClicked();
  }

  @FXML //homePanel.fxml -> signUp.fxml
  public void signUpBTNClicked() throws IOException {
    super.signUpBTNClicked();
  }

@Override
  public void initialize(URL url, ResourceBundle resources) {
   setUpComboBox();
    TC1_Organization_Name.setCellValueFactory(new PropertyValueFactory<Organization, String>(
        "userName"));
    TC2_City.setCellValueFactory(new PropertyValueFactory<Organization, String>(
        "address"));
    TC3_Description.setCellValueFactory(new PropertyValueFactory<Organization, String>(
        "email"));
    TV_Results.setItems(getGroup());
  }

  public ObservableList<Organization> getGroup() {
    ObservableList<Organization> Group = FXCollections.observableArrayList();
    for (int i=1 ; i <=25 ; i++) {
      Group.add(new Organization("ORGANIZATION", "[ORGANIZATION] \n Event"+i, "f", "f", "....",
          "City, State", "f"));
    }
    return Group;

  }
}
