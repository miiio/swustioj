package cn.example.ioj.presenter.impl;

import cn.example.ioj.model.impl.HomeModel;
import cn.example.ioj.presenter.i.IHomePresenter;
import cn.example.ioj.view.fragment.impl.HomeFragment;

/**
 * Created by L on 2017/9/21.
 */

public class HomePresenter extends BaseFragmentPresenter<HomeFragment,HomeModel> implements IHomePresenter {
    public HomePresenter(HomeFragment mView) {
        super(mView);
    }
    @Override
    protected HomeModel getModel() {
        return new HomeModel();
    }
}
