package org.example.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.ShippingListApp;
import org.example.domain.User;
import org.example.persistance.UserRepository;
import org.example.service.IMediator;
import org.example.service.IUserService;
import org.example.service.StageFactory;
import org.example.service.UserService;

import java.net.URL;
import java.util.ResourceBundle;

public class ShoppingListController {
    @FXML
    public TextField userField;
    @FXML
    public PasswordField passwordField;
    @FXML private Text actiontarget;

    private IUserService userService;

    public ShoppingListController(IUserService service){
        userService = service;
    }

    @FXML
    protected void handleSubmitButtonAction(ActionEvent event) {
        User loggedUser = userService.loginUser(userField.getText(), passwordField.getText());

        actiontarget.setText("Logging " + loggedUser.getName());
        try {
            ShippingListApp.getInstance().stage.close();

            var pair = StageFactory.getInstance().createMainStage();
            Stage stage = new Stage();
            ShippingListApp.getInstance().stage = stage;
            Scene scene = new Scene(pair.getKey(), 1000, 600);
            stage.setTitle("ShoppingList App");
            stage.setScene(scene);
            stage.show();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}