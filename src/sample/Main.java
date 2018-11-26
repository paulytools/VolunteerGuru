package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.users.Volunteer;
import sample.users.database.Database;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
		Volunteer volunteer = Database.getVolunteers().get(0);
		Database.getOrganizations().get(0).inviteVolunteer(volunteer);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// Set homePanel FXML
		Parent root = FXMLLoader.load(getClass().getResource("FXML/HomePanel/homePanel.fxml"));
		// initializing Home scene/layouts

		primaryStage.setTitle("Volunteer Guru 1.0");
		primaryStage.setScene(new Scene(root, 1200, 620));
		primaryStage.show();
	}

}
