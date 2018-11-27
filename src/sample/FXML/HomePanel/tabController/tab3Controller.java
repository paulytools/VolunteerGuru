package sample.FXML.HomePanel.tabController;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;

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
import sample.users.Volunteer;
import sample.users.database.DataBase;

public class tab3Controller extends HomeController implements Initializable {

	/* ID/Variable Declarations */

	@FXML
	private Stage stage;
	@FXML
	private TableView<Volunteer> TV_Results;
	@FXML
	private TableColumn<Volunteer, String> TC1_Volunteer_Name;
	@FXML
	private TableColumn<Volunteer, String> TC2_CityVolunteer;
	@FXML
	private TableColumn<Volunteer, String> TC3_DescriptionVolunteer;

	/* Methods / Events */


	@Override
	public void initialize(URL url, ResourceBundle resources) {
		setUpComboBox();
		TC1_Volunteer_Name.setCellValueFactory(new PropertyValueFactory<Volunteer, String>("tvName"));
		TC2_CityVolunteer.setCellValueFactory(new PropertyValueFactory<Volunteer, String>("address"));
		TC3_DescriptionVolunteer.setCellValueFactory(new PropertyValueFactory<Volunteer, String>("aboutMe"));
		TV_Results.setItems(getGroup());

		TV_Results.setOnMouseClicked(new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent click) {
				if (click.getClickCount() == 2) {
					// Use ListView's getSelected Item
					Volunteer currentItemSelected = TV_Results.getSelectionModel().getSelectedItem();

					System.out.println(currentItemSelected.toString());
					// use this to do whatever you want to. Open Link etc.
					try {
						VOL_Selected_Clicked(currentItemSelected);

					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		});
	}

	// Displays all volunteers from Database
	public ObservableList<Volunteer> getGroup() {
		ObservableList<Volunteer> group = FXCollections.observableArrayList();
		ArrayList<Volunteer> volunteers = DataBase.getVolunteers();
		for (int i = 0; i < volunteers.size(); i++) 
		group.add(volunteers.get(i));
		return group;
	}
}
