package com.javax1.cookies.secrets.supplier;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.stores.CookieStore;

public class SentientCookieSupplier extends CookieSupplier {
    private int sentience = 0;
    private int limit = 6;

    public SentientCookieSupplier() {
    }

    public SentientCookieSupplier(int limit) {
        this.limit = limit;
    }

    @Override
    public Cookie get() {
        if (sentience < limit) {
            sentience++;
            return CookieStore.COOKIE_1;
        }
        return CookieStore.COOKIE_11;
    }
}
