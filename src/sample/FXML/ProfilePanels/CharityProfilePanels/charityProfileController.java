package sample.FXML.ProfilePanels.CharityProfilePanels;


import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import sample.users.Organization;

public class charityProfileController{
  @FXML public JFXButton btn_EditProfile;
  @FXML private Label lbl_CharityNameTitle;
  @FXML public Label lbl_CharityName;
  @FXML public  Label lbl_CharityBIO;

  public static void setUpProfile(){
    System.out.println("Help");

}


  public void EditProfileBTNClicked() throws IOException {
    try {
      FXMLLoader fxmlLoader = new FXMLLoader(
          getClass().getResource(
              "/sample/FXML/ProfilePanels/CharityProfilePanels/CharityProfileEdit.fxml"));
      Parent profile = (Parent) fxmlLoader.load();
      Stage test = new Stage();
      test.setTitle("Edit Profile");
      test.setScene(new Scene(profile));
      test.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}