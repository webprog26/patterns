package com.example.webprog26.patternstask.factory;

import android.support.annotation.NonNull;

import com.example.webprog26.patternstask.factory.interfaces.OnUrlLoadedCallback;
import com.example.webprog26.patternstask.factory.interfaces.UrlLoader;

/**
 * Created by webprog26 on 20.11.17.
 */

public class SimpleUrlLoader implements UrlLoader {

    @Override
    public void loadUrl(@NonNull String url, @NonNull OnUrlLoadedCallback callback) {
        callback.onUrlLoaded("Loading url " + url + " via " + getClass().getSimpleName());
    }
}
