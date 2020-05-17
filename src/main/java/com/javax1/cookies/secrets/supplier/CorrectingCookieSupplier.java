package com.javax1.cookies.secrets.supplier;

import com.javax1.cookies.secrets.Cookie;
import com.javax1.cookies.secrets.stores.CookieStore;

public class CorrectingCookieSupplier extends CookieSupplier {
    private int faulty = 0;
    private int wrongness = 3;

    public CorrectingCookieSupplier() {
    }

    public CorrectingCookieSupplier(int wrongness) {
        this.wrongness = wrongness;
    }

    @Override
    public Cookie get() {
        if (faulty < wrongness) {
            faulty++;
            return CookieStore.COOKIE_11;
        }
        return CookieStore.COOKIE_4;
    }
}
