package org.example.domain;

import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.persistance.IPersistanceHelper;
import org.example.persistance.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

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

        Assert.assertEquals(user.getAllLists().get(0), sp);
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

        Assert.assertEquals(user.getAllLists(), spList);
    }

    @Test
    public void getPasswdTest(){
        //arrange
        User user = generateUser("ala", "456");

        //act

        //assert
        Assert.assertEquals(user.getPasswd(), "456");
    }
}
