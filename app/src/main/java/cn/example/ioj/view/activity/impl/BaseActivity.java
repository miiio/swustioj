package cn.example.ioj.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import cn.example.ioj.presenter.i.IBasePresenter;
import cn.example.ioj.presenter.impl.BasePresenter;
import cn.example.ioj.view.activity.ActivityManager;

/**
 * Activity的基类
 *
 * 泛型<P extends BasePresenter & IBasePresenter>是Activity对应的Presenter的类型
 * Presenter都继承于BasePresenter,在Activity的onDestroy()方法会调用BasePresenter的onDestroy()方法
 * 以此来销毁Presenter所持有的Activity对象
 * Presenter都应该实现的IBasePresenter接口的子接口,Activity通过接口来调用Presenter中的方法来获取数据
 *
 * Created by wax on 2017/9/21.
 */

public abstract class BaseActivity<P extends BasePresenter & IBasePresenter>
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
     * 返回activity对象的presenter , 子类只需要实现,不需要调用
     *
     * @return 返回的presenter对象
     */
    protected abstract P getPresenter();
}
