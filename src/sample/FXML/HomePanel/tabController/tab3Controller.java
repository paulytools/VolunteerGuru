package sample.FXML.HomePanel.tabController;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import sample.users.Volunteer;

public class tab3Controller extends HomeController implements Initializable {

  /* ID/Variable Declarations */
  @FXML public JFXButton btn_OpenLogin;
  @FXML public JFXButton btn_SignUp;
  @FXML private Stage stage;
  @FXML private TableView<Volunteer> TV_Results;
  @FXML private TableColumn<Volunteer, String> TC1_Volunteer_Name;
  @FXML private TableColumn<Volunteer, String> TC2_CityVolunteer;
  @FXML private TableColumn<Volunteer, String> TC3_DescriptionVolunteer;

  /* Methods / Events*/

  @FXML // homePanel.fxml -> login.fxml
  public void OpenLoginBTNClicked() throws IOException {
    super.OpenLoginBTNClicked();
  }
  @FXML // homePanel.fxml -> signUp.fxml
  public void signUpBTNClicked() throws IOException {
    super.signUpBTNClicked();
  }

@Override
  public void initialize(URL url, ResourceBundle resources) {
  setUpComboBox();
  TC1_Volunteer_Name.setCellValueFactory(new PropertyValueFactory<Volunteer, String>(
      "userName"));
  TC2_CityVolunteer.setCellValueFactory(new PropertyValueFactory<Volunteer, String>(
      "address"));
  TC3_DescriptionVolunteer.setCellValueFactory(new PropertyValueFactory<Volunteer, String>(
      "email"));
  TV_Results.setItems(getGroup());

  TV_Results.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Volunteer>() {
    @Override
    public void changed(ObservableValue<? extends Volunteer> observable, Volunteer oldValue, Volunteer newValue) {
      System.out.println(newValue.getUserName());
      try{
        VOL_Selected_Clicked();
      } catch (IOException e) {
        e.printStackTrace();
      } }
  });
}

  public ObservableList<Volunteer> getGroup() {
      List<String> Name =  Arrays.asList("Roberts","Cooper","Anderson","Kim","Williams","Rex",
          "Stephens","Grace","Hellen","Megan","Phoebe","Nick");
      List<String> City = Arrays.asList("Miami, FL","Naples, FL","St.PetersBurg, FL","Tampa, FL");
    Random rand = new Random();
    int idNum;
    int pickCity;
    int pickName;

    ObservableList<Volunteer> Group = FXCollections.observableArrayList();
    Group.add(new Volunteer("VOLUNTEER", "CarlosPerez1001", "f", "f", "....","Naples", "f"));
    //Generates Volunteer
    for(int i = 0; i < 25;i++){
      idNum = rand.nextInt(9000)+1000;
      pickCity =rand.nextInt(City.size());
      pickName =rand.nextInt(Name.size());
      Group.add(new Volunteer("VOLUNTEER",Name.get(pickName)+idNum,"","","....",City.get(pickCity),""));
    }

    return Group;
  }
}
