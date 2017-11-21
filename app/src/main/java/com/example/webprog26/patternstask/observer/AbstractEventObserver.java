package com.example.webprog26.patternstask.observer;

import android.support.annotation.NonNull;

import com.example.webprog26.patternstask.observer.interfaces.EventListener;
import com.example.webprog26.patternstask.observer.interfaces.EventObserver;

import java.util.ArrayList;

/**
 * Created by webprog26 on 21.11.17.
 */

public abstract class AbstractEventObserver implements EventObserver {

    private final ArrayList<EventListener> mEventListeners = new ArrayList<>();

    @Override
    public abstract void register(@NonNull EventListener listener);

    @Override
    public abstract void unregister(@NonNull EventListener listener);

    @Override
    public abstract void notifyListeners(@NonNull String updateMessage);

    protected ArrayList<EventListener> getEventListeners() {
        return mEventListeners;
    }
}
