package org.example.domain;

public class Item {
    private String name;
    private String value;
    private MeasureEnum measure;

    public Item(String name, String value, MeasureEnum measure){
        this.measure=measure;
        this.name=name;
        this.value=value;
    }
}
