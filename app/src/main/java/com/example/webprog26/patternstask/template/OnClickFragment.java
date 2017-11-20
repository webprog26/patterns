package com.example.webprog26.patternstask.template;

import android.view.View;

/**
 * Created by webprog26 on 20.11.17.
 */

public abstract class OnClickFragment extends BaseFragment implements View.OnClickListener {

    @Override
    public abstract void onClick(View view);

    @Override
    protected abstract int getLayoutResId();
}
