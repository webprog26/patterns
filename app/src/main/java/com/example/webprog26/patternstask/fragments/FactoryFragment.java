package com.example.webprog26.patternstask.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.factory.interfaces.OnUrlLoadedCallback;
import com.example.webprog26.patternstask.factory.interfaces.UrlLoader;
import com.example.webprog26.patternstask.factory.interfaces.UrlLoaderFactory;
import com.example.webprog26.patternstask.factory.UrlLoaderFactoryImpl;
import com.example.webprog26.patternstask.template.BaseFragment;
import com.example.webprog26.patternstask.template.OnClickFragment;

import butterknife.BindView;

/**
 * Created by webprog26 on 20.11.17.
 */

public class FactoryFragment extends OnClickFragment{

    private static final String URL = "https://google.com";

    @BindView(R.id.text_view)
    TextView mTextView;

    @BindView(R.id.btn_simple_url_Loader)
    Button mBtnSimpleUrlLoader;

    @BindView(R.id.btn_advanced_url__Loader)
    Button mBtnAdvancedUrlLoader;


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnSimpleUrlLoader.setOnClickListener(this);
        mBtnAdvancedUrlLoader.setOnClickListener(this);
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.factory_fragment;
    }

    @Override
    public void onClick(View v) {
        UrlLoaderFactory urlLoaderFactory = UrlLoaderFactoryImpl.getInstance();
        UrlLoader urlLoader = null;

        switch (v.getId()) {
            case R.id.btn_simple_url_Loader:
                urlLoader = urlLoaderFactory.getUrlLoader(UrlLoaderFactory.SIMPLE_URL_LOADER);
                break;
            case R.id.btn_advanced_url__Loader:
                urlLoader = urlLoaderFactory.getUrlLoader(UrlLoaderFactory.ADVANCED_URL_LOADER);
                break;
        }

        if(urlLoader != null) {
            urlLoader.loadUrl(URL, new OnUrlLoadedCallback() {
                @Override
                public void onUrlLoaded(@Nullable String result) {
                    mTextView.setText(result);
                }
            });
        }
    }
}
