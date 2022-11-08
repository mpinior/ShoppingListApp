package org.example.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Item extends Entity {
    private String name;
    private float value;
    private MeasureEnum measure;

    @JsonCreator
    public Item(@JsonProperty("name") String name,@JsonProperty("value") float value, @JsonProperty("measure") MeasureEnum measure){
        this.measure=measure;
        this.name=name;
        this.value=value;
    }
}
