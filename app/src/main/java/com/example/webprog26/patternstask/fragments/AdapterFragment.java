package com.example.webprog26.patternstask.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.adapter.DataObjectsAdapterImpl;
import com.example.webprog26.patternstask.adapter.OldDataObject;
import com.example.webprog26.patternstask.adapter.interfaces.DataObjectsAdapter;
import com.example.webprog26.patternstask.adapter.interfaces.NewData;
import com.example.webprog26.patternstask.adapter.interfaces.OldData;
import com.example.webprog26.patternstask.template.OnClickFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by webprog26 on 22.11.17.
 */

public class AdapterFragment extends OnClickFragment {

    private static final int DATAOBJECTS_LIST_SIZE = 5;

    @BindView(R.id.tv_old_data)
    TextView mTvOldData;

    @BindView(R.id.tv_new_data)
    TextView mTvNewData;

    @BindView(R.id.btn_run_adapter)
    Button mBtnRunAdapter;

    private final ArrayList<OldData> oldDataList = new ArrayList<>();
    private DataObjectsAdapter dataObjectsAdapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        for(int i = 0; i < DATAOBJECTS_LIST_SIZE; i++) {
            oldDataList.add(new OldDataObject(getClass().getSimpleName()));
        }
        dataObjectsAdapter = new DataObjectsAdapterImpl(oldDataList);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        final StringBuilder stringBuilder = new StringBuilder();

        for(OldData oldData: oldDataList) {
            stringBuilder.append(oldData.getOldLabel() + "\n");
        }

        mTvOldData.setText(stringBuilder.toString());

        mBtnRunAdapter.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_run_adapter:

                final List<NewData> newDataArrayList = dataObjectsAdapter.newDataList();
                final StringBuilder stringBuilder = new StringBuilder();

                for(NewData newData: newDataArrayList) {
                    stringBuilder.append(newData.getNewLabel() + "\n");
                }

                mTvNewData.setText(stringBuilder.toString());
                break;
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.adapter_fragment;
    }
}
