package sample.FXML.SignUpPanel;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import sample.users.User;
import sample.users.database.DataBase;

public class signUpController implements Initializable {

	private ToggleGroup RoleToggle;
	private Stage stage;
	@FXML
	private RadioButton rbtn_Volunteer;
	@FXML
	private RadioButton rbtn_Charity;
	@FXML
	private Button btn_Submit;
	@FXML
	private Label lbl_UserHandle;
	@FXML private  Label lbl_SignUpError;
	@FXML private TextField txtFL_UserHandle;
	@FXML private TextField txtFL_FirstName;
	@FXML private TextField txtFL_LastName;
	@FXML private TextField txtFL_Email;
	@FXML private TextField txtFL_Address;
	@FXML private TextField txtFL_Password;
	@FXML private TextField txtFL_CPassword;

	private void saveUser() throws IOException {
		// gets the text from the textfields
		String type = "";
		String userName = txtFL_UserHandle.getText();
		String firstName = txtFL_FirstName.getText();
		String lastName = txtFL_LastName.getText();
		String email = txtFL_Email.getText();
		String address = txtFL_Address.getText();
		String password = txtFL_Password.getText();
//		String cPassword = txtFL_CPassword.getText();

		// checks for all fields being completed
		if (userName.equals("") || firstName.equals("") || lastName.equals("") || email.equals("")//
				|| address.equals("") || password.equals(""))
			return;

		if (rbtn_Volunteer.isSelected()) {
			type = User.VOLUNTEER;
		} else {
			type = User.ORGANIZATION;
		}
		// creates a user based on data provided
		User newUser = new User(type, userName, firstName, lastName, email, address, password);

		// checks if account already exists
		//Doesn't seem to be working rn (CP)
		if (DataBase.accountExists(newUser.getUserName(), newUser.getPassword())) {
			System.out.println("Account already exists.");
			lbl_SignUpError.setText("Error-Test");
			return;
		}

		// stores user in database
		DataBase.saveAccount(newUser);

		// goes to next page
		System.out.println("Valid");
		Stage stage = (Stage) btn_Submit.getScene().getWindow();
		stage.close();

	}

	@FXML //Change signUp.fxml -> homePanel.fxml
	private void submitBTNClicked() throws IOException {
		System.out.println("[Event](Submit Clicked)");
		saveUser();
	}

	@FXML
	public void radioButtonChanged() {
		if (this.RoleToggle.getSelectedToggle().equals(this.rbtn_Volunteer)) {
			lbl_UserHandle.setText("Username:");
		}
		if (this.RoleToggle.getSelectedToggle().equals(this.rbtn_Charity)) {
			lbl_UserHandle.setText("Charity's Name:");
		}
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		RoleToggle = new ToggleGroup();
		this.rbtn_Volunteer.setToggleGroup(RoleToggle);
		this.rbtn_Charity.setToggleGroup(RoleToggle);
		this.rbtn_Volunteer.setSelected(true);
	}
}
