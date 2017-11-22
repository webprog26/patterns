package com.example.webprog26.patternstask.visitor;

/**
 * Created by webprog26 on 21.11.17.
 */

public interface Visitor {

    String visitShop(Shop shop);
    String visitWarehouse(WareHouse wareHouse);
}
