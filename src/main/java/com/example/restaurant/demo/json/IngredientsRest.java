package com.example.restaurant.demo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import java.util.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class IngredientsRest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("creation_date")
    private Date creation_date;


    public void setId(Long id) {
        id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }
}
