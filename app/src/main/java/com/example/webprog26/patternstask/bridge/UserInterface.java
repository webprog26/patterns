package com.example.webprog26.patternstask.bridge;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.webprog26.patternstask.singleton_builder.User;

/**
 * Created by webprog26 on 20.11.17.
 */

public interface UserInterface {

    String DEBUG_TAG = "bridge_debug";

    User getUser(@NonNull final String name, final int age, @Nullable final String eMail);
}
