package com.example.webprog26.patternstask.visitor;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 21.11.17.
 */

public abstract class Shop implements Item {

    private final String label;

    public Shop(String label) {
        this.label = label;
    }

    @Override
    public abstract String accept(@NonNull Visitor visitor);

    public String getLabel() {
        return label;
    }
}
