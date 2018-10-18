/******************************************************************************
 * Last Edit: 10/8/2018
 *
 * Class: CEN 3031 - CRN 80594 - Software Engng. Fundamentals
 * Group 4. Volunteer Guru
 *
 * File Summary: Handles the program's I/O while maintains any state changes of a panel.
 ******************************************************************************/

package sample.FXML;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import sample.users.database.DataBase;

public class Controller {

	/* ID/Variable Declarations */
	private Stage stage;

	@FXML
	private Button btn_Login;
	@FXML
	private Button btn_OpenLogin;
	@FXML
	private Button btn_SignUp;
	@FXML
	private Button btn_Submit;
	@FXML
	private TextField userNameField;
	@FXML
	private TextField passwordField;

	/* Methods / Events*/
	//Home Panel functions
	@FXML //Change homePanel.fxml -> login.fxml
	private void OpenLoginBTNClicked() throws IOException {
		System.out.println("[Event](Login Clicked)");
		stage = (Stage) btn_OpenLogin.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}

	@FXML
	private void loginBTNClicked() throws IOException {
		System.out.println("[Event](Login Clicked)");
		boolean exists = DataBase.accountExists(userNameField.getText(), passwordField.getText());
		if (exists) {
			stage = (Stage) btn_Login.getScene().getWindow();
			Parent root = FXMLLoader.load(getClass().getResource("HomePanel/homePanel.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
		}
		// This prob should be a label on the screen telling you that the account does not exists
		// but it's up to you Carlos if you think the print line is fine.
		System.out.println("Please try again: Account does not exists!");
	}

	@FXML //Change homePanel -> signUp.fxml
	private void signUpBTNClicked() throws IOException {
		System.out.println("[Event](Sign-Up Clicked)");
		stage = (Stage) btn_SignUp.getScene().getWindow();
		Parent root = FXMLLoader.load(getClass().getResource("SignUpPanel/signUp.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
	}
	//SignUP Panel functions

}