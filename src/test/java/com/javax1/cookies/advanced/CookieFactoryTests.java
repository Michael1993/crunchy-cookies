package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.stores.CookieStore;
import com.javax1.cookies.secrets.supplier.CookieSupplier;
import com.javax1.cookies.secrets.supplier.CorrectingCookieSupplier;
import com.javax1.cookies.secrets.supplier.SentientCookieSupplier;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Run this to validate your CookieFactory implementation.
 */
public class CookieFactoryTests {

    @Test
    void fromArray() {
        // GIVEN
        Cookie[] diabetic = CookieStore.DIABETIC_COOKIES;

        // WHEN
        Stream<Cookie> streamed = CookieFactory.cookieStream(diabetic);

        // THEN
        assertThat(streamed).containsExactlyInAnyOrder(CookieStore.COOKIE_1, CookieStore.COOKIE_2, CookieStore.COOKIE_3);
    }

    @Test
    void fromRatings() {
        // GIVEN
        int[] ratings = CookieStore.COOKIE_RATINGS;

        // WHEN
        IntStream streamed = CookieFactory.ratingsToStream(ratings);

        // THEN
        assertThat(streamed).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    void fromBatches() {
        // GIVEN
        Cookie[] diabetic = CookieStore.DIABETIC_COOKIES;
        Cookie[] sweet = CookieStore.SWEET_COOKIES;
        Cookie[] salty = CookieStore.SALTY_COOKIES;
        Cookie[] eldritch = CookieStore.ELDRITCH_COOKIES;

        // WHEN
        Stream<Cookie> streamed = CookieFactory.multipleCookieBatchesToStream(diabetic, sweet, salty, eldritch);

        // THEN
        assertThat(streamed).containsExactlyInAnyOrderElementsOf(CookieStore.cookieStream().collect(Collectors.toList()));
    }

    @Test
    void combining() {
        // GIVEN
        Stream<Cookie> diabetic = Stream.of(CookieStore.DIABETIC_COOKIES);
        Stream<Cookie> sweet = Stream.of(CookieStore.SWEET_COOKIES);

        // WHEN
        Stream<Cookie> streamed = CookieFactory.combiningStreams(diabetic, sweet);

        // THEN
        assertThat(streamed).containsExactlyInAnyOrder(
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_2,
                CookieStore.COOKIE_3,
                CookieStore.COOKIE_4,
                CookieStore.COOKIE_5,
                CookieStore.COOKIE_6
        );
    }

    @Test
    void infinite() {
        // GIVEN
        CookieSupplier supplier = new CorrectingCookieSupplier();

        // WHEN
        Stream<Cookie> stream = CookieFactory.suppliedCookies(supplier);

        // THEN
        assertThat(stream.limit(45)).containsOnly(
                CookieStore.COOKIE_11,
                CookieStore.COOKIE_4
        );
    }

    @Test
    void faulty() {
        // GIVEN
        CookieSupplier supplier = new CorrectingCookieSupplier();

        // WHEN
        Stream<Cookie> stream = CookieFactory.faultySuppliedCookies(supplier);

        // THEN
        assertThat(stream.limit(45)).containsOnly(CookieStore.COOKIE_4);
    }

    @Test
    void moreFaulty() {
        // GIVEN
        CookieSupplier supplier = new CorrectingCookieSupplier(7);

        // WHEN
        Stream<Cookie> stream = CookieFactory.moreFaultySuppliedCookies(supplier);

        // THEN
        assertThat(stream.limit(45)).containsOnly(CookieStore.COOKIE_4);
    }

    @Test
    void limited() {
        // GIVEN
        CookieSupplier supplier = new SentientCookieSupplier();

        // WHEN
        Stream<Cookie> stream = CookieFactory.limitedCookieStream(supplier);
        List<Cookie> list = stream.collect(Collectors.toList());

        // THEN
        assertThat(list).hasSize(12);
        assertThat(list).containsExactlyInAnyOrder(
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_11,
                CookieStore.COOKIE_11,
                CookieStore.COOKIE_11,
                CookieStore.COOKIE_11,
                CookieStore.COOKIE_11,
                CookieStore.COOKIE_11
        );
    }

    @Test
    void dropped() {
        // GIVEN
        CookieSupplier supplier = new SentientCookieSupplier(13);

        // WHEN
        Stream<Cookie> stream = CookieFactory.sentienceGainingCookieSupplier(supplier);
        List<Cookie> list = stream.collect(Collectors.toList());

        // THEN
        assertThat(list).hasSize(13);
        assertThat(list).containsOnly(CookieStore.COOKIE_1);
    }
}
