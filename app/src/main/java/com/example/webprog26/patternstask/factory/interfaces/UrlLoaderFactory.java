package com.example.webprog26.patternstask.factory.interfaces;

import android.support.annotation.Nullable;

/**
 * Created by webprog26 on 20.11.17.
 */

public interface UrlLoaderFactory {

    int SIMPLE_URL_LOADER = 0;
    int ADVANCED_URL_LOADER = 1;

    @Nullable
    UrlLoader getUrlLoader(final int urlLoaderId);
}
