package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class UserTest {
    User generateUser(String name, String passwd){
        return new User(name, passwd);
    }

    @Test
    public void setNewListTest(){
        //arrange
        User user = generateUser("ala", "456");
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("1", 1, MeasureEnum.szt));
        ShoppingList sp = new ShoppingList("2022-10-10", items, "lista1");

        //act
        user.setNewList(sp);
        //assert

        Assertions.assertEquals(user.getAllLists().get(0), sp);
    }

    @Test
    public void getAllListsTest(){
        //arrange
        User user = generateUser("ala", "456");
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("1", 1, MeasureEnum.szt));
        ShoppingList sp = new ShoppingList("2022-10-10", items, "lista1");
        ArrayList<ShoppingList> spList = new ArrayList<>();
        spList.add(sp);

        //act
        user.setNewList(sp);
        //assert

        Assertions.assertEquals(user.getAllLists(), spList);
    }

    @Test
    public void getPasswdTest(){
        //arrange
        User user = generateUser("ala", "456");

        //act

        //assert
        Assertions.assertEquals(user.getPasswd(), "456");
    }
}
