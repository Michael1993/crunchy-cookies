package com.javax1.cookies.basics;

import com.javax1.cookies.secrets.Recipe;

import java.util.Collection;
import java.util.Map;
import java.util.stream.Stream;

public interface RecipeHintInterface {

    /**
     * HINT: Try using count()!
     */
    long countRecipes(Stream<Recipe> recipes);

    /**
     * HINT: We are only interested in a Recipe if it's 'distinct'.
     */
    long uniqueRecipeCount(Stream<Recipe> recipes);

    /**
     * HINT: Try using collect() and a Collectors @Override
     * public method!
     */
    Collection<Recipe> removeDuplicateRecipes(Stream<Recipe> recipes);

    /**
     * HINT: Try using filter()!
     */
    Collection<Recipe> filterForNotTooSweetRecipes(Stream<Recipe> recipes);

    /**
     * HINT: Try using map() with a method reference!
     */
    Collection<String> getCookieNames(Stream<Recipe> recipes);

    /**
     * HINT: Try combining filter() and map()!
     */
    Collection<String> notTooSweetCookieNames(Stream<Recipe> recipes);

    /**
     * HINT: Create an IntStream (with a special mapping method)
     * from the Stream and then sum it.
     */
    int sugarSumOfRecipes(Stream<Recipe> recipes);

    /**
     * HINT: Use flatMap(), keySet() and collect(toSet())!
     */
    Collection<String> listIngredients(Stream<Recipe> recipes);

    /**
     * HINT: Try using max() and Comparator.comparingInt()!
     */
    Recipe mostDifficultRecipe(Stream<Recipe> recipes);

    /**
     * HINT: Use the toMap() collector!
     */
    Map<String, Integer> collectNameAndSugar(Stream<Recipe> recipes);

    /**
     * HINT: Use map() and a special collector made for String!
     */
    String frankenCookie(Stream<Recipe> recipes);

    /**
     * HINT: Use the noneMatch() or the allMatch() method!
     */
    boolean inspectionSugar(Stream<Recipe> recipes);

    /**
     * HINT: Use the anyMatch() method!
     */
    boolean inspectionIngredient(Stream<Recipe> recipes);

    /**
     * HINT: Use the reduce() operation! This is a relatively hard task, so
     * don't stress out if you can't do it right away. If you are stuck,
     * have a look at the Recipe::merge method.
     */
    Recipe createUltimateRecipe(Stream<Recipe> recipes, Recipe blank);
}
