package com.example.webprog26.patternstask.factory;

import com.example.webprog26.patternstask.factory.interfaces.UserInfoAlertDialog;
import com.example.webprog26.patternstask.factory.interfaces.UserInfoAlertDialogFactory;

/**
 * Created by webprog26 on 20.11.17.
 */

public class UserInfoAlertDialogFactoryImpl implements UserInfoAlertDialogFactory{

    private static UserInfoAlertDialogFactory instance = new UserInfoAlertDialogFactoryImpl();

    public static UserInfoAlertDialogFactory getInstance() {
        return instance;
    }

    @Override
    public UserInfoAlertDialog getUserInfoAlertDialog() {
        return new UserInfoAlertDialogImpl();
    }
}
