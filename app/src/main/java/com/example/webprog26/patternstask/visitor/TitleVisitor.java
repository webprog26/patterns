package com.example.webprog26.patternstask.visitor;

/**
 * Created by webprog26 on 21.11.17.
 */

public class TitleVisitor implements Visitor {

    @Override
    public String visitShop(Shop shop) {
        return shop.getLabel();
    }

    @Override
    public String visitWarehouse(WareHouse wareHouse) {
        return wareHouse.getTitle();
    }
}
