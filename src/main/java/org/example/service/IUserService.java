package org.example.service;

import org.example.domain.Item;
import org.example.domain.ShoppingList;
import org.example.domain.User;

import java.util.ArrayList;

public interface IUserService {

    User loginUser(String name, String passwd);
    User getCurrentUser();
    ArrayList<Item> getCurrentList();

    ShoppingList getShippingList();
    void setShoppingList(ShoppingList list);

}

