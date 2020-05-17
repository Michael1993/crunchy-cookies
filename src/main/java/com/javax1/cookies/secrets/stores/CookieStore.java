package com.javax1.cookies.secrets.stores;

import com.javax1.cookies.secrets.Cookie;

import java.util.stream.Stream;

public class CookieStore {
    public static final Cookie UNRATED = new Cookie(Cookie.Category.SWEET, 0);

    public static final Cookie COOKIE_1 = new Cookie(Cookie.Category.DIABETIC, 70);
    public static final Cookie COOKIE_2 = new Cookie(Cookie.Category.DIABETIC, 36);
    public static final Cookie COOKIE_3 = new Cookie(Cookie.Category.DIABETIC, 56);
    public static final Cookie COOKIE_4 = new Cookie(Cookie.Category.SWEET, 88);
    public static final Cookie COOKIE_5 = new Cookie(Cookie.Category.SWEET, 75);
    public static final Cookie COOKIE_6 = new Cookie(Cookie.Category.SWEET, 13);
    public static final Cookie COOKIE_7 = new Cookie(Cookie.Category.SALTY, 59);
    public static final Cookie COOKIE_8 = new Cookie(Cookie.Category.SALTY, 68);
    public static final Cookie COOKIE_9 = new Cookie(Cookie.Category.SALTY, 66);
    public static final Cookie COOKIE_10 = new Cookie(Cookie.Category.ELDRITCH, 111);
    public static final Cookie COOKIE_11 = new Cookie(Cookie.Category.ELDRITCH, 1);

    public static final Cookie[] DIABETIC_COOKIES = new Cookie[] { COOKIE_1, COOKIE_2, COOKIE_3 };
    public static final Cookie[] SWEET_COOKIES = new Cookie[] { COOKIE_4, COOKIE_5, COOKIE_6 };
    public static final Cookie[] SALTY_COOKIES = new Cookie[] { COOKIE_7, COOKIE_8, COOKIE_9 };
    public static final Cookie[] ELDRITCH_COOKIES = new Cookie[] { COOKIE_10, COOKIE_11 };

    public static final int[] COOKIE_RATINGS = new int[] { 1, 2, 3, 4, 5, 6, 7, 8 };

    public static Stream<Cookie> cookieStream() {
        return Stream.of(
                COOKIE_1,
                COOKIE_2,
                COOKIE_3,
                COOKIE_4,
                COOKIE_5,
                COOKIE_6,
                COOKIE_7,
                COOKIE_8,
                COOKIE_9,
                COOKIE_10,
                COOKIE_11
        );
    }
}
