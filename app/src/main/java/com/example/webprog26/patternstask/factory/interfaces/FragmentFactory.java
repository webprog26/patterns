package com.example.webprog26.patternstask.factory.interfaces;

import com.example.webprog26.patternstask.template.BaseFragment;

/**
 * Created by webprog26 on 20.11.17.
 */

public interface FragmentFactory {

    int FACTORY_FRAGMENT_ID = 0;
    int SINGLETON_BUILDER_FRAGMENT_ID = 1;
    int BRIDGE_FRAGMENT_ID = 2;
    int OBSERVER_FRAGMENT_ID = 3;

    BaseFragment getBaseFragment(final int fragmentId);
}
