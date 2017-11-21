package com.example.webprog26.patternstask.observer.interfaces;

import android.support.annotation.NonNull;


/**
 * Created by webprog26 on 21.11.17.
 */

public interface EventObserver {

    void register(@NonNull final EventListener listener);
    void unregister(@NonNull final EventListener listener);
    void notifyListeners(@NonNull final String updateMessage);
}
