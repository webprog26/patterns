package com.example.webprog26.patternstask.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.factory.UserInfoAlertDialogFactoryImpl;
import com.example.webprog26.patternstask.factory.interfaces.UserInfoAlertDialogFactory;
import com.example.webprog26.patternstask.singleton_builder.User;
import com.example.webprog26.patternstask.template.BaseFragment;
import com.example.webprog26.patternstask.template.OnClickFragment;

import java.util.UUID;

import butterknife.BindView;

/**
 * Created by webprog26 on 20.11.17.
 */

public class SingletonBuilderFragment extends OnClickFragment{

    private static final String DEBUG_TAG = "singletone_builder";

    @BindView(R.id.text_input_name)
    TextInputLayout mTextInputName;

    @BindView(R.id.text_input_age)
    TextInputLayout mTextInputAge;

    @BindView(R.id.text_input_email)
    TextInputLayout mTextInputInputEmail;

    @BindView(R.id.btn_build_user_instance)
    Button mBtnBuildUserInstance;

    @Override
    protected int getLayoutResId() {
        return R.layout.singleton_builder_fragment;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnBuildUserInstance.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_build_user_instance:
                User user = getUser();
                if(user != null) {
                    final Activity activity = getActivity();

                    if(activity != null) {
                        UserInfoAlertDialogFactoryImpl.getInstance()
                                .getUserInfoAlertDialog().getUserInfoAlertDialog(user, activity)
                                .show();
                    }
                }
                break;
        }
    }

    private User getUser(){
        User.Builder builder = User.getInstance().Builder();
        builder.setUserId(UUID.randomUUID());

        final EditText etName = mTextInputName.getEditText();
        final EditText etAge = mTextInputAge.getEditText();
        final EditText etEmail = mTextInputInputEmail.getEditText();

        final String userName = (etName != null) ? etName.getText().toString() : null;
        final String userAge = (etAge != null) ? etAge.getText().toString() : null;
        final String userEmail = (etEmail != null) ? etEmail.getText().toString() : null;

        if(userName != null && userName.length() > 0) {
            builder.setUserName(userName);
        } else {
            setFocus(mTextInputName.getEditText());
            return null;
        }

        if(userAge != null && userAge.length() > 0) {
            builder.setUserAge(Integer.parseInt(userAge));
        } else {
            setFocus(mTextInputAge.getEditText());
            return null;
        }

        if(userEmail != null && userEmail.length() > 0) {
            builder.setUserEmail(userEmail);
        }

        return builder.build();
    }

    private void setFocus(final EditText editText){
        if(editText.requestFocus()) {
            final Activity activity = getActivity();
            if(activity != null) {

                final Window window = activity.getWindow();
                if(window != null) {
                    window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
                }
            }
        }
    }
}
