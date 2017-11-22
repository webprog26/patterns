package com.example.webprog26.patternstask.visitor;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 21.11.17.
 */

public abstract class WareHouse implements Item {

    private final String title;

    public WareHouse(String title) {
        this.title = title;
    }

    @Override
    public abstract String accept(@NonNull Visitor visitor);

    public String getTitle() {
        return title;
    }
}
