package com.example.admin.mvp_dagger.injection.mainactivity;

import com.example.admin.mvp_dagger.view.mainactivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 8/21/2017.
 */
@Module
public class MainActivityModule {

    @Provides
    MainActivityPresenter providesMainActivityPresenter(){
        return new MainActivityPresenter();
    }
}
