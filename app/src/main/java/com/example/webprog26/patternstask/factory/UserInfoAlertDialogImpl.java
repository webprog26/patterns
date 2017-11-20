package com.example.webprog26.patternstask.factory;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.factory.interfaces.UserInfoAlertDialog;
import com.example.webprog26.patternstask.singleton_builder.User;

/**
 * Created by webprog26 on 20.11.17.
 */

public class UserInfoAlertDialogImpl implements UserInfoAlertDialog {

    @Override
    public AlertDialog getUserInfoAlertDialog(@NonNull User user, @NonNull final Context context) {
        final View contentView = LayoutInflater.from(context).inflate(R.layout.user_info_alert_dialog, null);
        ((TextView) contentView.findViewById(R.id.tv_user_info)).setText(user.toString());
        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(context)
                .setTitle(R.string.user_info)
                .setIcon(R.drawable.android)
                .setView(contentView)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .setCancelable(true);
        return builder.create();
    }
}
