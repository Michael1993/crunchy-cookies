package com.javax1.cookies.basics;

import com.javax1.cookies.secrets.Recipe;
import com.javax1.cookies.secrets.stores.RecipeStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Run this to validate your CookieCollector implementation.
 */
public class RecipeCollectorTests {

    @Test
    @DisplayName("Should get the proper element count when calling 'countRecipes'")
    void counting() {
        // GIVEN
        var recipes = RecipeStore.collectedRecipes();

        // WHEN
        var count = RecipeCollector.countRecipes(recipes);

        // THEN
        assertThat(count).isEqualTo(7);
    }

    @Test
    @DisplayName("Should return the element count of distinct elements when calling 'uniqueRecipeCount'")
    void uniqueCounting() {
        // GIVEN
        var recipes = RecipeStore.collectedRecipes();

        // WHEN
        var distinct = RecipeCollector.uniqueRecipeCount(recipes);

        // THEN
        assertThat(distinct).isEqualTo(4);
    }

    @Test
    @DisplayName("No duplicate recipes should be in the final recipe list when calling 'removeDuplicateRecipes'.")
    void noDuplicateRecipes() {
        // GIVEN
        var recipes = RecipeStore.collectedRecipes();

        // WHEN
        var collected = RecipeCollector.removeDuplicateRecipes(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrderElementsOf(RecipeStore.notDuplicateRecipes().collect(toList()));
    }

    @Test
    @DisplayName("Only recipes with less than 300g sugar should remain when calling 'filterForNotTooSweetRecipes'.")
    void notTooSweet() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var collected = RecipeCollector.filterForNotTooSweetRecipes(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrderElementsOf(RecipeStore.notTooSweetRecipes().collect(toList()));
    }

    @Test
    @DisplayName("The correct names should be returned when calling 'getCookieNames'")
    void names() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var collected = RecipeCollector.getCookieNames(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrder("Power Puff Muffin", "Classical Cookie", "Mayan Molasses", "Mouthwatering Macaroons");
    }

    @Test
    @DisplayName("The correct names should be returned (not too sweet cookies) when calling 'notTooSweetCookieNames'")
    void notSweetNames() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var collected = RecipeCollector.notTooSweetCookieNames(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrder("Power Puff Muffin", "Mayan Molasses");
    }

    @Test
    @DisplayName("Should calculate the sum of sugar for all recipes when calling 'sugarSumOfRecipes'")
    void sugarSum() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var sum = RecipeCollector.sugarSumOfRecipes(recipes);

        // THEN
        assertThat(sum).isEqualTo(1200);
    }

    @Test
    @DisplayName("Should calculate proper ingredients list")
    void listIngredients() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var ingredients = RecipeCollector.listIngredients(recipes);

        // THEN
        assertThat(ingredients).containsExactlyInAnyOrder("sugar", "flour", "milk", "eggs", "spice", "everything nice", "an impending sense of doom");
    }
    
    @Test
    void mostDifficult() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();
        
        // WHEN
        var most = RecipeCollector.mostDifficultRecipe(recipes);
        
        // THEN
        assertThat(most).isEqualTo(RecipeStore.RECIPE_3);
    }

    @Test
    void nameAndSugarInMap() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var ingredientsWithAmounts = RecipeCollector.collectNameAndSugar(recipes);

        // THEN
        assertThat(ingredientsWithAmounts).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        "Power Puff Muffin", 200,
                        "Classical Cookie", 300,
                        "Mayan Molasses", 200,
                        "Mouthwatering Macaroons", 500
                )
        );
    }

    @Test
    void frankenCookie() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var combinedName = RecipeCollector.frankenCookie(recipes);

        // THEN
        assertThat(combinedName).isEqualTo("Power Puff MuffinClassical CookieMayan MolassesMouthwatering Macaroons");
    }

    @Test
    @DisplayName("We should not have any cookies with more than 1000g sugar")
    void inspection1() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var result = RecipeCollector.inspectionSugar(recipes);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("We should have at least one recipe with 'an impending sense of doom'")
    void inspection2() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var result = RecipeCollector.inspectionIngredient(recipes);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    void ultimateRecipe() {
        // GIVEN
        Recipe blank = new Recipe("Ultimate Recipe", new HashMap<>(), 0, 0);
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var ultimate = RecipeCollector.createUltimateRecipe(recipes, blank);

        // THEN
        assertThat(ultimate.ingredients()).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        "eggs", 3,
                        "flour", 400,
                        "milk", 200,
                        "sugar", 500,
                        "spice", 100,
                        "everything nice", 1400,
                        "an impending sense of doom", 1
                )
        );
    }
}
