package org.example.controller;

import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.ShippingListApp;
import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.service.StageFactory;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;
import org.testfx.api.FxRobot;
import org.junit.jupiter.api.extension.ExtendWith;

import java.util.ArrayList;

@ExtendWith(ApplicationExtension.class)
public class HomeScreenControllerTest {

    @Start
    public void start(Stage stage) throws Exception{
        var pair = StageFactory.getInstance().createMainStage();
        ShippingListApp.getInstance().stage = stage;
        Scene scene = new Scene(pair.getKey(), 1000, 600);
        stage.setTitle("ShoppingList App");
        stage.setScene(scene);
        stage.show();
        stage.toFront();
    }

    @BeforeEach
    public void initialize(FxRobot robot){
        User user = new User("ala", "123");
        Item item = new Item("zegarek", 1, MeasureEnum.szt);
        Item item2 = new Item("obroza", 1, MeasureEnum.szt);
        ArrayList lists = new ArrayList();
        lists.add(item);
        lists.add(item2);
        ShoppingList list = new ShoppingList("2022-10-10", lists, "najnowsze");
        ComboBox comboBox = robot.lookup("#lists").queryAs(ComboBox.class);
        comboBox.getItems().addAll(list);
        ComboBox measureBox = robot.lookup("#measures").queryAs(ComboBox.class);
        measureBox.getItems().addAll(MeasureEnum.values());
    }

    @Test
    public void selectListTest(FxRobot robot){
        ComboBox comboBox = robot.lookup("#lists").queryAs(ComboBox.class);
        robot.clickOn("#lists");
        robot.clickOn("najnowsze");
        Assertions.assertEquals("najnowsze", comboBox.getSelectionModel().getSelectedItem().toString());
    }

    @Test
    public void readDateTest(FxRobot robot) {
        //ComboBox comboBox = robot.lookup("#lists").queryAs(ComboBox.class);
        TextField date = robot.lookup("#listDate").queryAs(TextField.class);
        robot.clickOn("#lists");
        robot.clickOn("najnowsze");

        Assertions.assertEquals("2022-10-10", date.getText());

    }

    @Test
    public void readNameTest(FxRobot robot) {
        //ComboBox comboBox = robot.lookup("#lists").queryAs(ComboBox.class);
        TextField name = robot.lookup("#listName").queryAs(TextField.class);
        robot.clickOn("#lists");
        robot.clickOn("najnowsze");

        Assertions.assertEquals("najnowsze", name.getText());
    }

    @Test
    public void changeNameTest(FxRobot robot) {
        //ComboBox comboBox = robot.lookup("#lists").queryAs(ComboBox.class);
        TextField name = robot.lookup("#listName").queryAs(TextField.class);
        robot.clickOn("#lists");
        robot.clickOn("najnowsze");
        robot.clickOn("#listName");
        name.clear();
        robot.write("nowaLista");

        Assertions.assertEquals("nowaLista", name.getText());
    }

    @Test
    public void changeDateTest(FxRobot robot) {
        //ComboBox comboBox = robot.lookup("#lists").queryAs(ComboBox.class);
        TextField name = robot.lookup("#listDate").queryAs(TextField.class);
        robot.clickOn("#lists");
        robot.clickOn("najnowsze");
        robot.clickOn("#listDate");
        name.clear();
        robot.write("2010-10-01");

        Assertions.assertEquals("2010-10-01", name.getText());
    }

    @Test
    public void selectFirstItemTest(FxRobot robot) {
        //ComboBox comboBox = robot.lookup("#lists").queryAs(ComboBox.class);
        TextField name = robot.lookup("#itemName").queryAs(TextField.class);
        TextField val = robot.lookup("#valueName").queryAs(TextField.class);
        ComboBox measure = robot.lookup("#measures").queryAs(ComboBox.class);
        robot.clickOn("#lists");
        robot.clickOn("najnowsze");
        robot.clickOn("zegarek 1.0 szt");
        robot.clickOn("#itemName");

        Assertions.assertEquals("zegarek", name.getText());
        Assertions.assertNotNull(val.getText());
        Assertions.assertNotNull(measure.getSelectionModel().getSelectedItem());
    }



}
