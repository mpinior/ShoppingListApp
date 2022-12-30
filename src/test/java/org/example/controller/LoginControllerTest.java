package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.example.ShippingListApp;
import org.example.service.StageFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxRobot;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(ApplicationExtension.class)
public class LoginControllerTest {

    @Start
    public void start(Stage stage) throws Exception{
        var pair = StageFactory.getInstance().createLoginStage();
        Scene scene = new Scene(pair.getKey(), 320, 240);
        stage.setTitle("ShoppingList App");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
        ShippingListApp.getInstance().stage=stage;
    }

    @Test
    public void insertDataTest(FxRobot robot){
        Button signInButton = robot.lookup("#signInButton").queryAs(Button.class);
        TextField name = robot.lookup("#userField").queryAs(TextField.class);
        TextField passwd = robot.lookup("#passwordField").queryAs(TextField.class);
        robot.clickOn("#userField");
        robot.write("ala");
        robot.clickOn("#passwordField");
        robot.write("123");

        Assertions.assertEquals("123", passwd.getText());
        Assertions.assertEquals("ala", name.getText());
    }

    @Test
    public void buttonClickedTest(FxRobot robot) {
        Button signInButton = robot.lookup("#signInButton").queryAs(Button.class);
        TextField name = robot.lookup("#userField").queryAs(TextField.class);
        TextField passwd = robot.lookup("#passwordField").queryAs(TextField.class);
        robot.clickOn("#userField");
        robot.write("ala");
        robot.clickOn("#passwordField");
        robot.write("123");

        signInButton.fire();

        Text actionTarget = robot.lookup("#actionTarget").queryAs(Text.class);
        Assertions.assertEquals("Logging ala", actionTarget.getText());
    }

    @Test
    public void buttonClickedFailedTest(FxRobot robot) {
        Button signInButton = robot.lookup("#signInButton").queryAs(Button.class);
        TextField name = robot.lookup("#userField").queryAs(TextField.class);
        TextField passwd = robot.lookup("#passwordField").queryAs(TextField.class);
        robot.clickOn("#userField");
        robot.write("ala");


        signInButton.fire();

        Text actionTarget = robot.lookup("#actionTarget").queryAs(Text.class);
        Assertions.assertEquals("INCORRECT PASSWORD.", actionTarget.getText());
    }

}
