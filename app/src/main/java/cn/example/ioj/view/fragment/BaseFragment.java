package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.example.ioj.contract.BaseFragmentContract;
import cn.example.ioj.presenter.BaseFragmentPresenter;

/**
 * Created by L on 2017/9/21.
 */

public abstract class BaseFragment<P extends BaseFragmentPresenter&BaseFragmentContract.Presenter>
        extends Fragment implements BaseFragmentContract.View{

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (mPresenter != null) {
            mPresenter.onDestroy();
            mPresenter = null;
        }
    }


    protected abstract P getPresenter();
}
