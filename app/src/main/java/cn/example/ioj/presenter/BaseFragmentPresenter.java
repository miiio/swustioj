package cn.example.ioj.presenter;

import cn.example.ioj.contract.i.BaseContract;
import cn.example.ioj.contract.i.BaseFragmentContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.view.fragment.BaseFragment;

/**
 * Created by L on 2017/9/21.
 */

public abstract class BaseFragmentPresenter
        <F extends BaseFragment & BaseFragmentContract.View, M extends BaseModel & BaseContract.Model>
        implements BaseFragmentContract.Presenter{

    F mFragment;
    M mModel;

    public BaseFragmentPresenter(F fragment){
        mFragment = fragment;
        mModel = getModel();
    }



    protected abstract M getModel();

    public void setFragment(F fragment) {this.mFragment = fragment;}
}
