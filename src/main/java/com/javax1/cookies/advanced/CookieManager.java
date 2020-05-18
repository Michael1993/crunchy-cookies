package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Comparator.comparingInt;
import static java.util.function.BinaryOperator.maxBy;
import static java.util.stream.Collectors.reducing;

/**
 * The Crunchy Cookie Company has been thriving since you helped set up
 * production. Now they are a very serious business in need of your help for
 * deciding how to advance with their business strategy.
 */
public class CookieManager {

    /**
     * We have a stream of cookies. Unorganized.
     * This is simply unacceptable, we need to organize them by category.
     * <p>
     * HINT: Use the groupingBy() collector.
     *
     * @param cookies a stream of unorganized cookies
     * @return a map where cookies are organized by their category
     */
    public static Map<Cookie.Category, List<Cookie>> groupedByCookieCategory(Stream<Cookie> cookies) {
        return null;
    }

    /**
     * But actually we don't need all that data. We only want
     * the highest rated cookie from each category.
     * You can get the rating of a cookie from the 'rating()'
     * method. Rating is always at least 1 and every category
     * has at least one cookie.
     * <p>
     * HINT: Use groupingBy and the 'reducing' collector.
     *
     * @param cookies a stream of cookies
     * @param unrated a cookie with a rating of 0
     * @return a map of cookie categories and the highest rated cookie in that category
     */
    public static Map<Cookie.Category, Cookie> groupedAndHighestRated(Stream<Cookie> cookies, Cookie unrated) {
        return cookies.collect(Collectors.groupingBy(Cookie::category, reducing(unrated, maxBy(comparingInt(Cookie::rating)))));
    }
}
