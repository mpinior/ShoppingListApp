package org.example;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import org.example.domain.User;
import org.example.persistance.UserRepository;

public class ShoppingListController {
    @FXML
    public TextField userField;
    @FXML
    public PasswordField passwordField;
    @FXML private Text actiontarget;

    @FXML protected void handleSubmitButtonAction(ActionEvent event) {
        User newUser = new User(userField.getText(), passwordField.getText());
        UserRepository.getInstance().add(newUser);
        actiontarget.setText("Logging " + userField.getText());
        ShippingListApp.getInstance().userLogged();
    }
}