package com.example.webprog26.patternstask.factory;

import com.example.webprog26.patternstask.factory.interfaces.FragmentFactory;
import com.example.webprog26.patternstask.fragments.AdapterFragment;
import com.example.webprog26.patternstask.fragments.BridgeFragment;
import com.example.webprog26.patternstask.fragments.DecoratorFragment;
import com.example.webprog26.patternstask.fragments.ObserverFragment;
import com.example.webprog26.patternstask.fragments.SingletonBuilderFragment;
import com.example.webprog26.patternstask.fragments.VisitorFragment;
import com.example.webprog26.patternstask.template.BaseFragment;
import com.example.webprog26.patternstask.fragments.FactoryFragment;

/**
 * Created by webprog26 on 20.11.17.
 */

public class FragmentFactoryImpl implements FragmentFactory {

    private static FragmentFactory instance = new FragmentFactoryImpl();

    public static FragmentFactory getInstance() {
        return instance;
    }

    @Override
    public BaseFragment getBaseFragment(int fragmentId) throws IllegalArgumentException{
        switch (fragmentId) {
            case FACTORY_FRAGMENT_ID:
                return new FactoryFragment();
            case SINGLETON_BUILDER_FRAGMENT_ID:
                return new SingletonBuilderFragment();
            case BRIDGE_FRAGMENT_ID:
                return new BridgeFragment();
            case OBSERVER_FRAGMENT_ID:
                return new ObserverFragment();
            case DECORATOR_FRAGMENT_ID:
                return new DecoratorFragment();
            case VISITOR_FRAGMENT_ID:
                return new VisitorFragment();
            case ADAPTER_FRAGMENT_ID:
                return new AdapterFragment();
            default:
                    throw new IllegalArgumentException("No appropriate fragment with such ID found");
        }
    }
}
