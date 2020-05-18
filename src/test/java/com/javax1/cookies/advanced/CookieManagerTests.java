package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.stores.CookieStore;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Run this to validate your CookieManager implementation.
 */
public class CookieManagerTests {
    
    private CookieManager manager;
    
    @BeforeEach
    void setUp() {
        manager = new CookieManager();
    }

    @Test
    @DisplayName("groupedByCookieCategory: Should group cookies by their categories")
    void groupedByCategory() {
        // GIVEN
        var cookies = CookieStore.cookieStream();

        // WHEN
        var grouped = manager.groupedByCookieCategory(cookies);

        // THEN
        assertThat(grouped).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        Cookie.Category.DIABETIC, List.of(CookieStore.DIABETIC_COOKIES),
                        Cookie.Category.SWEET, List.of(CookieStore.SWEET_COOKIES),
                        Cookie.Category.SALTY, List.of(CookieStore.SALTY_COOKIES),
                        Cookie.Category.ELDRITCH, List.of(CookieStore.ELDRITCH_COOKIES)
                )
        );
    }

    @Test
    @DisplayName("groupedAndHighestRated: Should find the highest rated cookie for each category")
    void groupedAndRated() {
        // GIVEN
        var cookies = CookieStore.cookieStream();

        // WHEN
        var grouped = manager.groupedAndHighestRated(cookies, CookieStore.UNRATED);

        // THEN
        assertThat(grouped).containsExactlyInAnyOrderEntriesOf(
                Map.of(
                        Cookie.Category.DIABETIC, CookieStore.COOKIE_1,
                        Cookie.Category.SWEET, CookieStore.COOKIE_4,
                        Cookie.Category.SALTY, CookieStore.COOKIE_8,
                        Cookie.Category.ELDRITCH, CookieStore.COOKIE_10
                )
        );
    }

    @Test
    @DisplayName("minMaxRatedCookies: Should find the highest and lowest rated cookies")
    void minMax() {
        // GIVEN
        var cookies = CookieStore.cookieStream();

        // WHEN
        var minMax = manager.minMaxRatedCookies(cookies);

        // THEN
        assertThat(minMax).containsExactlyInAnyOrder(CookieStore.COOKIE_10, CookieStore.COOKIE_11);
    }

    @Test
    @DisplayName("topThreeCookies: Should return with the top three cookies in descending order")
    void topThree() {
        // GIVEN
        var cookies = CookieStore.cookieStream();

        // WHEN
        var topThree = manager.topThreeCookies(cookies);

        // THEN
        assertThat(topThree).containsExactly(CookieStore.COOKIE_10, CookieStore.COOKIE_4, CookieStore.COOKIE_5);
    }

    @Test
    @DisplayName("topCookieOfCategory: Should return with the highest rated ELDRITCH cookie")
    void topSentient() {
        // GIVEN
        var cookies = CookieStore.cookieStream();

        // WHEN
        var sentient = manager.topCookieOfCategory(cookies);

        // THEN
        assertThat(sentient).isEqualTo(CookieStore.COOKIE_10);
    }
}
