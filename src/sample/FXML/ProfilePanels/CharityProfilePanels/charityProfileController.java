package sample.FXML.ProfilePanels.CharityProfilePanels;


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

public class charityProfileController implements Initializable {
  @FXML public JFXButton btn_EditProfile;
  @FXML private Label lbl_CharityNameTitle;
  @FXML public Label lbl_CharityName;
  @FXML public  Label lbl_CharityBIO;
  public static void setUpProfile(){

}


  public void EditProfileBTNClicked() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(
          getClass().getResource(
              "/sample/FXML/ProfilePanels/CharityProfilePanels/charityEdit.fxml"));
      Parent profile = (Parent) fxmlLoader.load();
      Stage test = new Stage();
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
}
