package com.example.webprog26.patternstask.factory.interfaces;

import android.app.AlertDialog;
import android.content.Context;
import android.support.annotation.NonNull;


import com.example.webprog26.patternstask.singleton_builder.User;

/**
 * Created by webprog26 on 20.11.17.
 */

public interface UserInfoAlertDialog {

    AlertDialog getUserInfoAlertDialog(@NonNull final User user, @NonNull final Context context);
}
