package com.javax1.cookies.secrets.hints;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.supplier.CookieSupplier;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public interface CookieFactoryHints {
    /**
     * HINT: There is a static factory method
     * for streams.
     */
    Stream<Cookie> cookieStream(Cookie[] cookies);

    /**
     * HINT: There is a helper method
     * for creating streams from arrays.
     */
    IntStream ratingsToStream(int[] ratings);

    /**
     * HINT: Simply using Stream.of might lead to
     * unexpected results.
     */
    Stream<Cookie> multipleCookieBatchesToStream(Cookie[]... batches);

    /**
     * HINT: Stream has a lot of static helper
     * methods.
     */
    Stream<Cookie> combiningStreams(Stream<Cookie> firstBatch, Stream<Cookie> secondBatch);

    /**
     * HINT: 'generate' a stream from the supplier.
     */
    Stream<Cookie> suppliedCookies(CookieSupplier cookieSupplier);

    /**
     * HINT: Use skip() to skip some elements in the stream.
     */
    Stream<Cookie> faultySuppliedCookies(CookieSupplier cookieSupplier);

    /**
     * HINT: Use 'dropWhile()' to drop elements.
     */
    Stream<Cookie> moreFaultySuppliedCookies(CookieSupplier cookieSupplier);

    /**
     * HINT: Use 'limit()' to limit the elements in the stream.
     */
    Stream<Cookie> limitedCookieStream(CookieSupplier cookieSupplier);

    /**
     * HINT: Use 'takeWhile' to take elements.
     */
    Stream<Cookie> sentienceGainingCookieSupplier(CookieSupplier cookieSupplier);
}
