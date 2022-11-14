package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Pair;
import org.example.domain.Item;
import org.example.domain.ShoppingList;
import org.example.service.IUserService;
import org.example.service.StageFactory;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class HomeScreenController {

    @FXML
    private ComboBox<ShoppingList> lists;

    @FXML
    private ListView<ArrayList> itemList;
    private ArrayList<Item> chosenList;
    private IUserService userService;

    public HomeScreenController(IUserService service) {
        userService=service;
    }

    public void initialize(){
        if(userService.getCurrentUser() != null){
            lists.getItems().addAll(userService.getCurrentUser().getAllLists());
        }
    }

    @FXML
    protected void selectionChanged(){
        this.chosenList = lists.getSelectionModel().getSelectedItem().getItems();
        this.itemList.getItems().clear();
        //var itemsPairs = chosenList.stream().map(e -> StageFactory.getInstance().createItemList()).collect(Collectors.toList());
        //this.itemList.getItems().addAll(itemsPairs.stream().map(Pair::getKey).collect(Collectors.toList()));
        this.itemList.getItems().addAll(chosenList);
    }

}
