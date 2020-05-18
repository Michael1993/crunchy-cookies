package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.stores.CookieStore;
import com.javax1.cookies.secrets.supplier.CookieSupplier;
import com.javax1.cookies.secrets.supplier.CorrectingCookieSupplier;
import com.javax1.cookies.secrets.supplier.SentientCookieSupplier;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
    
    private CookieFactory factory;
    
    @BeforeEach
    void setUp() {
        factory = new CookieFactory();
    }

    @Test
    @DisplayName("cookieStream: Should create stream from Cookie array")
    void fromArray() {
        // GIVEN
        Cookie[] diabetic = CookieStore.DIABETIC_COOKIES;

        // WHEN
        Stream<Cookie> streamed = factory.cookieStream(diabetic);

        // THEN
        assertThat(streamed).containsExactlyInAnyOrder(CookieStore.COOKIE_1, CookieStore.COOKIE_2, CookieStore.COOKIE_3);
    }

    @Test
    @DisplayName("ratingsToStream: Should create IntStream from int array")
    void fromRatings() {
        // GIVEN
        int[] ratings = CookieStore.COOKIE_RATINGS;

        // WHEN
        IntStream streamed = factory.ratingsToStream(ratings);

        // THEN
        assertThat(streamed).containsExactlyInAnyOrder(1, 2, 3, 4, 5, 6, 7, 8);
    }

    @Test
    @DisplayName("multipleCookieBatchesToStream: Should create Stream from multiple Cookie arrays")
    void fromBatches() {
        // GIVEN
        Cookie[] diabetic = CookieStore.DIABETIC_COOKIES;
        Cookie[] sweet = CookieStore.SWEET_COOKIES;
        Cookie[] salty = CookieStore.SALTY_COOKIES;
        Cookie[] eldritch = CookieStore.ELDRITCH_COOKIES;

        // WHEN
        Stream<Cookie> streamed = factory.multipleCookieBatchesToStream(diabetic, sweet, salty, eldritch);

        // THEN
        assertThat(streamed).containsExactlyInAnyOrderElementsOf(CookieStore.cookieStream().collect(Collectors.toList()));
    }

    @Test
    @DisplayName("combiningStreams: Should combine two streams into one")
    void combining() {
        // GIVEN
        Stream<Cookie> diabetic = Stream.of(CookieStore.DIABETIC_COOKIES);
        Stream<Cookie> sweet = Stream.of(CookieStore.SWEET_COOKIES);

        // WHEN
        Stream<Cookie> streamed = factory.combiningStreams(diabetic, sweet);

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
    @DisplayName("suppliedCookies: Should create an infinite stream from the supplier")
    void infinite() {
        // GIVEN
        CookieSupplier supplier = new CorrectingCookieSupplier();

        // WHEN
        Stream<Cookie> stream = factory.suppliedCookies(supplier);

        // THEN
        assertThat(stream.limit(45)).containsOnly(
                CookieStore.COOKIE_11,
                CookieStore.COOKIE_4
        );
    }

    @Test
    @DisplayName("faultySuppliedCookies: Created stream should have no faulty cookies")
    void faulty() {
        // GIVEN
        CookieSupplier supplier = new CorrectingCookieSupplier();

        // WHEN
        Stream<Cookie> stream = factory.faultySuppliedCookies(supplier);

        // THEN
        assertThat(stream.limit(45)).containsOnly(CookieStore.COOKIE_4);
    }

    @Test
    @DisplayName("moreFaultySuppliedCookies: Created stream should have no faulty cookies")
    void moreFaulty() {
        // GIVEN
        CookieSupplier supplier = new CorrectingCookieSupplier(7);

        // WHEN
        Stream<Cookie> stream = factory.moreFaultySuppliedCookies(supplier);

        // THEN
        assertThat(stream.limit(45)).containsOnly(CookieStore.COOKIE_4);
    }

    @Test
    @DisplayName("limitedCookieStream: Should have 12 elements from the supplier")
    void limited() {
        // GIVEN
        CookieSupplier supplier = new SentientCookieSupplier();

        // WHEN
        Stream<Cookie> stream = factory.limitedCookieStream(supplier);
        List<Cookie> list = stream.collect(Collectors.toList());

        // THEN
        assertThat(list).hasSize(12);
        assertThat(list).containsOnly(
                CookieStore.COOKIE_1,
                CookieStore.COOKIE_11
        );
    }

    @Test
    @DisplayName("sentienceGainingCookieSupplier: Should not have sentient cookies")
    void dropped() {
        // GIVEN
        CookieSupplier supplier = new SentientCookieSupplier(13);

        // WHEN
        Stream<Cookie> stream = factory.sentienceGainingCookieSupplier(supplier);
        List<Cookie> list = stream.collect(Collectors.toList());

        // THEN
        assertThat(list).hasSize(13);
        assertThat(list).containsOnly(CookieStore.COOKIE_1);
    }
}
