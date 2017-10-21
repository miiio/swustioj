package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import cn.example.ioj.R;
import cn.example.ioj.presenter.BaseFragmentPresenter;

/**
 * Created by wax on 2017/10/21.
 */

public class RankFragment extends BaseFragment {
    private View fragmentRootView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_rank, container, false);


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
