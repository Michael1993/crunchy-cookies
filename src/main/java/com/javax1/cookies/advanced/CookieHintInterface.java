package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public interface CookieHintInterface {
    /**
     * HINT: Use the groupingBy() collector.
     */
    Map<Cookie.Category, List<Cookie>> groupedByCookieCategory(Stream<Cookie> cookies);

    /**
     * HINT: Use groupingBy and the 'reducing' collector.
     */
    Map<Cookie.Category, Cookie> groupedAndHighestRated(Stream<Cookie> cookies, Cookie unrated);

    /**
     * HINT: Use the teeing and the minBy/maxBy collectors.
     */
    List<Cookie> minMaxRatedCookies(Stream<Cookie> cookies);

    /**
     * HINT: Reverse sort the stream and take the first 3 elements.
     */
    List<Cookie> topThreeCookies(Stream<Cookie> cookies);

    /**
     * HINT: Use a filter and the max collector.
     */
    Cookie topCookieOfCategory(Stream<Cookie> cookies);
}
