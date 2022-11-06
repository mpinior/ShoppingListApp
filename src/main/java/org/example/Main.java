package org.example;

import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.persistance.UserRepository;

public class Main {
    public static void main(String[] args) {
//        User user = new User("ala", "123");
//        ShoppingList shoppingList = new ShoppingList();
//        user.getAllLists().add(shoppingList);
//        shoppingList.getItems().add(new Item("zegarek", 1, MeasureEnum.szt));
//        shoppingList.getItems().add(new Item("obroza", 1, MeasureEnum.szt));
//        UserRepository.getInstance().add(user);
//
//        UserRepository.getInstance().saveAll();
        var users = UserRepository.getInstance().getAll();
        System.out.println("done");
    }
}