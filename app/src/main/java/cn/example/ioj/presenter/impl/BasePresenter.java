package cn.example.ioj.presenter.impl;

import cn.example.ioj.model.i.IBaseModel;
import cn.example.ioj.model.impl.BaseModel;
import cn.example.ioj.view.activity.i.IBaseActivity;
import cn.example.ioj.view.activity.impl.BaseActivity;

/**
 * 所有Presenter的父类
 * 对持有的Activity和Model的类型做了严格的限制!
 * 泛型<V extends BaseActivity & IBaseActivity>是其持有的Activity对象类型
 * 所持有的Activity都应该继承BaseActivity
 * 所持有的Activity都应该实现IBaseActivity 的子接口,以便于Presenter通过接口回调Activity的方法
 * 泛型<M extends BaseModel & IBaseModel>是其持有的Model对象
 * 所持有的的Model对象都应该继承BaseModel
 * 所持有的Model都应该实现IBaseModel的子接口,以便于Presenter通过接口调用Model的方法
 *
 * Created by L on 2017/9/21.
 */

public abstract class BasePresenter
        <V extends BaseActivity & IBaseActivity, M extends BaseModel & IBaseModel>{

    V mView;
    M mModel;

    public BasePresenter(V mView) {
        this.mView = mView;
        this.mModel = getModel();
    }



    /**
     * 将Activity对象置空,在Activity销毁时调用该方法,以便于回收
     */
    public void onDestroy() {
        mView = null;
        if (mModel != null) {
            mModel.onDestroy();
            mModel = null;
        }
    }


    /**
     * 获取Model对象 , 子类只需要实现，不需要调用
     *
     * @return
     */
    protected abstract M getModel();
}
