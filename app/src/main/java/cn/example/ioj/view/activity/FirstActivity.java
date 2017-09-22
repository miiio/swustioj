package cn.example.ioj.view.activity;

import android.content.Intent;
import android.os.Bundle;

import cn.example.ioj.R;
import cn.example.ioj.contract.i.FirstContract;
import cn.example.ioj.presenter.FirstPresenter;

/**
 * 首屏界面
 *
 * Created by wax on 2017/9/21.
 */

public class FirstActivity extends BaseActivity<FirstPresenter> implements FirstContract.View{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
//        Intent intent = new Intent(this,MainActivity.class);
        Intent intent=new Intent(this,LoginActivity.class);
        startActivity(intent); //直接跳转到MainActivity

    }

    @Override
    protected FirstPresenter getPresenter() {
        return new FirstPresenter(this);
    }

    @Override
    public void showError(int code) {

    }
}
