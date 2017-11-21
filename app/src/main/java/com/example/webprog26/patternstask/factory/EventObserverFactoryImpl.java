package com.example.webprog26.patternstask.factory;

import com.example.webprog26.patternstask.factory.interfaces.EventObserverFactory;
import com.example.webprog26.patternstask.observer.AbstractEventObserver;
import com.example.webprog26.patternstask.observer.interfaces.NotificationEventObserver;

/**
 * Created by webprog26 on 21.11.17.
 */

public class EventObserverFactoryImpl implements EventObserverFactory{

    private static final EventObserverFactory instance = new EventObserverFactoryImpl();

    public static EventObserverFactory getInstance() {
        return instance;
    }

    @Override
    public AbstractEventObserver getEventObserver(int id) {
        switch (id) {
            case NOTIFICATIONS_OBSERVER_ID:
                return new NotificationEventObserver();
            default:
                return null;
        }
    }
}
