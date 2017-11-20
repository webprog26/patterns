package com.example.webprog26.patternstask.bridge;

import android.content.Context;
import android.support.annotation.NonNull;

/**
 * Created by webprog26 on 20.11.17.
 */

public abstract class AbstractUser {

    protected final UserInterface mUserInterface;

    public AbstractUser(UserInterface mUserInterface) {
        this.mUserInterface = mUserInterface;
    }

    public abstract void compileUser(@NonNull final Context context);
}
