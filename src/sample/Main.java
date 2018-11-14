package sample;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.users.Organization;
import sample.users.User;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Set homePanel FXML
        Parent root = FXMLLoader.load(getClass().getResource("FXML/HomePanel/homePanel.fxml"));
        //initializing Home scene/layouts
        primaryStage.setTitle("Volunteer Guru 1.0");
        primaryStage.setScene(new Scene( root, 1200,800));
        primaryStage.show();


    }


}
