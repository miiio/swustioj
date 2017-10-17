package cn.example.ioj.view.activity;

import android.content.Intent;
import android.os.Bundle;

import cn.example.ioj.contract.FirstContract;
import cn.example.ioj.presenter.FirstPresenter;
import cn.example.ioj.util.Constant;

/**
 * 首屏界面
 *
 * Created by wax on 2017/9/21.
 */

public class FirstActivity extends BaseActivity<FirstPresenter> implements FirstContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mPresenter.judgeJump();
    }

    @Override
    protected FirstPresenter getPresenter() {
        return new FirstPresenter(this);
    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void jumpToFirst() {
        //setContentView(R.layout.activity_first);
        jumpToLogin();
    }

    @Override
    public void jumpToHome() {
        //jumpToLogin();

        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("mode", Constant.LoginDirect);
        startActivity(intent);
        finish();
    }

    @Override
    public void jumpToLogin() {
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
