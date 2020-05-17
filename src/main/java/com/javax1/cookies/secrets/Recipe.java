package com.javax1.cookies.secrets;

import java.util.Map;
import java.util.Objects;

/**
 * Models the super-duper secret recipes used by the Crunchy Cookie Company.
 */
public class Recipe {
    private final String name;
    private final Map<String, Integer> ingredients;
    private final int sugar;
    private final int difficulty;

    public Recipe(String name, Map<String, Integer> ingredients, int sugar, int difficulty) {
        this.name = name;
        this.ingredients = ingredients;
        this.sugar = sugar;
        this.difficulty = difficulty;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(ingredients, recipe.ingredients);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ingredients);
    }

    public Map<String, Integer> ingredients() {
        return ingredients;
    }

    public int sugar() {
        return sugar;
    }

    public String name() {
        return name;
    }

    public int difficulty() {
        return difficulty;
    }

    public Recipe merge(Recipe recipe) {
        recipe.ingredients().forEach(
                (ingredient, amount) -> {
                    ingredients.computeIfPresent(ingredient, (__, value) -> Math.max(amount, value));
                    // OR
                    ingredients.putIfAbsent(ingredient, amount);
                }
        );
        return this;
    }

}
