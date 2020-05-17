package com.javax1.cookies.secrets.stores;

import com.javax1.cookies.secrets.Recipe;

import java.util.stream.Stream;

import static com.javax1.cookies.secrets.stores.IngredientStore.INGREDIENT_LIST_1;
import static com.javax1.cookies.secrets.stores.IngredientStore.INGREDIENT_LIST_2;
import static com.javax1.cookies.secrets.stores.IngredientStore.INGREDIENT_LIST_3;
import static com.javax1.cookies.secrets.stores.IngredientStore.INGREDIENT_LIST_4;

public class RecipeStore {

    public static final Recipe RECIPE_1 = new Recipe("Power Puff Muffin", INGREDIENT_LIST_1, 200, 5);
    public static final Recipe RECIPE_2 = new Recipe("Classical Cookie", INGREDIENT_LIST_2, 300, 3);
    public static final Recipe RECIPE_3 = new Recipe("Mayan Molasses", INGREDIENT_LIST_3, 200, 12);
    public static final Recipe RECIPE_4 = new Recipe("Mouthwatering Macaroons", INGREDIENT_LIST_4, 500, 8);

    public static Stream<Recipe> collectedRecipes() {
        return Stream.of(
                RECIPE_1,
                RECIPE_2,
                RECIPE_4,
                RECIPE_3,
                RECIPE_4,
                RECIPE_1,
                RECIPE_2
        );
    }

    public static Stream<Recipe> notDuplicateRecipes() {
        return Stream.of(
                RECIPE_1,
                RECIPE_2,
                RECIPE_3,
                RECIPE_4
        );
    }

    public static Stream<Recipe> notTooSweetRecipes() {
        return Stream.of(
                RECIPE_1,
                RECIPE_3
        );
    }
}
