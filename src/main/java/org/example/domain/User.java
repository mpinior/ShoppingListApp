package org.example.domain;

import java.util.ArrayList;
import java.util.UUID;

public class User {
    private UUID ID;
    private String name;
    private String passwd;
    private ArrayList<ShoppingList> lists;

    public User(String name, String passwd){
        this.ID= UUID.randomUUID();
        this.name = name;
        this.passwd = passwd;
        this.lists = new ArrayList();
    }

    public void setNewList(ShoppingList list){
        this.lists.add(list);
    }

    public ArrayList getAllLists(){
        return this.lists;
    }

    public ShoppingList getListByPosition(int position){
        return this.lists.get(position);
    }

    public void removeList(int position){
        this.lists.remove(position);
    }

}
