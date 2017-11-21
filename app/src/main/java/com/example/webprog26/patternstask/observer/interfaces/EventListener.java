package com.example.webprog26.patternstask.observer.interfaces;

import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 21.11.17.
 */

public interface EventListener {

    void update(@NonNull final String message);
}
