package cn.example.ioj.presenter.impl;

import cn.example.ioj.model.i.IBaseModel;
import cn.example.ioj.model.impl.BaseModel;
import cn.example.ioj.presenter.i.IBaseFragmentPresenter;
import cn.example.ioj.view.fragment.i.IBaseFragment;
import cn.example.ioj.view.fragment.impl.BaseFragment;

/**
 * Created by L on 2017/9/21.
 */

public abstract class BaseFragmentPresenter
        <F extends BaseFragment & IBaseFragment, M extends BaseModel & IBaseModel>
        implements IBaseFragmentPresenter{

    F mFragment;
    M mModel;

    public BaseFragmentPresenter(F fragment){
        mFragment = fragment;
        mModel = getModel();
    }



    protected abstract M getModel();

    public void setFragment(F fragment) {this.mFragment = fragment;}
}