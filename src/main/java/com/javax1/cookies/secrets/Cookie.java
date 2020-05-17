package com.javax1.cookies.secrets;

/**
 * The super-duper secret of the Crunchy Cookie Company. DON'T LOOK!
 */
public class Cookie {
    private final Category category;
    private final int rating;

    public Cookie(Category category, int rating) {
        this.category = category;
        this.rating = rating;
    }

    public Category category() {
        return category;
    }

    public int rating() {
        return rating;
    }

    public enum Category {
        DIABETIC,
        SWEET,
        SALTY,
        ELDRITCH
    }

}
