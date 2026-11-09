package vklab5.service;

import vklab5.converters.DrinkConverter;
import vklab5.Data.Category;
import vklab5.Data.Drink;
import vklab5.Data.Ingredient;
import vklab5.dto.DrinkDto;
import vklab5.repository.CategoryRepository;
import vklab5.repository.DrinkRepository;
import vklab5.repository.IngredientRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DrinkService {
    private final DrinkRepository drinkRepository;
    private final CategoryRepository categoryRepository;
    private final IngredientRepository ingredientRepository;
    private final DrinkConverter converter;

    public DrinkService(DrinkRepository drinkRepository,
                        CategoryRepository categoryRepository,
                        IngredientRepository ingredientRepository,
                        DrinkConverter converter) {
        this.drinkRepository = drinkRepository;
        this.categoryRepository = categoryRepository;
        this.ingredientRepository = ingredientRepository;
        this.converter = converter;
    }

    public List<DrinkDto> getAllDrinks() {
        return drinkRepository.findAll().stream()
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    public DrinkDto getDrinkById(Long id) {
        Drink drink = drinkRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid drink Id:" + id));
        return converter.toDto(drink);
    }

    public void saveDrink(DrinkDto drinkDto) {
        // Знаходимо категорію за ID
        Category category = null;
        if (drinkDto.getCategoryId() != null) {
            category = categoryRepository.findById(drinkDto.getCategoryId()).orElse(null);
        }

        // Знаходимо інгредієнти за списком ID
        List<Ingredient> ingredients = new ArrayList<>();
        if (drinkDto.getIngredientIds() != null && !drinkDto.getIngredientIds().isEmpty()) {
            ingredients = ingredientRepository.findAllById(drinkDto.getIngredientIds());
        }

        // Конвертуємо в сутність і зберігаємо
        Drink drink = converter.toEntity(drinkDto, category, ingredients);
        drinkRepository.save(drink);
    }

    public void deleteDrink(Long id) {
        drinkRepository.deleteById(id);
    }

    // Методи для заповнення випадаючих списків у HTML-формі
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public List<Ingredient> getAllIngredients() {
        return ingredientRepository.findAll();
    }
}