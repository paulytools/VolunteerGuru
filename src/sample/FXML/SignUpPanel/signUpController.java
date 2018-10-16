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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class signUpController implements Initializable {

    private ToggleGroup RoleToggle;
    private Stage stage;
    @FXML private RadioButton rbtn_Volunteer;
    @FXML private RadioButton rbtn_Charity;
    @FXML private Button btn_Submit;
    @FXML private Label lbl_UserHandle;

    @FXML  //Change signUp.fxml -> homePanel.fxml
    private void submitBTNClicked()throws IOException {
        System.out.println("[Event](Submit Clicked)");
        stage = (Stage) btn_Submit.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("/sample/FXML/HomePanel/homePanel.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
    }

    /**
     *
     */
    @FXML
    public void radioButtonChanged(){
        if(this.RoleToggle.getSelectedToggle().equals(this.rbtn_Volunteer)){
            lbl_UserHandle.setText("Username:");
        }
        if(this.RoleToggle.getSelectedToggle().equals(this.rbtn_Charity)){
            lbl_UserHandle.setText("Charity's Name:");
        }
    }

    @Override
    public void initialize (URL url, ResourceBundle rb) {
        RoleToggle = new ToggleGroup();
        this.rbtn_Volunteer.setToggleGroup(RoleToggle);
        this.rbtn_Charity.setToggleGroup(RoleToggle);
    }
}
