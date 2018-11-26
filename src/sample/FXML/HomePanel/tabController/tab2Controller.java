package sample.FXML.HomePanel.tabController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import sample.users.database.Database;
import sample.users.events.Event;

public class tab2Controller extends HomeController implements Initializable {

	/* ID/Variable Declarations */
	@FXML
	public JFXButton btn_OpenLogin;
	@FXML
	public JFXButton btn_SignUp;

	@FXML
	private Stage stage;
	@FXML
	private TableView<Event> TV_Results;
	@FXML
	private TableColumn<Event, String> TC1_Organization_Name;
	@FXML
	private TableColumn<Event, String> TC2_City;
	@FXML
	private TableColumn<Event, String> TC3_Description;

	/* Methods / Events */
	// Home Panel functions

	@FXML // homePanel.fxml -> login.fxml .fxml"
	public void OpenLoginBTNClicked() throws IOException {
		super.OpenLoginBTNClicked();
	}

	@FXML // homePanel.fxml -> signUp.fxml
	public void signUpBTNClicked() throws IOException {
		super.signUpBTNClicked();
	}

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		setUpComboBox();
		TC1_Organization_Name.setCellValueFactory(new PropertyValueFactory<Event, String>("tvName"));
		TC2_City.setCellValueFactory(new PropertyValueFactory<Event, String>("address"));
		TC3_Description.setCellValueFactory(new PropertyValueFactory<Event, String>("description"));
		TV_Results.setItems(getGroup());

	}

	// Display all events
	public ObservableList<Event> getGroup() {
		ObservableList<Event> group = FXCollections.observableArrayList();
		ArrayList<Event> events = Database.getEvents();
		for (int i = 0; i < events.size(); i++) {
			group.add(events.get(i));
		}
		return group;
	}
}
