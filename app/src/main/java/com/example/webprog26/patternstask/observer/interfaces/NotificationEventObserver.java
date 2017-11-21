package com.example.webprog26.patternstask.observer.interfaces;

import android.support.annotation.NonNull;

import com.example.webprog26.patternstask.observer.AbstractEventObserver;

/**
 * Created by webprog26 on 21.11.17.
 */

public class NotificationEventObserver extends AbstractEventObserver {

    @Override
    public void register(@NonNull EventListener listener) {
        getEventListeners().add(listener);
    }

    @Override
    public void unregister(@NonNull EventListener listener) {
        getEventListeners().remove(listener);
    }

    @Override
    public void notifyListeners(@NonNull String updateMessage) {
        for(EventListener eventListener: getEventListeners()) {
            eventListener.update(updateMessage);
        }
    }
}
