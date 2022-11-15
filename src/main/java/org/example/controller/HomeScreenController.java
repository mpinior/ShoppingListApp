package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.service.IUserService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class HomeScreenController {

    private boolean firstClick = true;
    @FXML
    private ComboBox<ShoppingList> lists;

    @FXML
    private ListView<Item> itemList;
    private ArrayList<Item> chosenList;
    private final IUserService userService;
    private ShoppingList shoppingList;

    @FXML
    private TextField listDate;
    @FXML
    private Button updateListButton;
    @FXML
    private Button newListButton;
    @FXML
    private TextField listName;
    @FXML
    private Button updateButton;
    @FXML
    private Button doneButton;
    @FXML
    private Button addButton;
    @FXML
    private TextField itemName;
    @FXML
    private TextField valueName;
    @FXML
    private ComboBox measures;

    private Item selectedItem = null;

    public HomeScreenController(IUserService service) {
        userService=service;
    }

    public void initialize(){
        if(userService.getCurrentUser() != null){
            lists.getItems().addAll(userService.getCurrentUser().getAllLists());
            measures.getItems().addAll(MeasureEnum.values());
        }
    }

    @FXML
    protected void selectionChanged(){
        try {
            this.chosenList = lists.getSelectionModel().getSelectedItem().getItems();
            updateListView();
            userService.setShoppingList(lists.getSelectionModel().getSelectedItem());
            this.itemList.getItems().clear();
            this.itemList.getItems().addAll(chosenList);
            this.listDate.setText(userService.getShippingList().getDate());
            this.listName.setText(lists.getSelectionModel().getSelectedItem().getName());
        }
        catch(Exception e) {}

    }

    @FXML
    protected void displayClicked(){
        //TODO how to get index of that chosen item?
        this.selectedItem = this.itemList.getSelectionModel().getSelectedItem();
        //userService.setCurrentListInt(lists.getSelectionModel().getSelectedItem().getItems().indexOf(selectedItem));
        itemName.setText(selectedItem.getName());
        valueName.setText(Float.toString(selectedItem.getValue()));
        measures.getSelectionModel().select(selectedItem.getMeasure());
    }

    @FXML
    protected void updateItem(){
        if(userService.getShippingList().getItems().contains(selectedItem)) {
            userService.getShippingList().getItems().remove(selectedItem);
            Item updated = new Item(itemName.getText(), Float.parseFloat(valueName.getText()), MeasureEnum.valueOf(measures.getSelectionModel().getSelectedItem().toString()));
//        this.chosenList.add(updated);
            userService.getShippingList().getItems().add(updated);

            updateListView();
        }
    }

    private void updateListView(){
        //update
        this.itemList.getItems().clear();
        this.itemList.getItems().addAll(chosenList);

        //clear text edition
        itemName.clear();
        valueName.clear();
        measures.getSelectionModel().clearSelection();
    }

    @FXML
    protected void addItem(){
        if(userService.getShippingList() != null) {
            Item newItem = new Item(itemName.getText(), Float.parseFloat(valueName.getText()), MeasureEnum.valueOf(measures.getSelectionModel().getSelectedItem().toString()));
            userService.getShippingList().getItems().add(newItem);
            updateListView();
        }
    }
    @FXML
    protected void removeItem(){
        if(userService.getShippingList().getItems().contains(selectedItem)) {
            userService.getShippingList().getItems().remove(selectedItem);
            updateListView();
        }
    }

    @FXML
    protected void addNewList(){
        //set default
        if (firstClick) {
            this.listName.setText("Nowa Lista");
            LocalDate dateObj = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            this.listDate.setText(dateObj.format(formatter));
            this.itemList.getItems().clear();
            firstClick=false;
        }
        else{
            ArrayList<Item> items = new ArrayList<>(this.itemList.getItems());
            ShoppingList newList = new ShoppingList(this.listDate.getText(), items, this.listName.getText());
            userService.getCurrentUser().setNewList(newList);
            firstClick=true;
            cleanListTextBoxes();
            lists.getItems().clear();
            lists.getItems().addAll(userService.getCurrentUser().getAllLists());
        }

    }
    @FXML
    protected void  updateList(){
        shoppingList = lists.getSelectionModel().getSelectedItem();
        shoppingList.setName(this.listName.getText());
        shoppingList.setDate(this.listDate.getText());

        lists.getItems().clear();
        lists.getItems().addAll(userService.getCurrentUser().getAllLists());
        updateListView();
        cleanListTextBoxes();

    }

    private void cleanListTextBoxes(){
        this.listDate.clear();
        this.listName.clear();
        this.itemList.getItems().clear();
    }

}
