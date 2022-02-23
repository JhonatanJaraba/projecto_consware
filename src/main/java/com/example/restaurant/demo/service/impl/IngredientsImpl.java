package com.example.restaurant.demo.service.impl;

import com.example.restaurant.demo.entity.Ingredients;
import com.example.restaurant.demo.entity.ListaDePlatos;
import com.example.restaurant.demo.entity.Restaurant;
import com.example.restaurant.demo.exceptions.BookingException;
import com.example.restaurant.demo.exceptions.InternalServerErrorException;
import com.example.restaurant.demo.json.*;
import com.example.restaurant.demo.repository.IngredientsRepository;
import com.example.restaurant.demo.repository.ListaDePlatosRepository;
import com.example.restaurant.demo.service.IngredientsService;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class IngredientsImpl implements IngredientsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(FoodDishesServiceImpl.class);

    @Autowired
    IngredientsRepository ingredientsRepository;

    @Autowired
    ListaDePlatosRepository listaDePlatosRepository;

    public static final ModelMapper modelMapper = new ModelMapper();

    @Override
    public String createingrediente(IngredientsRest ingredientsRest) throws BookingException {


        Ingredients ingredients = new Ingredients();

        ingredients.setName(ingredientsRest.getName());

        try {
            ingredientsRepository.save(ingredients);
        }catch (final Exception e){
            LOGGER.error("INTERNAL_SERVER_ERROR", e);
            throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
        }


        return "Ingrediente creado";
    }

    @Override
    public List<ListaIngredienteRest> getIngredientes() throws BookingException {
        final List<Ingredients> restaurantsEntity = ingredientsRepository.findAll();
        return restaurantsEntity.stream().map(service -> modelMapper.map(service, ListaIngredienteRest.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<ListaPlatosRest> getListaPlatos() throws BookingException {
        final List<ListaDePlatos> ListaPlatos = listaDePlatosRepository.ListaPlatos();
        System.out.println(ListaPlatos);
        return ListaPlatos.stream().map(service -> modelMapper.map(service, ListaPlatosRest.class))
                .collect(Collectors.toList());
    }


}
