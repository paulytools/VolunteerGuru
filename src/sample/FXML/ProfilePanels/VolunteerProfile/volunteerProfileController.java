package sample.FXML.ProfilePanels.VolunteerProfile;


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;




public class volunteerProfileController  implements Initializable {
  @FXML public JFXButton btn_EditProfile;

  @FXML
  public Label lbl_VOLName;

  @FXML
  public Label lbl_VOLAddress;
  @FXML
  public Label lbl_VOLContact;
  @FXML
  public Label lbl_VOLBIO;




  public void setAccount(String name,String address, String Contact,String Bio) {
    lbl_VOLName.setText(name);
    lbl_VOLAddress.setText(address);
    lbl_VOLContact.setText(Contact);
    lbl_VOLBIO.setText(Contact);
  }

  @Override
  public void initialize(URL location, ResourceBundle resources) {

  }
}