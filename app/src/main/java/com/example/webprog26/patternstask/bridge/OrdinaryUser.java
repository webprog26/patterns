package com.example.webprog26.patternstask.bridge;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.example.webprog26.patternstask.singleton_builder.User;

import java.util.UUID;

/**
 * Created by webprog26 on 20.11.17.
 */

public class OrdinaryUser implements UserInterface {

    @Override
    public User getUser(@NonNull String name, int age, @Nullable String eMail) {
        return User.getInstance().Builder()
                .setUserId(UUID.randomUUID())
                .setUserName(name)
                .setUserAge(age)
                .setUserEmail(eMail)
                .setIsPrivileged(false)
                .build();
    }
}
