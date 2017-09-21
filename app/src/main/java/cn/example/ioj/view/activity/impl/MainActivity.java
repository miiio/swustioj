package cn.example.ioj.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.example.ioj.R;
import cn.example.ioj.presenter.impl.BasePresenter;
import cn.example.ioj.presenter.impl.MainActivityPresenter;
import cn.example.ioj.view.activity.i.IBaseActivity;

/**
 * 主界面
 *
 * Created by L on 2017/9/21.
 */

public class MainActivity extends BaseActivity implements IBaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MainActivityPresenter(this);
    }
}
