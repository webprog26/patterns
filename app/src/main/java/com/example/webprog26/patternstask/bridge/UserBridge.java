package com.example.webprog26.patternstask.bridge;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.example.webprog26.patternstask.factory.UserInfoAlertDialogFactoryImpl;

import java.util.UUID;

/**
 * Created by webprog26 on 20.11.17.
 */

public class UserBridge extends AbstractUser {

    private final String name;
    private final int age;
    private final String eMail;

    public UserBridge(UserInterface mUserInterface, String name, int age, String eMail) {
        super(mUserInterface);
        this.name = name;
        this.age = age;
        this.eMail = eMail;
    }

    @Override
    public void compileUser(@NonNull final Context context) {
        UserInfoAlertDialogFactoryImpl.getInstance()
                .getUserInfoAlertDialog().getUserInfoAlertDialog(mUserInterface.getUser(name, age, eMail), context)
                .show();
    }
}
