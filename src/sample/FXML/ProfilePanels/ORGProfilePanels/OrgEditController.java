package sample.FXML.ProfilePanels.ORGProfilePanels;

import java.io.File;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTimePicker;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import sample.FXML.LoginPanel.LoginController;
import sample.users.database.DataBase;
import sample.users.events.Event;

public class OrgEditController implements Initializable {

  @FXML
  GridPane GP_EditProfilePic;
  @FXML
  ImageView IVew_CurrentEdit;
  @FXML
  ImageView IVew_User1, IVew_User2, IVew_User3, IVew_User4, IVew_User5, IVew_User6, IVew_User7, IVew_User8,
      IVew_User9;
  @FXML
  TextField txtFL_EventName;
  @FXML
  TextField txtFL_EventWhere;
  @FXML
  TextArea txtEvent_About;
  @FXML
  DatePicker datePicker_Event;
  @FXML
  JFXTimePicker timePicker_Event;
  @FXML
  TextField txtFL_EventGoal;
  @FXML
  JFXButton btn_CreateEvent;

  @Override
  public void initialize(URL location, ResourceBundle resources) {
    ProfilePicEvents();
    btn_CreateEvent.setOnMouseClicked(new EventHandler<MouseEvent>() {
      public void handle(MouseEvent e) {
        System.out.println("Event Host: " + LoginController.loggedInUser.getUserName());
        System.out.println("Event Name: " + txtFL_EventName.getText());
        System.out.println("Event Location: " + txtFL_EventWhere.getText());
        System.out.println("Event Date: " + datePicker_Event.getValue().toString());
        System.out.println("Event Time:" + timePicker_Event.getValue().toString());
        System.out.println("Event Description: " + txtEvent_About.getText());
        System.out.println("Event goal: " + txtFL_EventGoal.getText());

        String host = LoginController.loggedInUser.getUserName();
        String name = (txtFL_EventName.getText());
        String location = (txtFL_EventWhere.getText());
        String date = (datePicker_Event.getValue().toString());
        String time = (timePicker_Event.getValue().toString());
        String description = (txtEvent_About.getText());
        int goal = new Integer(txtFL_EventGoal.getText());

        Event event = new Event(host, name, date, time, location, goal);
        event.setDescription(description);
        DataBase.saveEvent(event);

      }
    });
    ;
  }

  public void ResetTable() {
    IVew_User1.setStyle("-fx-effect: null;");
    IVew_User2.setStyle("-fx-effect: null;");
    IVew_User3.setStyle("-fx-effect: null;");
    IVew_User4.setStyle("-fx-effect: null;");
    IVew_User5.setStyle("-fx-effect: null;");
    IVew_User6.setStyle("-fx-effect: null;");
    IVew_User7.setStyle("-fx-effect: null;");
    IVew_User8.setStyle("-fx-effect: null;");
    IVew_User9.setStyle("-fx-effect: null;");

  }

  public void ProfilePicEvents() {
    for (Node node : GP_EditProfilePic.getChildren()) {
      node.setOnMouseEntered((MouseEvent t) -> {
        node.setStyle("-fx-scale-x: 1.2;" + "-fx-scale-y: 1.2;");
      });
      node.setOnMouseExited((MouseEvent t) -> {
        node.setStyle("-fx-scale-x: 1;" + "-fx-scale-y: 1;");
      });
    }
    GP_EditProfilePic.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
      Node node = (Node) e.getTarget();
      if (!node.getId().equals("GP_EditProfilePic")) {
        String imgString = node.getId();
        imgString = imgString.substring(imgString.length() - 1, imgString.length());
        File imageFile = new File("src\\sample\\media\\Org_User\\User" + imgString + ".png");
        Image image = new Image(imageFile.toURI().toString());
        IVew_CurrentEdit.setImage(image);
        ResetTable();
        DropShadow ds = new DropShadow(BlurType.GAUSSIAN, Color.GREEN, 50, 0, 0, 0);
        node.setEffect(ds);
      }

    });

  }

}
