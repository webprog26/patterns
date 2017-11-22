package com.example.webprog26.patternstask.adapter;

/**
 * Created by webprog26 on 22.11.17.
 */

public abstract class DataObject {

    private final String label;

    public DataObject(String label) {
        this.label = label;
    }

    protected String getLabel() {
        return label;
    }
}
