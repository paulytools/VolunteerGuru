package sample.FXML.HomePanel.tabController;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import sample.FXML.ProfilePanels.CharityProfilePanels.CharityProfileController;
import sample.FXML.ProfilePanels.VolunteerProfile.VolunteerProfileController;
import sample.users.Organization;
import sample.users.User;
import sample.users.Volunteer;

//test
public class HomeController {

    /* ID/Variable Declarations */
    @FXML public ComboBox cmbox_Tag;
    @FXML public Button btn_OpenLogin;
    @FXML public Button btn_SignUp;
    @FXML public Button btn_demo;
    public boolean loginStatus = false;
    
    // creates one logged-in user 
    public static User loggedInUser = null;

    @FXML
    public void OpenLoginBTNClicked() throws IOException {
        System.out.println("[Event](OPEN-Login Clicked)");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/sample/FXML/LoginPanel/login.fxml"));
            Parent LoginRoot = (Parent) fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setResizable(false);
            newStage.setTitle("Login");
            newStage.setScene(new Scene(LoginRoot));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void signUpBTNClicked() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/sample/FXML/SignUpPanel/signUp.fxml"));
            Parent SignUpRoot = (Parent) fxmlLoader.load();
            Stage newStage = new Stage();
            newStage.setTitle("SignUp");
            newStage.setResizable(false);
            newStage.setScene(new Scene(SignUpRoot));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void Org_Selected_Clicked(Organization org) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource(
                    "/sample/FXML/ProfilePanels/CharityProfilePanels/charityProfile.fxml"));
            Parent profile = (Parent) fxmlLoader.load();
            CharityProfileController Controller = fxmlLoader.getController();
            Controller.setAccount(org);
            Stage newStage = new Stage();
            newStage.setTitle("Profile");
            newStage.setScene(new Scene(profile));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void VOL_Selected_Clicked(Volunteer vol) throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource(
                    "/sample/FXML/ProfilePanels/VolunteerProfile/volunteerProfile.fxml"));
            Parent profile = (Parent) fxmlLoader.load();
            VolunteerProfileController Controller = fxmlLoader.getController();
            Controller.setAccount(vol);
            Stage newStage = new Stage();
            newStage.setTitle("Profile");
            newStage.setScene(new Scene(profile));
            newStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void setUpComboBox() {
        cmbox_Tag.getItems().addAll("Environment", "Animals", "Human Services", "International");
        cmbox_Tag.setPromptText("Select a category.");
    }
}
