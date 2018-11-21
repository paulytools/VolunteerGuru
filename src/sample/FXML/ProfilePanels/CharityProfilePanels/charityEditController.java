package sample.FXML.ProfilePanels.CharityProfilePanels;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.SnapshotParameters;
import javafx.scene.effect.BlurType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ResourceBundle;


public class charityEditController implements Initializable  {

    @FXML
    GridPane GP_EditProfilePic;
    @FXML
    ImageView IVew_CurrentEdit;
    @FXML
    ImageView IVew_User1;
    @FXML
    ImageView IVew_User2;
    @FXML
    ImageView IVew_User3;
    @FXML
    ImageView IVew_User4;
    @FXML
    ImageView IVew_User5;
    @FXML
    ImageView IVew_User6;
    @FXML
    ImageView IVew_User7;
    @FXML
    ImageView IVew_User8;
    @FXML
    ImageView IVew_User9;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        ProfilePicEvents();
}

public void ProfilePicEvents(){
    for (Node node : GP_EditProfilePic.getChildren()) {
        node.setOnMouseEntered((MouseEvent t) -> {
            node.setStyle("-fx-scale-x: 1.2;"
                +      "-fx-scale-y: 1.2;");
        });
        node.setOnMouseExited((MouseEvent t) -> {
            node.setStyle("-fx-scale-x: 1;"
                +      "-fx-scale-y: 1;");
        });
    }
    GP_EditProfilePic.addEventHandler(MouseEvent.MOUSE_CLICKED, e ->{
        Node node= (Node) e.getTarget();
        if (node.getId() != "GP_EditProfilePic") {
            WritableImage snapshot = node.snapshot(new SnapshotParameters(), null);
            IVew_CurrentEdit.setImage(snapshot);
            DropShadow ds = new DropShadow(BlurType.GAUSSIAN, Color.GREEN, 50, 0, 0, 0);
            node.setEffect(ds);
        }

    });

}

}
