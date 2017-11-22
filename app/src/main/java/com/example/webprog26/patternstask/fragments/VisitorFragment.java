package com.example.webprog26.patternstask.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.template.OnClickFragment;
import com.example.webprog26.patternstask.visitor.CarShop;
import com.example.webprog26.patternstask.visitor.DwafWareHouse;
import com.example.webprog26.patternstask.visitor.Item;
import com.example.webprog26.patternstask.visitor.TitleVisitor;
import com.example.webprog26.patternstask.visitor.Visitor;

import java.util.ArrayList;

import butterknife.BindView;

/**
 * Created by webprog26 on 21.11.17.
 */

public class VisitorFragment extends OnClickFragment {

    private static final String DEBUG_TAG = "visitor";

    @BindView(R.id.tv_text)
    TextView mTvText;

    @BindView(R.id.btn_run_visitor)
    Button mBtnRunVisitor;

    private final ArrayList<Item> items = new ArrayList<>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        items.add(new CarShop("Toronto Cars"));
        items.add(new DwafWareHouse("Giran town"));
        items.add(new DwafWareHouse("Runa town"));
        items.add(new CarShop("KIA Service"));
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mBtnRunVisitor.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_run_visitor:
                mTvText.setText(getVisitorResult());

                break;
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.visitor_fragment;
    }

    private String getVisitorResult(){

        final StringBuilder stringBuilder = new StringBuilder();
        final Visitor visitor = new TitleVisitor();

        for(Item item: items) {
            stringBuilder.append(item.accept(visitor) + "\n");
        }
        return stringBuilder.toString();
    }
}
