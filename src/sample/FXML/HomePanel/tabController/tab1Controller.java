package sample.FXML.HomePanel.tabController;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.users.Organization;

public class tab1Controller extends HomeController implements Initializable {

  /* ID/Variable Declarations */
  @FXML public Button btn_OpenLogin;
  @FXML public Button btn_SignUp;
  @FXML public Button btn_demo;

  @FXML private Stage stage;
  @FXML private TableView<Organization> TV_Results;
  @FXML private TableColumn<Organization, String> TC1_Organization_Name;
  @FXML private TableColumn<Organization, String> TC2_City;
  @FXML private TableColumn<Organization, String> TC3_Description;


  /* Methods / Events*/
  //Home Panel functions
  @FXML //homePanel.fxml -> login.fxml"
  public void OpenLoginBTNClicked() throws IOException {
    super.OpenLoginBTNClicked();
  }

  @FXML // homePanel.fxml -> signUp.fxml
  public void signUpBTNClicked() throws IOException {
    super.signUpBTNClicked();
  }
  public void demoBTNClicked() throws IOException {
    super.demoUpBTNClicked();
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

  //Organization Object list
  public ObservableList<Organization> getGroup() {
    ObservableList<Organization> Group = FXCollections.observableArrayList();
    Group.add(new Organization("ORGANIZATION", "Boys and Girls Club of America", "", "",
        "Boys & Girls Clubs of America is a national organization of local chapters which provide after-school programs for young people",
        "Naples, FL", "password"));
    Group.add(new Organization("ORGANIZATION", "Goodwill", "", "",
        "Goodwill Industries International Inc.,"
            + " or shortened to Goodwill, is an American nonprofit 501 organization that provides "
            + "job training, employment placement services, and other community-based programs for people who have barriers preventing them from otherwise obtaining a job. ",
        "Fort Myers, FL", "f"));
    Group.add(new Organization("ORGANIZATION", "Direct Relief", "", "",
        "Direct Relief is a nonprofit, nonpartisan organization with a stated mission to “improve the health and lives of people affected by poverty or emergency situations by mobilizing and providing essential medical resources needed for their care",
        "N/A", "f"));

    return Group;
  }

}
