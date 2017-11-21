package com.example.webprog26.patternstask.observer;

import android.app.NotificationManager;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import com.example.webprog26.patternstask.R;

/**
 * Created by webprog26 on 21.11.17.
 */

public class NotificationSender {

    private static final int OBSERVER_NOTIFICATION_ID = 1;

    public static void sendNotification(@NonNull final Context context, @NonNull final String message){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context)
                .setContentTitle(context.getResources().getString(R.string.observer_notification_title))
                .setSmallIcon(R.drawable.ic_action_name)
                .setContentText(message);

        NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        notificationManager.notify(OBSERVER_NOTIFICATION_ID, builder.build());
    }
}
