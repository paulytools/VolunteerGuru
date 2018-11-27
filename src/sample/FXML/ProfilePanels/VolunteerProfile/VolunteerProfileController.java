package sample.FXML.ProfilePanels.VolunteerProfile;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import sample.users.User;
import sample.users.Volunteer;


public class VolunteerProfileController implements Initializable {
  @FXML public JFXButton btn_EditProfile;

  @FXML
  public Label lbl_VOLName;
  @FXML
  public Label lbl_VOLAddress;
  @FXML
  public Label lbl_VOLContact;
  @FXML
  public TextArea txtArea_VOLBIO;
  @FXML public Label lbl_tag1;
  @FXML public Label lbl_tag2;
  @FXML public Label lbl_tag3;
  @FXML public JFXButton btn_VolInvite;
  @FXML public  JFXButton  btn_VolMessage;

  public void EditProfileBTNClicked() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(
          getClass().getResource(
              "/sample/FXML/ProfilePanels/VolunteerProfile/volunteerEdit.fxml"));
      Parent profile = (Parent) fxmlLoader.load();
      Stage test = new Stage();
      test.setResizable(false);
      test.setTitle("Edit Profile");
      test.setScene(new Scene(profile));
      test.show();
    } catch (Exception e) {
      e.printStackTrace();
    }


  }
  //Should be taking in Vol.
  public void setAccount(User user) {
    lbl_VOLName.setText(user.getUserName());
    lbl_VOLAddress.setText(user.getAddress());
    lbl_VOLContact.setText(user.getEmail());
    txtArea_VOLBIO.setText(user.getAboutMe());
    lbl_tag1.setText("-" +user.getInterests()[0]);
    lbl_tag2.setText("-" +user.getInterests()[1]);
    lbl_tag3.setText("-" +user.getInterests()[2]);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}