package com.example.admin.mvp_dagger;

/**
 * Created by Admin on 8/21/2017.
 */

public interface BasePresenter <V extends BaseView> {

    void attachView(V view);
    void remoteView();
}
