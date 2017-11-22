package com.example.webprog26.patternstask.adapter;

import android.support.annotation.NonNull;

import com.example.webprog26.patternstask.adapter.interfaces.OldData;

/**
 * Created by webprog26 on 22.11.17.
 */

public class OldDataObject extends DataObject implements OldData {

    public OldDataObject(String label) {
        super(label);
    }

    @NonNull
    @Override
    public String getOldLabel() {
        return getLabel();
    }
}
