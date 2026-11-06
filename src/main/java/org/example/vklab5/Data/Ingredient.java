package org.example.vklab5.Data;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "ingredients")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany(mappedBy = "ingredients")
    private List<Drink> drinks;

    public Ingredient() {}

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Drink> getDrinks() { return drinks; }
    public void setDrinks(List<Drink> drinks) { this.drinks = drinks; }
}