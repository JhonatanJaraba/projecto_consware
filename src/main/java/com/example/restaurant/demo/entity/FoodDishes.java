package com.example.restaurant.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`Food_dishes`")
public class FoodDishes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", unique = true, nullable = false)
    private Long Id;

    @Column(unique = true)
    private String name;

    private String duration_time;

    private Date creation_date;

    @ManyToOne
    @JoinColumn(name = "RESTAURANT_ID", nullable = false)
    private Restaurant restaurants;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Food_dishes_details", joinColumns = @JoinColumn(name = "food_dishes_id"),
            inverseJoinColumns = @JoinColumn(name = "ingredients_id"))
    private Set<Ingredients> ingredients = new HashSet<>();
}
