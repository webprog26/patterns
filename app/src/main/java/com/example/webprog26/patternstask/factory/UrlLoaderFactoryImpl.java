package com.example.webprog26.patternstask.factory;

import android.support.annotation.Nullable;

import com.example.webprog26.patternstask.factory.interfaces.UrlLoader;
import com.example.webprog26.patternstask.factory.interfaces.UrlLoaderFactory;

/**
 * Created by webprog26 on 20.11.17.
 */

public class UrlLoaderFactoryImpl implements UrlLoaderFactory {

    private static UrlLoaderFactory instance = new UrlLoaderFactoryImpl();

    public static UrlLoaderFactory getInstance(){
        return instance;
    }

    @Nullable
    @Override
    public UrlLoader getUrlLoader(int urlLoaderId) {
        switch (urlLoaderId) {
            case SIMPLE_URL_LOADER:
                return new SimpleUrlLoader();
            case ADVANCED_URL_LOADER:
                return new AdvancedUrlLoader();
                default:
                    return null;
        }
    }
}
