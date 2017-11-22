package com.example.webprog26.patternstask.adapter;

import android.support.annotation.NonNull;

import com.example.webprog26.patternstask.adapter.interfaces.NewData;

/**
 * Created by webprog26 on 22.11.17.
 */

public class NewDataObject extends DataObject implements NewData {

    public NewDataObject(String label) {
        super(label);
    }

    @NonNull
    @Override
    public String getNewLabel() {
        return getLabel();
    }
}
