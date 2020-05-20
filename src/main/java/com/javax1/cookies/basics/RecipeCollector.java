package com.javax1.cookies.basics;

import com.javax1.cookies.secrets.Recipe;
import com.javax1.cookies.secrets.hints.RecipeCollectorHints;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * INSTRUCTIONS:
 * The Crunchy Cookie Company wants to make delicious cookies.
 * For making these cookies they have been collecting recipes from ALL OVER the country.
 * Unfortunately that means they now have a LOT of recipes and they don't know how to handle them.
 * <p>
 * Maybe you could help?
 */
public class RecipeCollector implements RecipeCollectorHints {
    /**
     * The company is very impressed with the efforts that went into this recipe collecting endeavour.
     * Truly impressive work, we managed to collect, uh... how many recipes again? Could you help us out?
     *
     * @param recipes a stream of recipes we want to count
     * @return the number of recipes in the stream
     * @inheritDoc
     */
    @Override
    public long countRecipes(Stream<Recipe> recipes) {
        return recipes.count();
    }

    /**
     * Apparently some recipes are not unique. We would like to know how many unique recipes we have.
     * Try solving this without using the 'collect()' method.
     *
     * @param recipes a stream of recipes
     * @return the number of distinct recipes in the stream
     * @inheritDoc
     */
    @Override
    public long uniqueRecipeCount(Stream<Recipe> recipes) {
        return recipes.distinct().count();
    }

    /**
     * We have a lot of duplicate recipes, unfortunately. We would like to have a collection of recipes
     * but without the duplicates.
     *
     * @param recipes a stream of recipes with some duplicates
     * @return a collection with the same recipes just without any duplicate elements
     * @inheritDoc
     */
    @Override
    public Collection<Recipe> removeDuplicateRecipes(Stream<Recipe> recipes) {
        return recipes.distinct().collect(Collectors.toList());
    }

    /**
     * Now we have our recipes but some people are worried the company is making
     * cookies that are "too sweet". We need to show them a list of recipes that contain
     * less than 300g sugar.
     * <p>
     * (the amount of sugar measured in grams in a Recipe is returned by the sugar() method)
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the only recipes with less than 300g sugar in them
     * @inheritDoc
     */
    @Override
    public Collection<Recipe> filterForNotTooSweetRecipes(Stream<Recipe> recipes) {
        return recipes.filter(e -> e.sugar() < 300).collect(Collectors.toList());
    }

    /**
     * The advertising department wants a list of cookie names
     * so they can start advertising our delicious cookies. They don't want the whole
     * recipes just the names.
     * <p>
     * (the name of the recipe is returned by the name() method)
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a collection of cookie names
     * @inheritDoc
     */
    @Override
    public Collection<String> getCookieNames(Stream<Recipe> recipes) {
        return recipes.map(Recipe::name).collect(Collectors.toList());
    }

    /**
     * So, uh, which cookies contain less than 300g sugar, again?
     * Just give me the names.
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a collection of (not too sweet) cookie names
     * @inheritDoc
     */
    @Override
    public Collection<String> notTooSweetCookieNames(Stream<Recipe> recipes) {
        return recipes.filter(e -> e.sugar() < 300).map(Recipe::name).collect(Collectors.toList());
    }

