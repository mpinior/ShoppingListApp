package org.example.domain;

import org.junit.Assert;
import org.junit.Test;

public class ItemTest {

    Item generateItem(String name, Float val, MeasureEnum en){

        return new Item(name, val, en);
    }

    @Test
    public void getNameTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);

        //act
        //assert
        Assert.assertEquals(item.getName(), "mleko");
    }

    @Test
    public void getValueTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);

        //act
        //assert
        Assert.assertEquals(item.getValue(), 200.0f, 0.0);
    }

    @Test
    public void getMeasureTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);

        //act
        //assert
        Assert.assertEquals(item.getMeasure(), MeasureEnum.ml);
    }

    @Test
    public void setNameTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        //act
        item.setName("woda");
        //assert
        Assert.assertEquals(item.getName(), "woda");
    }

    @Test
    public void toStringTest(){
        //arrange
        Item item = generateItem("mleko", 200.0f, MeasureEnum.ml);
        //assert
        Assert.assertEquals(item.toString(), "mleko 200.0 ml");
    }
}
