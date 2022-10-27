package org.example.domain;

import java.util.ArrayList;
import java.util.Date;

public class ShoppingList {
    private Date date;
    private ArrayList<Item> items;

    public Date getDate() {
        return date;
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }


}
