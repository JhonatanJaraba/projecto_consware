package com.example.restaurant.demo.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`Ingredients`")
public class ListaDePlatos {

    @Id
    private String ingrediente;

    private String name;

    private String duration_time;



}
