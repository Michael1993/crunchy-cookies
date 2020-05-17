package com.javax1.cookies.basics;

import com.javax1.cookies.secrets.Recipe;

import java.util.Collection;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

/**
 * INSTRUCTIONS:
 * The Crunchy Cookie Company wants to make delicious cookies.
 * For making these cookies they have been collecting recipes from ALL OVER the country.
 * Unfortunately that means they now have a LOT of recipes and they don't know how to handle them.
 * <p>
 * Maybe you could help?
 */
public class RecipeCollector {

    /**
     * The company is very impressed with the efforts that went into this recipe collecting endeavour.
     * Truly impressive work, we managed to collect, uh... how many recipes again? Could you help us out?
     * <p>
     * HINT: Try using count()!
     *
     * @param recipes a stream of recipes we want to count
     * @return the number of recipes in the stream
     */
    public static long countRecipes(Stream<Recipe> recipes) {
        return 0;
    }

    /**
     * Apparently some recipes are not unique. We would like to know how many unique recipes we have.
     * Try solving this without using the 'collect()' method.
     * <p>
     * HINT: We are only interested in a Recipe if it's 'distinct'.
     *
     * @param recipes a stream of recipes
     * @return the number of distinct recipes in the stream
     */
    public static long uniqueRecipeCount(Stream<Recipe> recipes) {
        return 0;
    }

    /**
     * We have a lot of duplicate recipes, unfortunately. We would like to have a collection of recipes
     * but without the duplicates.
     * <p>
     * HINT: Try using collect() and a Collectors static method!
     *
     * @param recipes a stream of recipes with some duplicates
     * @return a collection with the same recipes just without any duplicate elements
     */
    public static Collection<Recipe> removeDuplicateRecipes(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * Now we have our recipes but some people are worried the company is making
     * cookies that are "too sweet". We need to show them a list of recipes that contain
     * less than 300g sugar.
     * <p>
     * (the amount of sugar measured in grams in a Recipe is returned by the sugar() method)
     * <p>
     * HINT: Try using filter()!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the only recipes with less than 300g sugar in them
     */
    public static Collection<Recipe> filterForNotTooSweetRecipes(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * The advertising department wants a list of cookie names
     * so they can start advertising our delicious cookies. They don't want the whole
     * recipes just the names.
     * <p>
     * (the name of the recipe is returned by the name() method)
     * <p>
     * HINT: Try using map() with a method reference!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a collection of cookie names
     */
    public static Collection<String> getCookieNames(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * So, uh, which cookies contain less than 300g sugar, again?
     * Just give me the names.
     * <p>
     * HINT: Try combining filter() and map()!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a collection of (not too sweet) cookie names
     */
    public static Collection<String> notTooSweetCookieNames(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * Alright, it seems we are ready to begin production!
     * Management wants to calculate how much sugar we will need.
     * Just add all the sugar together from each recipe.
     * <p>
     * HINT: Create an IntStream (with a special mapping method)
     * from the Stream and then sum it.
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the amount of sugar from each recipe summed
     */
    public static int sugarSumOfRecipes(Stream<Recipe> recipes) {
        return 0;
    }

    /**
     * Okay, we now know how much sugar we are going to need.
     * What else are we going to need? Can you list the name
     * of the ingredients from each recipe (Only the names)?
     * But don't list duplicates, we don't need that.
     * <p>
     * All recipes store their ingredients in a Map<String, Integer>
     * where keys are the ingredient names and values are the amounts.
     * You can get this Map by calling the ingredients() method.
     * <p>
     * HINT: Use flatMap(), keySet() and collect(toSet())!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a collection of ingredients (Strings) without duplicates
     */
    public static Collection<String> listIngredients(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * A world famous chef wants to come work the company!
     * He has some conditions, though. He wants to know
     * what is our hardest recipe we have.
     * Thankfully, the gals and guys managed to add a difficulty
     * rating to every recipe (meaning we _always_ have a 'most
     * difficult' recipe).
     * Can you get us the most difficult recipe only?
     *
     * (the difficulty is returned by the 'difficulty()' method)
     *
     * HINT: Try using max() and Comparators.comparingInt()!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the recipe with the highest difficulty
     */
    public static Recipe mostDifficultRecipe(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * Previously we looked at recipe names and low-sugar recipes,
     * now lets look at both! Create a Map<String, Integer> where
     * the key is the name of the recipe and the value is the
     * amount of sugar in the recipe.
     * <p>
     * HINT: Use the toMap() collector!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the map of ingredients with amounts
     */
    public static Map<String, Integer> collectNameAndSugar(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * The production has started but there was an accident.
     * Apparently "someone" installed some equipment backwards and now
     * all cookies get mashed together into a Frankenstein Cookie.
     * That's not what it's called, though. Some hotshot decided that
     * we should also mash the names together...
     * Can you tell me what the name of this monstrosity will be?
     * <p>
     * HINT: Use map() and a special collector made for String!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the name of this abomination
     */
    public static String frankenCookie(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * Because of some incompetence apparently there will be
     * an inspection. People will come and look at our recipes
     * to see if they contain insane amounts of sugar.
     * But you can easily tell them that none of our recipes have over
     * 1000g sugar, right?
     *
     * HINT: Use the noneMatch() or the allMatch() method!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a true/false value indicating whether we will pass the inspection
     */
    public static boolean inspectionSugar(Stream<Recipe> recipes) {
        return false;
    }

    /**
     * The inspector now insists that we sell only bad quality cookies
     * because we don't use his favourite ingredient. But we will prove him wrong!
     * At least one of our cookies MUST use... "an impending sense of doom"?
     * What kind of inspector is this?!
     *
     * HINT: Use the anyMatch() method!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a true/false value indicating if we have any recipes using "an impending sense of doom"
     */
    public static boolean inspectionIngredient(Stream<Recipe> recipes) {
        final String ingredient = "an impending sense of doom";
        return false;
    }

    /**
     * Everything is going nicely now. So nice, in fact, that
     * some people in upper management started thinking (Never a good sign).
     * They decided we should create the Ultimate Cookie Recipe!
     * Creating this recipe is fairly simple: You take a blank recipe and
     * for each recipe, you add all the ingredients - except if you already
     * added this ingredient to the Ultimate Recipe, then you only add it
     * if the new ingredient amount is higher than the one that was already
     * added.
     * <p>
     * Take the following recipes for example:
     * -----------------------------------
     * |    Recipe #1    |   Recipe # 2  |
     * |-----------------|---------------|
     * |    Sugar: 200   |   Sugar: 300  |
     * |    Eggs: 5      |   Milk: 200   |
     * |    Flour: 150   |   Flour: 100  |
     * -----------------------------------
     * For these two recipes the Ultimate Cookie Recipe would be:
     * ------------------
     * |    Ultimate    |
     * |----------------|
     * |    Sugar: 300  |
     * |    Eggs: 5     |
     * |    Milk: 200   |
     * |    Flour: 150  |
     * ------------------
     * <p>
     * HINT: Use the reduce() operation! This is a relatively hard task, so
     * don't fret if you can't do it right away. If you are absolutely stuck,
     * have a look at the Recipe::merge method.
     *
     * @param recipes a stream of recipes
     * @return the Ultimate Cookie Recipe
     */
    public static Recipe createUltimateRecipe(Stream<Recipe> recipes, Recipe blank) {
        return null;
    }

}
