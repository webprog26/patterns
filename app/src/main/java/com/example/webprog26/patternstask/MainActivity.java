package com.example.webprog26.patternstask;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.webprog26.patternstask.factory.interfaces.FragmentFactory;
import com.example.webprog26.patternstask.strategy.ReplaceFragmentStrategy;
import com.example.webprog26.patternstask.strategy.interfaces.SetFragmentStrategy;
import com.example.webprog26.patternstask.template.BaseActivity;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements ActivityCallback{

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.drawer)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.navigation_view)
    NavigationView mNavigationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setSupportActionBar(mToolbar);
        initNavigationDrawer();
        initNavigationView();
    }

    @NonNull
    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected int getContainerIdRes() {
        return R.id.fragment_container;
    }

    @NonNull
    @Override
    protected String getStartFragmentTag() {
        return SetFragmentStrategy.FACTORY_FRAGMENT_TAG;
    }

    @Override
    protected int getStartFragmentId() {
        return FragmentFactory.FACTORY_FRAGMENT_ID;
    }

    private void initNavigationDrawer(){
        final ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.open_drawer, R.string.close_drawer){
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    private void initNavigationView(){
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                mDrawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.factory:
                        return setAppropriateFragment(FragmentFactory.FACTORY_FRAGMENT_ID,
                                SetFragmentStrategy.FACTORY_FRAGMENT_TAG);
                    case R.id.singleton_builder:
                        return setAppropriateFragment(FragmentFactory.SINGLETON_BUILDER_FRAGMENT_ID,
                                SetFragmentStrategy.SINGLETON_BUILDER_FRAGMENT_TAG);
                    case R.id.bridge:
                        return setAppropriateFragment(FragmentFactory.BRIDGE_FRAGMENT_ID,
                                SetFragmentStrategy.BRIDGE_FRAGMENT_TAG);
                    case R.id.observer:
                        return setAppropriateFragment(FragmentFactory.OBSERVER_FRAGMENT_ID,
                                SetFragmentStrategy.OBSERVER_FRAGMENT_TAG);
                    case R.id.decorator:
                        return setAppropriateFragment(FragmentFactory.DECORATOR_FRAGMENT_ID,
                                SetFragmentStrategy.DECORATOR_FRAGMENT_TAG);
                    case R.id.visitor:
                        return setAppropriateFragment(FragmentFactory.VISITOR_FRAGMENT_ID,
                                SetFragmentStrategy.VISITOR_FRAGMENT_TAG);
                    case R.id.adapter:
                        return setAppropriateFragment(FragmentFactory.ADAPTER_FRAGMENT_ID,
                                SetFragmentStrategy.ADAPTER_FRAGMENT_TAG);
                    default:
                        return true;
                }
            }
        });
    }

    private boolean setAppropriateFragment(final int fragmentId, final String fragmentTag){
        if(fragmentId >= 0 && fragmentTag != null) {
            final SetFragmentStrategy strategy = new ReplaceFragmentStrategy();
            strategy.setFragment(getSupportFragmentManager(), fragmentId, getContainerIdRes(), fragmentTag);
            return true;
        }
        return false;
    }

    @Override
    public void setCreateUserFragment() {
        new ReplaceFragmentStrategy().setFragment(getSupportFragmentManager(),
                FragmentFactory.SINGLETON_BUILDER_FRAGMENT_ID,
                getContainerIdRes(),
                SetFragmentStrategy.SINGLETON_BUILDER_FRAGMENT_TAG);
    }
}
