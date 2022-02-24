package com.example.restaurant.demo.repository;

import com.example.restaurant.demo.entity.CountPlatos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountPlatosRepository extends JpaRepository<CountPlatos, Long> {

    @Query(value = "select count(fd2.food_dishes_id) as num_ingredientes, fd2.food_dishes_id as id_platos\n" +
            "from \n" +
            "\"Food_dishes\" fd \n" +
            "inner join food_dishes_details fd2 on (fd.id =fd2.food_dishes_id)\n" +
            "inner join \"Ingredients\" i on  (i.id  =fd2.ingredients_id)\n" +
            "group by fd2.food_dishes_id", nativeQuery = true)
    List<CountPlatos> getCountPlatos();

}
