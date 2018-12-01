package sample.FXML.ProfilePanels.VolunteerProfile;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.FXML.HomePanel.tabController.HomeController;
import sample.users.Organization;
import sample.users.User;
import sample.users.Volunteer;
import sample.users.database.DataBase;

public class VolunteerProfileController implements Initializable {

	@FXML
	public JFXButton btn_EditProfile;

	@FXML
	public Label lbl_VOLName;
	@FXML
	public Label lbl_VOLAddress;
	@FXML
	public Label lbl_VOLContact;
	@FXML
	public TextArea txtArea_VOLBIO;
	@FXML
	public Label lbl_tag1;
	@FXML
	public Label lbl_tag2;
	@FXML
	public Label lbl_tag3;
	@FXML
	public JFXButton btn_VolInvite;
	@FXML
	public JFXButton btn_VolMessage;
	@FXML
	public ListView<String> listView_Host;


	public void EditProfileBTNClicked() throws IOException {
		try {
			FXMLLoader fxmlLoader = new FXMLLoader(
					getClass().getResource("/sample/FXML/ProfilePanels/VolunteerProfile/volunteerEdit.fxml"));
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

	// Should be taking in Vol.
	public void setAccount(User user) {
		lbl_VOLName.setText(user.getUserName());
		lbl_VOLAddress.setText(user.getAddress());
		lbl_VOLContact.setText(user.getEmail());
		txtArea_VOLBIO.setText(user.getAboutMe());
		lbl_tag1.setText("-" + user.getInterests()[0]);
		lbl_tag2.setText("-" + user.getInterests()[1]);
		lbl_tag3.setText("-" + user.getInterests()[2]);
		// Displays all organizations inviting an organization
		ArrayList<String> names = DataBase.getAVolunteer(lbl_VOLName.getText()).getHostName();
		if (!names.isEmpty()) {
			ObservableList<String> orgs = FXCollections
					.observableArrayList("Organization " + names + " has sent you an invite!");
			listView_Host.setItems(orgs);
		}
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btn_VolInvite.setOnMouseClicked(new EventHandler<MouseEvent>() {
			public void handle(MouseEvent e) {
				// Checks that a user is actually logged-in
				if (HomeController.hasUserLoggedIn()) {
					if (HomeController.loggedInUser instanceof Organization) {
						Organization organization = (Organization) HomeController.loggedInUser;
						Volunteer volunteer = DataBase.getAVolunteer(lbl_VOLName.getText());
						organization.inviteVolunteer(volunteer);
					}
				}
			}

		});
	}
}