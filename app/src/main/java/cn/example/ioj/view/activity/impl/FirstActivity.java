package cn.example.ioj.view.activity.impl;

import android.content.Intent;
import android.os.Bundle;

import cn.example.ioj.R;
import cn.example.ioj.presenter.impl.FirstActivityPresenter;
import cn.example.ioj.view.activity.i.IFirstActivity;

/**
 * 首屏界面
 *
 * Created by wax on 2017/9/21.
 */

public class FirstActivity extends BaseActivity<FirstActivityPresenter> implements IFirstActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent); //直接跳转到MainActivity

    }

    @Override
    protected FirstActivityPresenter getPresenter() {
        return new FirstActivityPresenter(this);
    }
}
