package com.example.restaurant.demo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreateFoodDishesRest {

    @JsonProperty("name")
    private String name;

    @JsonProperty("duration_time")
    private String duration_time;

    @JsonProperty("creation_date")
    private Date creation_date;

    @JsonProperty("id_restaurant")
    private Long restaurants;

    @JsonProperty("ingredients")
    private List<IngredientsRest> ingredients;

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

    public Date getCreation_date() {
        return creation_date;
    }

    public void setCreation_date(Date creation_date) {
        this.creation_date = creation_date;
    }

    public Long getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Long restaurants) {
        this.restaurants = restaurants;
    }

    public List<IngredientsRest> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsRest> ingredients) {
        this.ingredients = ingredients;
    }
}
