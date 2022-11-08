package org.example.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.UUID;

public class User extends AggregateRoot {
    private UUID ID;

    public String getName() {
        return name;
    }

    private String name;
    private String passwd;
    private ArrayList<ShoppingList> lists;

    public User(String name, String passwd){
        this.ID= UUID.randomUUID();
        this.name = name;
        this.passwd = passwd;
        this.lists = new ArrayList();
    }

    //added for deserialization ?
    @JsonCreator
    public User(@JsonProperty("ID") UUID id,@JsonProperty("name") String name,@JsonProperty("passwd") String passwd,@JsonProperty("lists") ArrayList<ShoppingList> list){
        this.ID= id;
        this.name = name;
        this.passwd = passwd;
        this.lists = list;
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
