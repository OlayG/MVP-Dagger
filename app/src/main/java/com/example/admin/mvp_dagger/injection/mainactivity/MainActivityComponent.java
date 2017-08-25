package com.example.admin.mvp_dagger.injection.mainactivity;

import com.example.admin.mvp_dagger.view.mainactivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 8/21/2017.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);
}
