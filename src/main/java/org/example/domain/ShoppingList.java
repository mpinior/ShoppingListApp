package org.example.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class ShoppingList extends Entity {
    private String date;
    private ArrayList<Item> items;

    public ShoppingList(){
        items = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        date = formatter.format(new Date());
    }

    @JsonCreator
    public ShoppingList(@JsonProperty("date") String date, @JsonProperty("items") ArrayList<Item> items){
        this.date=date;
        this.items=items;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
