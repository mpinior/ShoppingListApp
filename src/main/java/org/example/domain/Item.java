package org.example.domain;

public class Item extends Entity {
    private String name;
    private float value;
    private MeasureEnum measure;

    public Item(String name, float value, MeasureEnum measure){
        this.measure=measure;
        this.name=name;
        this.value=value;
    }
}
