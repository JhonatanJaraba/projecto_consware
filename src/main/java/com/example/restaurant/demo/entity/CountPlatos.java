package com.example.restaurant.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "`Food_dishes`")
public class CountPlatos {

    @Id
    private Long id_platos;

    private Long num_ingredientes;
}
