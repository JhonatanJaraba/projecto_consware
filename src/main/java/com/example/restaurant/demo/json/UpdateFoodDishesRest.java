package com.example.restaurant.demo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateFoodDishesRest {

    @JsonProperty("id")
    private Long Id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("duration_time")
    private String duration_time;

    @JsonProperty("creation_date")
    private Date creation_date;

    @JsonProperty("id_restaurant")
    private Long restaurants;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

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

}
