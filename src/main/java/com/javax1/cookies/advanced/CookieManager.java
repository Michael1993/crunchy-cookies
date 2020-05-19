package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.hints.CookieManagerHints;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * The Crunchy Cookie Company has been thriving since you helped set up
 * production. Now they are a very serious business in need of your help for
 * deciding how to advance with their business strategy.
 */
public class CookieManager implements CookieManagerHints {

    /**
     * We have a stream of cookies. Unorganized.
     * This is simply unacceptable, we need to organize them by category.
     *
     * @param cookies a stream of unorganized cookies
     * @return a map where cookies are organized by their category
     * @inheritDoc
     */
    @Override
    public Map<Cookie.Category, List<Cookie>> groupedByCookieCategory(Stream<Cookie> cookies) {
        return cookies.collect(Collectors.groupingBy(Cookie::category));
    }

    /**
     * But actually we don't need all that data. We only want
     * the highest rated cookie from each category.
     * You can get the rating of a cookie from the 'rating()'
     * method. Rating is always at least 1 and every category
     * has at least one cookie.
     *
     * @param cookies a stream of cookies
     * @param unrated a cookie with a rating of 0
     * @return a map of cookie categories and the highest rated cookie in that category
     * @inheritDoc
     */
    @Override
    public Map<Cookie.Category, Cookie> groupedAndHighestRated(Stream<Cookie> cookies, Cookie unrated) {
        return cookies.collect(
                Collectors.groupingBy(
                        Cookie::category,
                        Collectors.reducing(unrated, BinaryOperator.maxBy(Comparator.comparingInt(Cookie::rating)))
                )
        );
    }

    /**
     * We have some good cookies and some bad cookies.
     * The company decided to create a Cookie Hall of Fame
     * for our best cookies and a Cookie Hall of Shame for
     * our worst cookies. We just need our first entry for
     * both of those.
     * Could you make a list that has the highest rated cookie
     * and the lowest rated cookie?
     *
     * @param cookies a stream of cookies with at least two elements
     * @return a List with two cookies - the highest rated and the lowest rated
     * @inheritDoc
     */
    @Override
    public List<Cookie> minMaxRatedCookies(Stream<Cookie> cookies) {
        return cookies.collect(Collectors.teeing(
                Collectors.minBy(Comparator.comparingInt(Cookie::rating)),
                Collectors.maxBy(Comparator.comparingInt(Cookie::rating)),
                (cookie1, cookie2) -> List.of(cookie1.get(), cookie2.get()))
        );
    }

    /**
     * The marketing department said that having
     * a Cookie Hal of Fame is a great idea to better
     * advertise our best assets. Let's put the top
     * three cookies we have in there, instead of just
     * one.
     *
     * @param cookies a stream of cookies with at least three elements
     * @return a List with the top three cookies by rating (in descending order)
     * @inheritDoc
     */
    @Override
    public List<Cookie> topThreeCookies(Stream<Cookie> cookies) {
        return cookies.sorted(Comparator.comparingInt(Cookie::rating).reversed()).limit(3).collect(Collectors.toUnmodifiableList());
    }

    /**
     * There is some peculiar interest in our sentient cookies.
     * Management is getting very nervous about it, we have to
     * investigate what's going on with that.
     * Could you find us the highest rated cookie from the
     * ELDRITCH category?
     *
     * @param cookies a stream of cookies with at least one sentient cookie
     * @return the highest rated cookie from the ELDRITCH category
     * @inheritDoc
     */
    @Override
    public Cookie topCookieOfCategory(Stream<Cookie> cookies) {
        return cookies.filter(cookie -> cookie.category().equals(Cookie.Category.ELDRITCH)).max(Comparator.comparingInt(Cookie::rating)).get();
    }

}
