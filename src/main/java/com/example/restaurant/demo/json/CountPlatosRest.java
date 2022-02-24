package com.example.restaurant.demo.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CountPlatosRest {

    @JsonProperty("id_platos")
    private Long id_platos;

    @JsonProperty("num_ingredientes")
    private Long num_ingredientes;

    public Long getId_platos() {
        return id_platos;
    }

    public void setId_platos(Long id_platos) {
        this.id_platos = id_platos;
    }

    public Long getNum_ingredientes() {
        return num_ingredientes;
    }

    public void setNum_ingredientes(Long num_ingredientes) {
        this.num_ingredientes = num_ingredientes;
    }
}
