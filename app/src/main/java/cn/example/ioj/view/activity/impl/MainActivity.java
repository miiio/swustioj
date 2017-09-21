package cn.example.ioj.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.presenter.impl.BasePresenter;
import cn.example.ioj.presenter.impl.MainPresenter;
import cn.example.ioj.view.activity.i.IBaseActivity;
import cn.example.ioj.view.fragment.impl.HomeFragment;

/**
 * 主界面
 * <p>
 * Created by L on 2017/9/21.
 */

public class MainActivity extends BaseActivity implements IBaseActivity, BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.framelayout_main)
    FrameLayout framelayoutMain;
    @BindView(R.id.bottombar_main)
    BottomNavigationBar bottombarMain;
    @BindView(R.id.relativelayout_main)
    RelativeLayout relativelayoutMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

        setStatusBarTransparent();
    }

    private void initView() {
        //设置底栏
        bottombarMain
                .addItem(new BottomNavigationItem(R.drawable.ic_home_24dp,"首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assignment_black_24dp,"题库"))
                .addItem(new BottomNavigationItem(R.drawable.ic_equalizer_black_24dp,"排名"))
                .addItem(new BottomNavigationItem(R.drawable.ic_person_black_24dp,"我"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setInActiveColor(R.color.colorPrimary)
                .setActiveColor(R.color.green)
                .initialise();
        bottombarMain.setTabSelectedListener(this);
        bottombarMain.selectTab(0);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MainPresenter(this);
    }


    @Override
    public void onTabSelected(int position) {
        switch (position){
            case 0: //首页
                getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_main,new HomeFragment()).commit();
                break;
        }
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
