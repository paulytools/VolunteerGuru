package sample.FXML.HomePanel.tabController;

import java.io.IOException;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import sample.FXML.ProfilePanels.ORGProfilePanels.OrgProfileController;
import sample.FXML.ProfilePanels.VolunteerProfile.VolunteerProfileController;
import sample.users.Organization;
import sample.users.User;
import sample.users.Volunteer;

//test
public class HomeController {

	/* ID/Variable Declarations */

	// needs to be array
	@FXML
	public ComboBox cmbox_Tag;
	@FXML
	public JFXButton btn_OpenLogin1;
	@FXML
	public JFXButton btn_OpenLogin2;
	@FXML
	public JFXButton btn_OpenLogin3;

	@FXML
	public JFXButton btn_SignUp1;
	@FXML
	public JFXButton btn_SignUp2;
	@FXML
	public JFXButton btn_SignUp3;
	@FXML
	public JFXButton btn_Username1;
	@FXML
	public JFXButton btn_Username2;
	@FXML
	public JFXButton btn_Username3;
	public boolean loginStatus = false;

	// creates one logged-in user
	public static User loggedInUser = null;

	public void LoginUser() {
		// needs a loop
		btn_OpenLogin1.setVisible(false);
		btn_OpenLogin2.setVisible(false);
		btn_OpenLogin3.setVisible(false);
		btn_SignUp1.setVisible(false);
		btn_SignUp2.setVisible(false);
		btn_SignUp3.setVisible(false);
		btn_Username1.setVisible(true);
		btn_Username1.setText(loggedInUser.getUserName());
		btn_Username1.setStyle("-fx-translate-x: 225px");
		btn_Username2.setVisible(true);
		btn_Username2.setText(loggedInUser.getUserName());
		btn_Username2.setStyle("-fx-translate-x: 225px");
		btn_Username3.setVisible(true);
		btn_Username3.setText(loggedInUser.getUserName());
		btn_Username3.setStyle("-fx-translate-x: 225px");
//    System.out.println(loggedInUser.getUserData());

	}

	public void UserProfileAccount() {
		if (loggedInUser.getType().equals(User.VOLUNTEER)) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(
						getClass()
								.getResource("/sample/FXML/ProfilePanels/VolunteerProfile/volunteerProfile.fxml"));
				Parent profile = (Parent) fxmlLoader.load();
				VolunteerProfileController Controller = fxmlLoader.getController();
				Controller.setAccount(loggedInUser);
				Controller.btn_EditProfile.setVisible(true);
				Controller.btn_VolInvite.setText("Log out");
				Controller.btn_VolMessage.setText("Inbox");
				Stage newStage = new Stage();
				newStage.setTitle("Profile");
				newStage.setResizable(false);
				newStage.setScene(new Scene(profile));
				newStage.show();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(
						getClass().getResource("/sample/FXML/ProfilePanels/ORGProfilePanels/orgProfile.fxml"));
				Parent profile = (Parent) fxmlLoader.load();
				OrgProfileController Controller = fxmlLoader.getController();
				Controller.setAccount(loggedInUser);
				Controller.btn_EditProfile.setVisible(true);
				Controller.btn_OrgMessage.setText("Log out");
				Controller.btn_OrgFollow.setText("Inbox");
				Stage newStage = new Stage();
				newStage.setTitle("Profile");
				newStage.setScene(new Scene(profile));
				newStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

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
					getClass().getResource("/sample/FXML/ProfilePanels/ORGProfilePanels/orgProfile.fxml"));
			Parent profile = (Parent) fxmlLoader.load();
			OrgProfileController Controller = fxmlLoader.getController();
			Controller.setAccount(org);
			Stage newStage = new Stage();
			newStage.setTitle("Profile");
			newStage.setScene(new Scene(profile));
			newStage.setResizable(false);
			newStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void VOL_Selected_Clicked(Volunteer vol) throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass()
							.getResource("/sample/FXML/ProfilePanels/VolunteerProfile/volunteerProfile.fxml"));
			Parent profile = (Parent) fxmlLoader.load();
			VolunteerProfileController Controller = fxmlLoader.getController();
			Controller.setAccount(vol);
			Stage newStage = new Stage();
			newStage.setTitle("Profile");
			newStage.setScene(new Scene(profile));
			newStage.setResizable(false);
			newStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static boolean hasUserLoggedIn() {
		if (loggedInUser == null) {
			return false;
		}
		return true;
	}

	public void setUpComboBox() {
		cmbox_Tag.getItems().addAll("Environment", "Animals", "Human Services", "International");
		cmbox_Tag.setPromptText("Select a category.");
	}
}
