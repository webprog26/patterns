package com.example.webprog26.patternstask.visitor;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 21.11.17.
 */

public class CarShop extends Shop {

    public CarShop(String label) {
        super(label);
    }

    @Override
    public String accept(@NonNull Visitor visitor) {
        return visitor.visitShop(this);
    }
}
