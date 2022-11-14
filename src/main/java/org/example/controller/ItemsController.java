package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.service.IUserService;

import java.util.ArrayList;

public class ItemsController {

    @FXML
    private CheckBox updateCheckbox;
    @FXML
    private CheckBox doneCheckbox;
    @FXML
    private TextField itemName;
    @FXML
    private TextField valueName;
    @FXML
    private ComboBox measures;
    private IUserService userService;

    private ArrayList<Item> list;

    public ItemsController(IUserService service) {
        userService=service;
    }

    @FXML
    private void measureSelectionChanged(){

    }

    public void initialize(){
        if(userService.getCurrentUser() != null){
            list = userService.getCurrentList();

            //this.measures.getSelectionModel().select();
        }
        measures.getItems().addAll(MeasureEnum.values());

    }


}
