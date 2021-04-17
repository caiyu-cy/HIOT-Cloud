package com.example.hiotclound.test.mvptest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.hiotclound.R;
import com.example.hiotclound.base.BaseActivity;
import com.example.hiotclound.test.dagger2test.DaggerPresenterComponent;
import com.example.hiotclound.test.dagger2test.PresenterComponent;
import com.example.hiotclound.test.mvptest.model.User;

import javax.inject.Inject;

public class TsetMVPActivity extends BaseActivity<TestView, TestPresenter> implements  TestView{

    @Inject
    TestPresenter  presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        getComponent().inject(this);
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tset_mvp);
        final EditText etUserName =  findViewById(R.id.et_user_name);
        final EditText etPassword = findViewById(R.id.et_password);
        Button btnLogin = findViewById(R.id.btn_login);
        final User user = new User();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user.setUserName(etUserName.getText().toString());
                user.setPassword(etPassword.getText().toString());
                presenter.login(user);
            }
        });
    }


    @Override
    public TestPresenter createPresenter() {
        return presenter;
    }


    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    /**
     * 创建注入器
     * @return
     */

    public PresenterComponent getComponent(){
        return DaggerPresenterComponent.builder().build();
    }
}
