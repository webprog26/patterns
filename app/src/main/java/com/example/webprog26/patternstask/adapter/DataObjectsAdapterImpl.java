package com.example.webprog26.patternstask.adapter;

import android.support.annotation.NonNull;

import com.example.webprog26.patternstask.adapter.NewDataObject;
import com.example.webprog26.patternstask.adapter.interfaces.DataObjectsAdapter;
import com.example.webprog26.patternstask.adapter.interfaces.NewData;
import com.example.webprog26.patternstask.adapter.interfaces.OldData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by webprog26 on 22.11.17.
 */

public class DataObjectsAdapterImpl implements DataObjectsAdapter {

    private final List<OldData> oldDataList;

    public DataObjectsAdapterImpl(List<OldData> oldDataList) {
        this.oldDataList = oldDataList;
    }

    @NonNull
    @Override
    public List<NewData> newDataList() {
        ArrayList<NewData> dataArrayList = new ArrayList<>();
        for(OldData oldData: oldDataList){
            dataArrayList.add(new NewDataObject("New " + oldData.getOldLabel()));
        }
        return dataArrayList;
    }
}
