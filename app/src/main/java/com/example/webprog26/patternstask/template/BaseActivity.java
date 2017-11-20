package com.example.webprog26.patternstask.template;

import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;

import com.example.webprog26.patternstask.strategy.AddFragmentStrategy;
import com.example.webprog26.patternstask.strategy.ReplaceFragmentStrategy;
import com.example.webprog26.patternstask.strategy.interfaces.SetFragmentStrategy;

import butterknife.ButterKnife;


/**
 * Created by webprog26 on 20.11.17.
 */

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
        setStartFragment(savedInstanceState);
    }

    @NonNull
    @LayoutRes
    protected abstract int getLayoutResId();

    @IdRes
    protected abstract int getContainerIdRes();

    @NonNull
    protected abstract String getStartFragmentTag();
    protected abstract int getStartFragmentId();

    private void setStartFragment(final Bundle savedInstanceState){
        SetFragmentStrategy fragmentStrategy;
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final String startFragmentTag = getStartFragmentTag();
        if(savedInstanceState == null) {
            BaseFragment baseFragment = (BaseFragment)
                    fragmentManager.findFragmentByTag(startFragmentTag);

            if(baseFragment == null) {
                fragmentStrategy = new AddFragmentStrategy();
            } else {
                fragmentStrategy = new ReplaceFragmentStrategy();
            }
            fragmentStrategy.setFragment(fragmentManager,
                    getStartFragmentId(),
                    getContainerIdRes(),
                    startFragmentTag);
        }
    }
}
