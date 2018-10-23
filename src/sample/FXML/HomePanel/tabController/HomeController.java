package sample.FXML.HomePanel.tabController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import java.io.IOException;


public class HomeController {

    /* ID/Variable Declarations */
    @FXML public ComboBox cmbox_Tag;
    @FXML public Button btn_OpenLogin;
    @FXML public Button btn_SignUp;
    @FXML public Button btn_demo;
    public boolean loginStatus = false;

    @FXML
    public void OpenLoginBTNClicked() throws IOException {
        System.out.println("[Event](OPEN-Login Clicked)");
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/sample/FXML/LoginPanel/login.fxml"));
            Parent LoginRoot = (Parent) fxmlLoader.load();
            Stage loginStage = new Stage();
            loginStage.setTitle("Login");
            loginStage.setScene(new Scene(LoginRoot));
            loginStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML //Change homePanel.fxml -> signUp.fxml /sample/FXML/SignUpPanel/signUp.fxml
    public void signUpBTNClicked() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                    getClass().getResource("/sample/FXML/SignUpPanel/signUp.fxml"));
            Parent SignUpRoot = (Parent) fxmlLoader.load();
            Stage signUpStage = new Stage();
            signUpStage.setTitle("SignUp");
            signUpStage.setScene(new Scene(SignUpRoot));
            signUpStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void demoUpBTNClicked() throws IOException {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(
                getClass().getResource("/sample/FXML/ProfilePanels/CharityProfile/CharityProfile.fxml"));
            Parent profile = (Parent) fxmlLoader.load();
            Stage signUpStage = new Stage();
            signUpStage.setTitle("Profile");
            signUpStage.setScene(new Scene(profile));
            signUpStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void setUpComboBox() {
        cmbox_Tag.getItems().addAll("Environment","Animals","Human Services","International");
        cmbox_Tag.setPromptText("Select a category.");
    }

//    @FXML
//    public void setLoginStatus(boolean loginStatus){
//        System.out.println("Change status" + loginStatus);
//        this.loginStatus = loginStatus;
//        checkLoginStatus();
//    }
//    @FXML
//    public void checkLoginStatus() {
////        FXMLLoader fxmlLoader = new FXMLLoader(
////            getClass().getResource("/sample/FXML/tab1Controller.fxml"));
//        System.out.println("1");
//        if (loginStatus) {
//            System.out.println("2");
//            btn_OpenLogin.setDisable(true);
//            btn_SignUp.setDisable(true);
//        }else
//            System.out.println("3");
//        btn_OpenLogin.setDisable(false);
//        btn_SignUp.setDisable(false);
//    }


}
