package com.example.webprog26.patternstask.visitor;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 21.11.17.
 */

public class DwafWareHouse extends WareHouse {

    public DwafWareHouse(String title) {
        super(title);
    }

    @Override
    public String accept(@NonNull Visitor visitor) {
        return visitor.visitWarehouse(this);
    }
}
