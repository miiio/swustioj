package cn.example.ioj.presenter;

import cn.example.ioj.contract.BaseContract;
import cn.example.ioj.contract.BaseFragmentContract;
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

    public void onDestroy() {
        mFragment = null;
        if (mModel != null) {
            mModel.onDestroy();
            mModel = null;
        }
    }


    protected abstract M getModel();

    public void setFragment(F fragment) {this.mFragment = fragment;}
}
