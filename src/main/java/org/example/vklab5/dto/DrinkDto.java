package org.example.vklab5.dto;

import java.util.List;

public class DrinkDto {
    private Long id;
    private String name;
    private Double volume;
    private Double price;

    private Long categoryId;
    private String categoryName;

    private List<Long> ingredientIds;
    private List<String> ingredientNames;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Double getVolume() { return volume; }
    public void setVolume(Double volume) { this.volume = volume; }

    public Double getPrice() { return price; }
    public void setPrice(Double price) { this.price = price; }

    public Long getCategoryId() { return categoryId; }
    public void setCategoryId(Long categoryId) { this.categoryId = categoryId; }

    public String getCategoryName() { return categoryName; }
    public void setCategoryName(String categoryName) { this.categoryName = categoryName; }

    public List<Long> getIngredientIds() { return ingredientIds; }
    public void setIngredientIds(List<Long> ingredientIds) { this.ingredientIds = ingredientIds; }

    public List<String> getIngredientNames() { return ingredientNames; }
    public void setIngredientNames(List<String> ingredientNames) { this.ingredientNames = ingredientNames; }
}