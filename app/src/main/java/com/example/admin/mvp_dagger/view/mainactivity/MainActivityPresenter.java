package com.example.admin.mvp_dagger.view.mainactivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Admin on 8/21/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {

    private static final String TAG = "MainActivityPresenter";
    MainActivityContract.View view;
    Context context;

    public void attachView(MainActivityContract.View view) {
        // Add Context
        this.view = view;
    }

    public void removeView() {

    }

    @Override
    public void remoteView() {
        // Remove Context
        this.view = null;
    }

    @Override
    public void savePerson(String person) {
        Log.d(TAG, "savePerson: " + person);
        view.isPersonSaved(true);

        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("person", person);
        boolean isSaved = editor.commit();

        view.isPersonSaved(isSaved);
    }

    @Override
    public void getPerson() {

        SharedPreferences sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        view.sendPerson(sharedPreferences.getString("person", "none found"));
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }
}
