package com.javax1.cookies.basics;

import com.javax1.cookies.secrets.Recipe;
import com.javax1.cookies.secrets.stores.RecipeStore;
import org.junit.jupiter.api.BeforeEach;
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
    private RecipeCollector collector;

    @BeforeEach
    void setUp() {
        collector = new RecipeCollector();
    }

    @Test
    @DisplayName("countRecipes: Should get the proper element count")
    void counting() {
        // GIVEN
        var recipes = RecipeStore.collectedRecipes();

        // WHEN
        var count = collector.countRecipes(recipes);

        // THEN
        assertThat(count).isEqualTo(7);
    }

    @Test
    @DisplayName("uniqueRecipeCount: Should return the element count of distinct elements")
    void uniqueCounting() {
        // GIVEN
        var recipes = RecipeStore.collectedRecipes();

        // WHEN
        var distinct = collector.uniqueRecipeCount(recipes);

        // THEN
        assertThat(distinct).isEqualTo(4);
    }

    @Test
    @DisplayName("removeDuplicateRecipes: No duplicate recipes should be in the final recipe list")
    void noDuplicateRecipes() {
        // GIVEN
        var recipes = RecipeStore.collectedRecipes();

        // WHEN
        var collected = collector.removeDuplicateRecipes(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrderElementsOf(RecipeStore.notDuplicateRecipes().collect(toList()));
    }

    @Test
    @DisplayName("filterForNotTooSweetRecipes: Only recipes with less than 300g sugar should remain")
    void notTooSweet() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var collected = collector.filterForNotTooSweetRecipes(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrderElementsOf(RecipeStore.notTooSweetRecipes().collect(toList()));
    }

    @Test
    @DisplayName("getCookieNames: The correct names should be returned")
    void names() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var collected = collector.getCookieNames(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrder("Power Puff Muffin", "Classical Cookie", "Mayan Molasses", "Mouthwatering Macaroons");
    }

    @Test
    @DisplayName("notTooSweetCookieNames: The correct names should be returned (not too sweet cookies)")
    void notSweetNames() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var collected = collector.notTooSweetCookieNames(recipes);

        // THEN
        assertThat(collected).containsExactlyInAnyOrder("Power Puff Muffin", "Mayan Molasses");
    }

    @Test
    @DisplayName("sugarSumOfRecipes: Should calculate the sum of sugar for all recipes")
    void sugarSum() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var sum = collector.sugarSumOfRecipes(recipes);

        // THEN
        assertThat(sum).isEqualTo(1200);
    }

    @Test
    @DisplayName("listIngredients: Should calculate proper ingredients list")
    void listIngredients() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var ingredients = collector.listIngredients(recipes);

        // THEN
        assertThat(ingredients).containsExactlyInAnyOrder("sugar", "flour", "milk", "eggs", "spice", "everything nice", "an impending sense of doom");
    }
    
    @Test
    @DisplayName("mostDifficultRecipe: Should return with the Recipe that has the highest difficulty")
    void mostDifficult() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();
        
        // WHEN
        var most = collector.mostDifficultRecipe(recipes);
        
        // THEN
        assertThat(most).isEqualTo(RecipeStore.RECIPE_3);
    }

    @Test
    @DisplayName("collectNameAndSugar: Should return with a Map where the keys are recipe names and the values are sugar amounts")
    void nameAndSugarInMap() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var ingredientsWithAmounts = collector.collectNameAndSugar(recipes);

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
    @DisplayName("frankenCookie: Should return with the concatenated name of all Recipes")
    void frankenCookie() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var combinedName = collector.frankenCookie(recipes);

        // THEN
        assertThat(combinedName).isEqualTo("Power Puff MuffinClassical CookieMayan MolassesMouthwatering Macaroons");
    }

    @Test
    @DisplayName("inspectionSugar: We should not have any cookies with more than 1000g sugar")
    void inspection1() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var result = collector.inspectionSugar(recipes);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("inspectionIngredient: We should have at least one recipe with 'an impending sense of doom'")
    void inspection2() {
        // GIVEN
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var result = collector.inspectionIngredient(recipes);

        // THEN
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("createUltimateRecipe: Should create the ultimate Recipe using reduction")
    void ultimateRecipe() {
        // GIVEN
        Recipe blank = new Recipe("Ultimate Recipe", new HashMap<>(), 0, 0);
        var recipes = RecipeStore.notDuplicateRecipes();

        // WHEN
        var ultimate = collector.createUltimateRecipe(recipes, blank);

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
