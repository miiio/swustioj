package cn.example.ioj.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;


import cn.example.ioj.R;
import cn.example.ioj.presenter.impl.LoginPresenter;
import cn.example.ioj.view.activity.i.ILoginActivity;

/**
 * Created by Tolean on 2017/9/21.
 */

public class LoginActivity extends BaseActivity<LoginPresenter>implements ILoginActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected LoginPresenter getPresenter() {
        return new LoginPresenter(this);
    }

    /**
     * 初始化View
     */
    private void initView(){
        setContentView(R.layout.activity_login);
    }
}
