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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import sample.users.Organization;
import sample.users.database.DataBase;

public class tab1Controller extends HomeController implements Initializable {

  /* ID/Variable Declarations */

  @FXML
  public TextField txtFL_SearchCharity;
  @FXML
  public JFXButton btn_Search;

  @FXML
  private Stage stage;
  @FXML
  private TableView<Organization> TV_Results;
  @FXML
  private TableColumn<Organization, String> TC1_Organization_Name;
  @FXML
  private TableColumn<Organization, String> TC2_City;
  @FXML
  private TableColumn<Organization, String> TC3_Description;

  /* Methods / Events */
  // Home Panel functions
  // homePanel.fxml -> login.fxml"

  @Override
  public void initialize(URL url, ResourceBundle resources) {
    setUpComboBox();
    TC1_Organization_Name
        .setCellValueFactory(new PropertyValueFactory<Organization, String>("tvName"));
    TC2_City.setCellValueFactory(new PropertyValueFactory<Organization, String>("address"));
    TC3_Description.setCellValueFactory(new PropertyValueFactory<Organization, String>("aboutMe"));
    TV_Results.setItems(getGroup(DataBase.getOrganizations()));

    // Row Selected listener
    TV_Results.setOnMouseClicked(new EventHandler<MouseEvent>() {
      @Override
      public void handle(MouseEvent click) {
        if (click.getClickCount() == 2) {
          // Use ListView's getSelected Item
          Organization currentItemSelected = TV_Results.getSelectionModel().getSelectedItem();
          // use this to do whatever you want to. Open Link etc.
          try {
            Org_Selected_Clicked(currentItemSelected);
          } catch (IOException e) {
            e.printStackTrace();
          }
        }
      }
    });

    btn_Search.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        ArrayList<Organization> organizations = DataBase.getOrganizations();
        String filterText = txtFL_SearchCharity.getText();
        if (filterText.equals("")) {
          TV_Results.setItems(getGroup(organizations));
        }
        ArrayList<Organization> filteredOrg = new ArrayList<Organization>();
        for (int i = 0; i < organizations.size(); i++) {
          if (organizations.get(i).getUserName().startsWith(filterText)) {
            filteredOrg.add(organizations.get(i));
          }
        }
        TV_Results.setItems(getGroup(filteredOrg));
      }
    });

    TV_Results.setOnMouseEntered(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        TV_Results.refresh();
      }
    });
  }

	// Displays all volunteers from Database
  public ObservableList<Organization> getGroup(ArrayList<Organization> organizations) {
		ObservableList<Organization> group = FXCollections.observableArrayList();
    for (int i = 0; i < organizations.size(); i++) {
      group.add(organizations.get(i));
    }
		return group;
	}

  public TableView<Organization> getTV_Results() {
    return TV_Results;
  }
}