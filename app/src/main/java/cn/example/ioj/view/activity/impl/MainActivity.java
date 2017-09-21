package cn.example.ioj.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import cn.example.ioj.R;
import cn.example.ioj.presenter.impl.BasePresenter;
import cn.example.ioj.presenter.impl.MainPresenter;
import cn.example.ioj.view.activity.i.IBaseActivity;

/**
 * 主界面
 *
 * Created by L on 2017/9/21.
 */

public class MainActivity extends BaseActivity implements IBaseActivity, BottomNavigationBar.OnTabSelectedListener {
    private BottomNavigationBar bottomNavigationBar; //底部导航栏
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        //设置底栏
        bottomNavigationBar = (BottomNavigationBar)findViewById(R.id.bottombar_main);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.ic_home_24dp,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assignment_black_24dp,"题库"))
                .addItem(new BottomNavigationItem(R.drawable.ic_equalizer_black_24dp,"排名"))
                .addItem(new BottomNavigationItem(R.drawable.ic_person_black_24dp,"我"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setInActiveColor(R.color.colorPrimary)
                .setActiveColor(R.color.green)
                .initialise();
        bottomNavigationBar.setTabSelectedListener(this);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MainPresenter(this);
    }



    @Override
    public void onTabSelected(int position) {

    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void showError(int code) {

    }
}
