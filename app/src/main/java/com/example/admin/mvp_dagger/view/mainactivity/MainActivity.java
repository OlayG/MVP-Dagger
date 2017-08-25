package com.example.admin.mvp_dagger.view.mainactivity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.admin.mvp_dagger.R;
import com.example.admin.mvp_dagger.injection.mainactivity.DaggerMainActivityComponent;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {
    private static final String TAG = "MainActivity";
    @Inject
    MainActivityPresenter presenter;
    @BindView(R.id.etGetPerson)
    EditText etGetPerson;
    @BindView(R.id.tvDisplayPerson)
    TextView tvDisplayPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        DaggerMainActivityComponent.create().inject(this);


        presenter.setContext(this);
        presenter.attachView(this);
    }

    // MainActivityContract.View methods
    @Override
    public void showerror(String error) {

    }

    @Override
    public void isPersonSaved(boolean isSaved) {

        Log.d(TAG, "isPersonSaved: " + isSaved);
    }

    @Override
    public void sendPerson(String name) {

    }

    //Button OnClick Method
    public void DoMagic(View view) {

        switch (view.getId()) {

            case R.id.btnGetPerson:
                //tvDisplayPerson.setText();
                presenter.getPerson();
                break;

            case R.id.btnSendPerson:
                presenter.savePerson(etGetPerson.getText().toString());
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.removeView();
    }
}
