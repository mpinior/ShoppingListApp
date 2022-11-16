package org.example.service;

import org.example.ShippingListApp;
import org.example.domain.Item;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.persistance.IUserRepository;
import org.example.persistance.UserRepository;

import java.util.ArrayList;

public class UserService implements IUserService{
    private IUserRepository userRepository;
    private User currentUser = null;

    private ArrayList<Item> currentList = null;
    private ShoppingList list = null;

    public UserService(IUserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User loginUser(String name, String passwd){
        User loggedUser;

        if (userRepository.find(name) == null){
            loggedUser = new User(name, passwd);
            userRepository.add(loggedUser);
        }
        else{
            loggedUser = userRepository.find(name);
            if(!loggedUser.getPasswd().equals(passwd)){
                return null;
            }
        }
        currentUser=loggedUser;
        return loggedUser;
    }

    public User getCurrentUser(){
        return currentUser;
    }

    public ArrayList<Item> getCurrentList(){
        return currentList;
    }

    public ShoppingList getShippingList(){
        return list;
    }

    public void setShoppingList(ShoppingList list){
        this.list = list;
    }

}
