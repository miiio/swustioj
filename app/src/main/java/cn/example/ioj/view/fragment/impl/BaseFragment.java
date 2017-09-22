package cn.example.ioj.view.fragment.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.example.ioj.presenter.i.IBaseFragmentPresenter;
import cn.example.ioj.presenter.impl.BaseFragmentPresenter;
import cn.example.ioj.view.fragment.i.IBaseFragment;

/**
 * Created by L on 2017/9/21.
 */

public abstract class BaseFragment<P extends BaseFragmentPresenter&IBaseFragmentPresenter>
        extends Fragment implements IBaseFragment{

    protected P mPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mPresenter = getPresenter();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    protected abstract P getPresenter();
}
