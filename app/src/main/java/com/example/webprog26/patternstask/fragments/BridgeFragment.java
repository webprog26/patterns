package com.example.webprog26.patternstask.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;

import com.example.webprog26.patternstask.ActivityCallback;
import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.bridge.OrdinaryUser;
import com.example.webprog26.patternstask.bridge.PrivilegedUser;
import com.example.webprog26.patternstask.bridge.UserBridge;
import com.example.webprog26.patternstask.singleton_builder.User;
import com.example.webprog26.patternstask.template.OnClickFragment;

import butterknife.BindView;

/**
 * Created by webprog26 on 20.11.17.
 */

public class BridgeFragment extends OnClickFragment{

    private ActivityCallback activityCallback;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof ActivityCallback) {
            activityCallback = (ActivityCallback) context;
        }
    }

    @BindView(R.id.btn_ordinary_user)
    Button mBtnOrdinaryUser;

    @BindView(R.id.btn_privileged_user)
    Button mBtnPrivilegedUser;

    @Override
    protected int getLayoutResId() {
        return R.layout.bridge_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnOrdinaryUser.setOnClickListener(this);
        mBtnPrivilegedUser.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        final User user = User.getInstance();

        if(user.getUserName() != null) {

            UserBridge userBridge = null;

            switch (view.getId()) {
                case R.id.btn_ordinary_user:
                        userBridge = new UserBridge(new OrdinaryUser(), user.getUserName(), user.getUserAge(), user.getUserEmail());
                        break;
                case R.id.btn_privileged_user:
                        userBridge = new UserBridge(new PrivilegedUser(), user.getUserName(), user.getUserAge(), user.getUserEmail());
                        break;
            }

            if(userBridge != null) {
                final Activity activity = getActivity();

                if(activity != null) {
                    userBridge.compileUser(activity);
                }
            }
        }

        Snackbar.make(((View)view.getParent()), R.string.user_not_found, Snackbar.LENGTH_LONG)
                .setAction(R.string.create_user, new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(activityCallback != null) {
                            activityCallback.setCreateUserFragment();
                        }
                    }
                }).show();
    }
}
