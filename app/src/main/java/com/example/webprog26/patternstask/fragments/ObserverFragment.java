package com.example.webprog26.patternstask.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.webprog26.patternstask.R;
import com.example.webprog26.patternstask.factory.EventObserverFactoryImpl;
import com.example.webprog26.patternstask.factory.interfaces.EventObserverFactory;
import com.example.webprog26.patternstask.observer.ObserverEventListener;
import com.example.webprog26.patternstask.observer.interfaces.EventListener;
import com.example.webprog26.patternstask.observer.interfaces.EventObserver;
import com.example.webprog26.patternstask.template.OnClickFragment;

import butterknife.BindView;

/**
 * Created by webprog26 on 21.11.17.
 */

public class ObserverFragment extends OnClickFragment {

    private final EventObserver mNotificationEventObserver = EventObserverFactoryImpl.getInstance().getEventObserver(EventObserverFactory.NOTIFICATIONS_OBSERVER_ID);
    private EventListener mNotificationEventListener;

    @BindView(R.id.text_input_message)
    TextInputLayout mTextInputMessage;

    @BindView(R.id.btn_send_notification)
    Button mBtnSendNotification;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNotificationEventListener = new ObserverEventListener(getActivity());
    }

    @Override
    public void onStart() {
        super.onStart();
        mNotificationEventObserver.register(mNotificationEventListener);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mBtnSendNotification.setOnClickListener(this);
    }

    @Override
    public void onStop() {
        super.onStop();
        mNotificationEventObserver.unregister(mNotificationEventListener);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_notification:

                final EditText editText = mTextInputMessage.getEditText();

                if(editText != null) {
                    mNotificationEventObserver.notifyListeners(editText.getText().toString());
                }
        }
    }

    @Override
    protected int getLayoutResId() {
        return R.layout.observer_fragment;
    }
}
