package sample.FXML.ProfilePanels.CharityProfilePanels;


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
import sample.users.Organization;

public class CharityProfileController implements Initializable {
 // @FXML public JFXButton btn_EditProfile;
  @FXML public Label lbl_CharityName;
  @FXML private Label lbl_CharityAddress;
  @FXML private Label lbl_CharityContact;
  @FXML private TextArea txtArea_CharityBIO;

  @FXML private JFXButton JFXBTN;



  public void EditProfileBTNClicked() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(
          getClass().getResource(
              "/sample/FXML/ProfilePanels/CharityProfilePanels/charityEdit.fxml"));
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
  
  


  @Override
  public void initialize(URL location, ResourceBundle resources) {

 }



  public void setAccount(Organization org) {
    lbl_CharityName.setText(org.getUserName());
    lbl_CharityAddress.setText(org.getAddress());
    lbl_CharityContact.setText(org.getEmail());
    txtArea_CharityBIO.setText(org.getAboutMe());// need bio
  }
}
