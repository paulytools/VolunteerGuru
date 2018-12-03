package sample.FXML.Inbox;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.text.Text;

public class InboxController implements Initializable {

  @FXML
  public TableView TV_Inbox;
  @FXML
  public TableColumn TC1_Messenger;
  @FXML
  public TableColumn TC2_Message;
  @FXML
  public Text lbl_Nameholder;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    //Set up table
  }

  //Function to set up table
}
