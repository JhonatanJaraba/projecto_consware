package com.example.restaurant.demo.json;

import com.example.restaurant.demo.entity.FoodDishes;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestaurantFoodDishesRest {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("address")
    private String address;

    @JsonProperty("description")
    private String description;

    @JsonProperty("image")
    private String image;

    @JsonProperty("fooddishes")
    private List<RestFoodDishesRest> Fooddishes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public List<RestFoodDishesRest> getFooddishes() {
        return Fooddishes;
    }

    public void setFooddishes(List<RestFoodDishesRest> fooddishes) {
        Fooddishes = fooddishes;
    }
}
