package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.ShippingListApp;
import org.example.domain.User;
import org.example.service.IUserService;
import org.example.service.StageFactory;

public class ShoppingListController {
    @FXML
    public TextField userField;
    @FXML
    public PasswordField passwordField;
    @FXML private Text actionTarget;

    private final IUserService userService;

    public ShoppingListController(IUserService service){
        userService = service;
    }

    @FXML
    protected void handleSubmitButtonAction() {
        User loggedUser = userService.loginUser(userField.getText(), passwordField.getText());

        if(loggedUser == null){
            actionTarget.setText("INCORRECT PASSWORD.");
        }
        else {
            actionTarget.setText("Logging " + loggedUser.getName());
            try {
                ShippingListApp.getInstance().stage.close();

                var pair = StageFactory.getInstance().createMainStage();
                Stage stage = new Stage();
                ShippingListApp.getInstance().stage = stage;
                Scene scene = new Scene(pair.getKey(), 1000, 600);
                stage.setTitle("ShoppingList App");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}