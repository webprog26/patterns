package com.example.webprog26.patternstask.factory.interfaces;

import com.example.webprog26.patternstask.observer.AbstractEventObserver;

/**
 * Created by webprog26 on 21.11.17.
 */

public interface EventObserverFactory {

    int NOTIFICATIONS_OBSERVER_ID = 0;

    AbstractEventObserver getEventObserver(final int id);
}
