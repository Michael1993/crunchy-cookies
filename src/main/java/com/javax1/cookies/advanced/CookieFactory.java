package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.supplier.CookieSupplier;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Welcome to the magical (and chaotic) world of
 * supplying cookies to the world. We have a bit
 * of a situation here and really need your help
 * to work it out.
 * <p>
 * This class contains exercises about creating
 * Streams.
 */
public class CookieFactory {

    /**
     * We have an array of Cookies but no one
     * likes working with arrays. Turn it into
     * a stream!
     * <p>
     * HINT: There is a static factory method
     * for streams.
     *
     * @param cookies an array of cookies
     * @return the same cookie now in a stream
     */
    public static Stream<Cookie> cookieStream(Cookie[] cookies) {
        return null;
    }

    /**
     * We have an array of ratings and we
     * want to turn it into an IntStream.
     * <p>
     * HINT: There is a helper method
     * for creating streams from arrays.
     *
     * @param ratings an integer array of cookie ratings
     * @return the same ratings in an IntStream
     */
    public static IntStream ratingsToStream(int[] ratings) {
        return null;
    }

    /**
     * We have multiple batches of cookies (don't know
     * how many exactly) and we want to handle them all
     * together. Could you make a stream from it?
     * <p>
     * HINT: Simply using Stream.of might lead to
     * unexpected results.
     *
     * @param batches an unknown amount of cookie arrays
     * @return all batches together in a stream.
     */
    public static Stream<Cookie> multipleCookieBatchesToStream(Cookie[]... batches) {
        return null;
    }

    /**
     * Something got scrambled and now we have two
     * streams of cookies when we only needed one!
     * Is there a way to merge them?
     * <p>
     * HINT: Stream has a lot of static helper
     * methods.
     *
     * @param firstBatch  a stream of cookies
     * @param secondBatch another stream of cookies
     * @return a stream with all the cookies from both batches
     */
    public static Stream<Cookie> combiningStreams(Stream<Cookie> firstBatch, Stream<Cookie> secondBatch) {
        return null;
    }

    /**
     * Here is a revolutionary thought: A never-ending
     * stream of cookies. We have a supplier that gives
     * us cookies. Let's generate a never-ending stream
     * of cookies!
     * <p>
     * HINT: 'generate' a stream from the supplier.
     *
     * @param cookieSupplier a supplier that returns the cookies
     * @return a stream with cookies from the supplier
     */
    public static Stream<Cookie> suppliedCookies(CookieSupplier cookieSupplier) {
        return null;
    }

    /**
     * It turns out that the supplier was faulty!
     * It's okay, though, because only the first three
     * cookies are sentient beings trying to murder our
     * customers. So, we just throw those away, okay?
     * <p>
     * HINT: Use skip() to skip some elements in the stream.
     *
     * @param cookieSupplier a supplier that returns cookies (first 3 are faulty)
     * @return a stream without the sentient cookies
     */
    public static Stream<Cookie> faultySuppliedCookies(CookieSupplier cookieSupplier) {
        return null;
    }

    /**
     * Some of our customers have been complaining that
     * our cookies have tried to eat them instead of the other
     * way around. This must mean that it's not just the first three
     * elements that are 'wrong'. We need a new strategy for collecting
     * cookies - one that drops elements while they are incorrect.
     * (Cookies are incorrect if their category is ELDRITCH)
     * <p>
     * HINT: Use 'dropWhile()' to drop elements.
     *
     * @param cookieSupplier a supplier that returns cookies (first ones are faulty)
     * @return a stream with no sentient cookies
     */
    public static Stream<Cookie> moreFaultySuppliedCookies(CookieSupplier cookieSupplier) {
        return null;
    }

    /**
     * Turns out, having an endless stream of cookies
     * is quite exhausting. 24h shifts, riots, otherworldly
     * portals, murder and, worst of all, rumors about unionizing
     * have been going on, so we need to limit the cookie stream.
     * We changed the supplier so you don't have to worry about
     * the sentient cookies anymore.
     * Let's just limit the stream to have 12 elements in it.
     * <p>
     * HINT: Use 'limit()' to limit the elements in the stream.
     *
     * @param cookieSupplier a new supplier (no sentient cookies?)
     * @return a stream with only 12 elements in it
     */
    public static Stream<Cookie> limitedCookieStream(CookieSupplier cookieSupplier) {
        return null;
    }

    /**
     * We still managed to mess this up... The new supplier
     * also makes sentient cookies! Except this time it's the other
     * way around - we start with perfectly fine normal cookies and
     * then they slowly gain sentience as we make more and more.
     * Management refuses to create a new supplier, so we have to only
     * take cookie while they have no otherworldly quality
     * to them (not in the ELDRITCH category).
     * <p>
     * HINT: Use 'takeWhile' to take elements.
     *
     * @param cookieSupplier a cookie supplier (cookies gain sentience
     *                       after a while)
     * @return a stream with no sentient cookies
     */
    public static Stream<Cookie> sentienceGainingCookieSupplier(CookieSupplier cookieSupplier) {
        return null;
    }
}
