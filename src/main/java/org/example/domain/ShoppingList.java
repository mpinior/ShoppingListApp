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

    private String name;

    public ShoppingList(){
        items = new ArrayList<>();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        date = formatter.format(new Date());
    }

    @JsonCreator
    public ShoppingList(@JsonProperty("date") String date, @JsonProperty("items") ArrayList<Item> items, @JsonProperty String name){
        this.date=date;
        this.items=items;
        this.name=name;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