    /**
     * Alright, it seems we are ready to begin production!
     * Management wants to calculate how much sugar we will need.
     * Just add all the sugar together from each recipe.
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the amount of sugar from each recipe summed
     * @inheritDoc
     */
    @Override
    public int sugarSumOfRecipes(Stream<Recipe> recipes) {
        return recipes.distinct().mapToInt(Recipe::sugar).sum();
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
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a collection of ingredients (Strings) without duplicates
     * @inheritDoc
     */
    @Override
    public Collection<String> listIngredients(Stream<Recipe> recipes) {

//        Collection<String> allIngredients = new ArrayList<>();
//
//        Collection<Recipe> list = recipes.collect(Collectors.toList());
//
//        for (Recipe recipe : list) {
//            allIngredients.addAll(recipe.ingredients().keySet());
//        }
//
//        return allIngredients.stream().distinct().collect(Collectors.toList());

        return recipes.flatMap(r -> r.ingredients().keySet().stream()).distinct().collect(Collectors.toList());

    }

    /**
     * A world famous chef wants to come work the company!
     * He has some conditions, though. He wants to know
     * what is our hardest recipe we have.
     * Thankfully, the gals and guys managed to add a difficulty
     * rating to every recipe (meaning we _always_ have a 'most
     * difficult' recipe).
     * Can you get us the most difficult recipe only?
     * <p>
     * (the difficulty is returned by the 'difficulty()' method)
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the recipe with the highest difficulty
     * @inheritDoc
     */
    @Override
    public Recipe mostDifficultRecipe(Stream<Recipe> recipes) {

//        List<Recipe> streamAsListToBeUsedAgain = recipes.collect(Collectors.toList());
//
//        int maxDifficultiy = streamAsListToBeUsedAgain.stream().mapToInt(Recipe::difficulty).max().getAsInt();
//
//        return streamAsListToBeUsedAgain.stream().filter(r -> r.difficulty() == maxDifficultiy).findFirst().get();
        return recipes.sorted(Comparator.comparingInt(Recipe::difficulty).reversed()).findFirst().get();
    }

    /**
     * Previously we looked at recipe names and low-sugar recipes,
     * now lets look at both! Create a Map<String, Integer> where
     * the key is the name of the recipe and the value is the
     * amount of sugar in the recipe.
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the map of ingredients with amounts
     * @inheritDoc
     */
    @Override
    public Map<String, Integer> collectNameAndSugar(Stream<Recipe> recipes) {

      //  Stream<Recipe> lowSugarReciepes = filterForNotTooSweetRecipes(recipes).stream();

        HashMap<String, Integer> lowSugarNameAndSugar = new HashMap<String, Integer>();


        filterForNotTooSweetRecipes(recipes).stream().forEach(r -> {lowSugarNameAndSugar.put(r.name(), r.sugar());});

        return lowSugarNameAndSugar;

        /*
        I call the expected result to be wrong. The text says that only low sugar reciepes should be returned

        >> Previously we looked at recipe names and low-sugar recipes, now lets look at both

        java.lang.AssertionError:
Expecting:
  <{"Mayan Molasses"=200, "Power Puff Muffin"=200}>
to contain only:
  <[Mayan Molasses=200,
    Power Puff Muffin=200,
    Classical Cookie=300,
    Mouthwatering Macaroons=500]>
but could not find the following elements:
  <[MapEntry[key="Classical Cookie", value=300],
    MapEntry[key="Mouthwatering Macaroons", value=500]]>
         */

    }

    /**
     * The production has started but there was an accident.
     * Apparently "someone" installed some equipment backwards and now
     * all cookies get mashed together into a Frankenstein Cookie.
     * That's not what it's called, though. Some hotshot decided that
     * we should also mash the names together...
     * Can you tell me what the name of this monstrosity will be?
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return the name of this abomination
     * @inheritDoc
     */
    @Override
    public String frankenCookie(Stream<Recipe> recipes) {
        return null;
    }

    /**
     * Because of some incompetence apparently there will be
     * an inspection. People will come and look at our recipes
     * to see if they contain insane amounts of sugar.
     * But you can easily tell them that none of our recipes have over
     * 1000g sugar, right?
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a true/false value indicating whether we will pass the inspection
     * @inheritDoc
     */
    @Override
    public boolean inspectionSugar(Stream<Recipe> recipes) {
        return false;
    }

    /**
     * The inspector now insists that we sell only bad quality cookies
     * because we don't use his favourite ingredient. But we will prove him wrong!
     * At least one of our cookies MUST use... "an impending sense of doom"?
     * What kind of inspector is this?!
     *
     * @param recipes a stream of recipes (no duplicates)
     * @return a true/false value indicating if we have any recipes using "an impending sense of doom"
     * @inheritDoc
     */
    @Override
    public boolean inspectionIngredient(Stream<Recipe> recipes) {
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
     * Recipe #1:
     *  - Sugar: 200
     *  - Eggs: 5
     *  - Flour: 150
     * Recipe #2:
     *  - Sugar: 300
     *  - Milk: 200
     *  - Flour: 100
     * For these two recipes the Ultimate Cookie Recipe would be:
     * Ultimate Cookie Recipe:
     *  - Sugar: 300
     *  - Eggs: 5
     *  - Milk: 200
     *  - Flour: 150
     *
     * @param recipes a stream of recipes
     * @return the Ultimate Cookie Recipe
     * @inheritDoc
     */
    @Override
    public Recipe createUltimateRecipe(Stream<Recipe> recipes, Recipe blank) {
        return null;
    }
}
