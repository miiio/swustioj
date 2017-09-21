package cn.example.ioj.view.fragment.impl;

import cn.example.ioj.presenter.impl.HomePresenter;
import cn.example.ioj.view.fragment.i.IHomeFragment;

/**
 * Created by L on 2017/9/21.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeFragment {

    @Override
    protected HomePresenter getPresenter() {
        return null;
    }

    @Override
    public void showError(int code) {

    }
}
