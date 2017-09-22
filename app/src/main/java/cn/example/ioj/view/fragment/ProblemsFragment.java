package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.example.ioj.R;
import cn.example.ioj.contract.i.ProblemsContract;
import cn.example.ioj.presenter.BaseFragmentPresenter;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsFragment extends BaseFragment implements ProblemsContract.View {
    View fragmentRootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_problems,container,false);


        return fragmentRootView;

    }

    @Override
    public void showError(int code) {

    }

    @Override
    protected BaseFragmentPresenter getPresenter() {
        return null;
    }
}
