package sample.FXML.ProfilePanels.VolunteerProfile;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class VolunteerEditController implements Initializable {

    @FXML
    GridPane GP_EditProfilePic;
    @FXML
    ImageView IVew_CurrentEdit;
    @FXML
    ImageView IVew_User1, IVew_User2, IVew_User3, IVew_User4, IVew_User5, IVew_User6, IVew_User7, IVew_User8, IVew_User9;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ProfilePicEvents();
    }
    public void ResetTable(){
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
                node.setStyle("-fx-scale-x: 1.2;"
                        + "-fx-scale-y: 1.2;");
            });
            node.setOnMouseExited((MouseEvent t) -> {
                node.setStyle("-fx-scale-x: 1;"
                        + "-fx-scale-y: 1;");
            });
        }
        GP_EditProfilePic.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> {
            Node node = (Node) e.getTarget();
            if (!node.getId().equals("GP_EditProfilePic")) {
                String imgString = node.getId();
                imgString = imgString.substring(imgString.length() - 1, imgString.length());
                File imageFile = new File("src\\sample\\media\\Vol_User\\Vol" + imgString + ".png");
                Image image = new Image(imageFile.toURI().toString());
                IVew_CurrentEdit.setImage(image);
                ResetTable();
                DropShadow ds = new DropShadow(BlurType.GAUSSIAN, Color.GREEN, 50, 0, 0, 0);
                node.setEffect(ds);
            }

        });

    }

}
