package com.javax1.cookies.advanced;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.stores.CookieStore;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Run this to validate your CookieManager implementation.
 */
public class CookieManagerTests {

    @Test
    @DisplayName("Should group cookies by their categories when calling 'groupedByCookieCategory'")
    void groupedByCategory() {
        // GIVEN
        var cookies = CookieStore.cookieStream();

        // WHEN
        var grouped = CookieManager.groupedByCookieCategory(cookies);

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
    @DisplayName("Should find the highest rated cookie for each category when calling 'groupedAndHighestRated'")
    void groupedAndRated() {
        // GIVEN
        var cookies = CookieStore.cookieStream();

        // WHEN
        var grouped = CookieManager.groupedAndHighestRated(cookies, CookieStore.UNRATED);

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
}
