package org.example.service;

import org.example.domain.Item;
import org.example.domain.MeasureEnum;
import org.example.domain.ShoppingList;
import org.example.domain.User;
import org.example.persistance.IPersistanceHelper;
import org.example.persistance.IUserRepository;
import org.example.persistance.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class UserServiceTest {

    User generateUser(String name, String passwd){
        return new User(name, passwd);
    }
    @Test
    public void loginUser() {
        User user = generateUser("ala", "456");

        IUserRepository repository = Mockito.mock(IUserRepository.class);
        when(repository.find("ala")).thenReturn(user);
        IUserService userService = new UserService(repository);

        Assert.assertEquals(userService.loginUser("ala", "456").getName(), user.getName());

    }

    @Test
    public void getCurrentUser() {
        User user = generateUser("ala", "456");

        IUserRepository repository = Mockito.mock(IUserRepository.class);
        when(repository.find("ala")).thenReturn(user);
        IUserService userService = new UserService(repository);

        userService.loginUser("ala", "456");

        Assert.assertEquals(userService.getCurrentUser(), user);
    }

    @Test
    public void getShippingList() {
        User user = generateUser("ala", "456");
        Item item = new Item("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = new ShoppingList("2022-01-01", items, "lista1");

        IUserRepository repository = Mockito.mock(IUserRepository.class);
        when(repository.find("ala")).thenReturn(user);
        IUserService userService = new UserService(repository);

        userService.loginUser("ala", "456");
        userService.getCurrentUser().setNewList(list);

        userService.setShoppingList(list);

        Assert.assertEquals(userService.getShippingList(), list);
    }

    @Test
    public void setShoppingList() {
        User user = generateUser("ala", "456");
        Item item = new Item("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = new ShoppingList("2022-01-01", items, "lista1");

        IUserRepository repository = Mockito.mock(IUserRepository.class);
        when(repository.find("ala")).thenReturn(user);
        IUserService userService = new UserService(repository);

        userService.loginUser("ala", "456");
        userService.getCurrentUser().setNewList(list);

        userService.setShoppingList(list);

        Assert.assertEquals(userService.getShippingList(), list);
    }
}