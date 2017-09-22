package cn.example.ioj.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import butterknife.BindView;
import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.contract.i.MainContract;
import cn.example.ioj.presenter.BasePresenter;
import cn.example.ioj.presenter.MainPresenter;
import cn.example.ioj.view.adapter.MainViewPagerAdapter;

/**
 * 主界面
 * <p>
 * Created by L on 2017/9/21.
 */

public class MainActivity extends BaseActivity implements MainContract.View, BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottombar_main)
    BottomNavigationBar bottombarMain;
    @BindView(R.id.relativelayout_main)
    RelativeLayout relativelayoutMain;
    @BindView(R.id.viewpager_main)
    ViewPager viewpagerMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();

        //setStatusBarTransparent();
    }

    private void initView() {
        //设置底栏
        bottombarMain
                .addItem(new BottomNavigationItem(R.drawable.ic_home_24dp, "首页"))
                .addItem(new BottomNavigationItem(R.drawable.ic_assignment_black_24dp, "题库"))
                .addItem(new BottomNavigationItem(R.drawable.ic_equalizer_black_24dp, "排名"))
                .addItem(new BottomNavigationItem(R.drawable.ic_person_black_24dp, "我"))
                .setMode(BottomNavigationBar.MODE_FIXED)
                .setInActiveColor(R.color.grey)
                .setActiveColor(R.color.green)
                .initialise();
        bottombarMain.setTabSelectedListener(this);
        bottombarMain.setFirstSelectedPosition(0);

        viewpagerMain.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));
        viewpagerMain.setCurrentItem(0);
    }

    @Override
    protected BasePresenter getPresenter() {
        return new MainPresenter(this);
    }


    @Override
    public void onTabSelected(int position) {
        switch (position) {
            case 0: //首页
                viewpagerMain.setCurrentItem(0);
                //getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_main,new HomeFragment()).commit();
                break;
            case 1: //题库

                viewpagerMain.setCurrentItem(1);
                //getSupportFragmentManager().beginTransaction().replace(R.id.framelayout_main,new ProblemsFragment()).commit();
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
