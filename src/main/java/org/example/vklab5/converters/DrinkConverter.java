package org.example.vklab5.converters;

import org.example.vklab5.Data.Category;
import org.example.vklab5.Data.Drink;
import org.example.vklab5.Data.Ingredient;
import org.example.vklab5.dto.DrinkDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DrinkConverter {

    public DrinkDto toDto(Drink drink) {
        DrinkDto dto = new DrinkDto();
        dto.setId(drink.getId());
        dto.setName(drink.getName());
        dto.setVolume(drink.getVolume());
        dto.setPrice(drink.getPrice());

        if (drink.getCategory() != null) {
            dto.setCategoryId(drink.getCategory().getId());
            dto.setCategoryName(drink.getCategory().getName());
        }

        if (drink.getIngredients() != null) {
            dto.setIngredientIds(drink.getIngredients().stream().map(Ingredient::getId).collect(Collectors.toList()));
            dto.setIngredientNames(drink.getIngredients().stream().map(Ingredient::getName).collect(Collectors.toList()));
        }
        return dto;
    }

    public Drink toEntity(DrinkDto dto, Category category, List<Ingredient> ingredients) {
        Drink drink = new Drink();
        drink.setId(dto.getId());
        drink.setName(dto.getName());
        drink.setVolume(dto.getVolume());
        drink.setPrice(dto.getPrice());
        drink.setCategory(category);
        drink.setIngredients(ingredients);
        return drink;
    }
}