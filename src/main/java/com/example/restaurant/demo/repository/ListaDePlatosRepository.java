package com.example.restaurant.demo.repository;

import com.example.restaurant.demo.entity.ListaDePlatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ListaDePlatosRepository extends JpaRepository<ListaDePlatos, Long> {

    @Query(value = "select fd.\"name\" , fd.duration_time, i.\"name\" as ingrediente\n" +
            "from \n" +
            "\"Food_dishes\" fd \n" +
            "inner join food_dishes_details fd2 on (fd.id =fd2.food_dishes_id)\n" +
            "inner join \"Ingredients\" i on  (i.id=fd2.ingredients_id)", nativeQuery = true)
    List<ListaDePlatos> ListaPlatos();


}
