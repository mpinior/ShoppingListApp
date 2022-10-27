package org.example.domain;

public class Item {
    private String name;
    private float value;
    private MeasureEnum measure;

    public Item(String name, float value, MeasureEnum measure){
        this.measure=measure;
        this.name=name;
        this.value=value;
    }
}
