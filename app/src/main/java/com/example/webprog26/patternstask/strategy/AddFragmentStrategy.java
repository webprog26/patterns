package com.example.webprog26.patternstask.strategy;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;

import com.example.webprog26.patternstask.factory.FragmentFactoryImpl;
import com.example.webprog26.patternstask.strategy.interfaces.SetFragmentStrategy;

/**
 * Created by webprog26 on 20.11.17.
 */

public class AddFragmentStrategy implements SetFragmentStrategy {

    @Override
    public void setFragment(@NonNull FragmentManager fragmentManager, int id, int parentLayoutRes, @Nullable String tag) {
        fragmentManager.beginTransaction().add(parentLayoutRes,
                FragmentFactoryImpl.getInstance().getBaseFragment(id),
                tag).commit();
    }
}
