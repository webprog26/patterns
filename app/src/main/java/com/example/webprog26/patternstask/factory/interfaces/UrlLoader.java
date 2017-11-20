package com.example.webprog26.patternstask.factory.interfaces;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 20.11.17.
 */

public interface UrlLoader {

    String DEBUG_TAG = "url_loader";

    void loadUrl(@NonNull final String url, @NonNull OnUrlLoadedCallback callback);
}
