package com.example.webprog26.patternstask.strategy.interfaces;

import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.view.View;

/**
 * Created by webprog26 on 20.11.17.
 */

public interface SetFragmentStrategy {

    String FACTORY_FRAGMENT_TAG = "factory_fragment_tag";
    String SINGLETON_BUILDER_FRAGMENT_TAG = "singleton_builder_fragment_tag";
    String BRIDGE_FRAGMENT_TAG = "bridge_fragment_tag";
    String OBSERVER_FRAGMENT_TAG = "observer_fragment_tag";
    String DECORATOR_FRAGMENT_TAG = "decorator_fragment_tag";
    String VISITOR_FRAGMENT_TAG = "visitor_fragment_tag";
    String ADAPTER_FRAGMENT_TAG = "adapter_fragment_tag";

    void setFragment(@NonNull final FragmentManager fragmentManager, final int id, @IdRes int parentLayoutRes, @Nullable final String tag);
}
