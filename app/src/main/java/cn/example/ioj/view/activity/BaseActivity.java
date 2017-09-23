package cn.example.ioj.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;

import cn.example.ioj.R;
import cn.example.ioj.contract.BaseContract;
import cn.example.ioj.presenter.BasePresenter;

/**
 * Activity的基类
 *
 * 泛型<P extends BasePresenter & {@link BaseContract.cn.example.ioj.contract.i.BaseContract.Presenter}>是Activity对应的Presenter的类型
 * Presenter都继承于BasePresenter,在Activity的onDestroy()方法会调用BasePresenter的onDestroy()方法
 * 以此来销毁Presenter所持有的Activity对象
 * Presenter都应该实现的IBasePresenter接口的子接口,Activity通过接口来调用Presenter中的方法来获取数据
 *
 * Created by wax on 2017/9/21.
 */

public abstract class BaseActivity<P extends BasePresenter & BaseContract.Presenter>
        extends AppCompatActivity{

    protected P mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityManager.getActivityManager().pushActivity(this); //将activity压栈
        mPresenter = getPresenter(); //得到presenter
    }

    @Override
    public void finish() {
        ActivityManager.getActivityManager().popActivity(); //activity在finish时出栈
        super.finish();
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
        super.onDestroy();
    }


    /**
     * 设置状态栏透明,适用于非DrawerLayout
     */
    public void setStatusBarTransparent() {
        new StatusBarManager(this).setStatusBarTransparent();
    }

    /**
     * 设置状态栏透明,适用于DrawerLayout
     *
     * @param drawerLayout drawerLayout
     */
    public void
    setStatusBarTransparent(DrawerLayout drawerLayout) {
        new StatusBarManager(this).setStatusBarTransparentForDrawerLayout(drawerLayout);
    }

    /**
     * 设置沉浸式状态栏(状态栏与Toolbar颜色相同)
     * 适用于非DrawerLayout
     */
    public void setStatusBarImmerse() {
//        if (getSupportActionBar() != null) {
//            getSupportActionBar().setBackgroundDrawable(new ColorDrawable(
//                    getResources().getColor(ThemeActivity.getThemeItem(this).mainColorId)));
//        }
//        new StatusBarManager(this)
//                .setStatusBarColor(ContextCompat.getColor(this, ThemeActivity.getThemeItem(this).mainColorId));
    }

    /**
     * 设置沉浸式状态栏(状态栏与Toolbar颜色相同)
     * 适用于非DrawerLayout
     * 需自己传入颜色
     */
    public void setStatusBarImmerse(int resourseId) {
        new StatusBarManager(this)
                .setStatusBarColor(ContextCompat.getColor(this, resourseId));
    }

    /**
     * 设置沉浸式状态栏(状态栏与Toolbar颜色相同)
     * 适用于DrawerLayout
     *
     * @param drawerLayout drawerLayout
     */
    public void setStatusBarImmerse(DrawerLayout drawerLayout) {
        new StatusBarManager(this).setStatusBarColorForDrawerLayout(drawerLayout
                , ContextCompat.getColor(this, R.color.colorPrimary));
    }

    /**
     * 返回activity对象的presenter , 子类只需要实现,不需要调用
     *
     * @return 返回的presenter对象
     */
    protected abstract P getPresenter();
}
