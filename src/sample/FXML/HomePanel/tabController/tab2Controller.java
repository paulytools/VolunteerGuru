package sample.FXML.HomePanel.tabController;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.FXML.LoginPanel.LoginController;
import sample.users.User;
import sample.users.database.DataBase;
import sample.users.events.Event;

public class tab2Controller extends HomeController implements Initializable {

	/* ID/Variable Declarations */

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

	@Override
	public void initialize(URL url, ResourceBundle resources) {
		setUpComboBox();
		TC1_Organization_Name.setCellValueFactory(new PropertyValueFactory<Event, String>("tvName"));
		TC2_City.setCellValueFactory(new PropertyValueFactory<Event, String>("address"));
		TC3_Description.setCellValueFactory(new PropertyValueFactory<Event, String>("description"));
		TV_Results.setItems(getGroup());

    TV_Results.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        if (LoginController.hasUserLoggedIn()) {
          if (LoginController.loggedInUser.getType().equals(User.VOLUNTEER)) {
          }
        }
      }

    });
	}

	// Display all events
	public ObservableList<Event> getGroup() {
		ObservableList<Event> group = FXCollections.observableArrayList();
		ArrayList<Event> events = DataBase.getEvents();
		for (int i = 0; i < events.size(); i++) {
			group.add(events.get(i));
		}
		return group;
	}
}
