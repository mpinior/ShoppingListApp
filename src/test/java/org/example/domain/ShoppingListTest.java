package org.example.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class ShoppingListTest {

    Item generateItem(String name, Float val, MeasureEnum en){

        return new Item(name, val, en);
    }
    ShoppingList generateShoppingList(String date, ArrayList<Item> items, String name){

        return new ShoppingList(date, items, name);
    }

    @Test
    public void getDateTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = generateShoppingList("2022-02-02", items, "lista1");

        //act
        //assert
        Assertions.assertEquals(list.getDate(), "2022-02-02");
    }

    @Test
    public void getItemsTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = generateShoppingList("2022-02-02", items, "lista1");

        //act
        //assert
        Assertions.assertEquals(list.getItems(), items);
    }

    @Test
    public void setDateTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = generateShoppingList("2022-02-02", items, "lista1");

        //act
        list.setDate("2022-01-01");
        //assert
        Assertions.assertEquals(list.getDate(), "2022-01-01");
    }

    @Test
    public void getNameTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = generateShoppingList("2022-02-02", items, "lista1");

        //act
        //assert
        Assertions.assertEquals(list.getName(), "lista1");
    }

    @Test
    public void setNameTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = generateShoppingList("2022-02-02", items, "lista1");

        //act
        list.setName("lista2");
        //assert
        Assertions.assertEquals(list.getName(), "lista2");
    }

    @Test
    public void toStringTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        ArrayList<Item> items = new ArrayList<>();
        items.add(item);
        ShoppingList list = generateShoppingList("2022-02-02", items, "lista1");

        //act
        //assert
        Assertions.assertEquals(list.toString(), "lista1");
    }


}
