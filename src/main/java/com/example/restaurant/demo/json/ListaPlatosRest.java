package com.example.restaurant.demo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ListaPlatosRest {

    @JsonProperty("plato")
    private String name;

    @JsonProperty("duration_time")
    private String duration_time;

    @JsonProperty("ingrediente")
    private String ingrediente;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDuration_time() {
        return duration_time;
    }

    public void setDuration_time(String duration_time) {
        this.duration_time = duration_time;
    }

    public String getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(String ingrediente) {
        this.ingrediente = ingrediente;
    }
}
