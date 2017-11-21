package com.example.webprog26.patternstask.observer;

import android.content.Context;
import android.support.annotation.NonNull;

import com.example.webprog26.patternstask.observer.interfaces.EventListener;

/**
 * Created by webprog26 on 21.11.17.
 */

public class ObserverEventListener implements EventListener {

    private final Context mContext;

    public ObserverEventListener(Context context) {
        this.mContext = context;
    }

    @Override
    public void update(@NonNull String message) {
        NotificationSender.sendNotification(getContext(), message);
    }

    private Context getContext() {
        return mContext;
    }
}
