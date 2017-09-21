package cn.example.ioj.presenter.impl;

import cn.example.ioj.model.impl.MainActivityModel;
import cn.example.ioj.presenter.i.IMainActivityPresenter;
import cn.example.ioj.view.activity.impl.MainActivity;

/**
 * Created by L on 2017/9/21.
 */

public class MainActivityPresenter extends BasePresenter<MainActivity,MainActivityModel> implements IMainActivityPresenter{
    public MainActivityPresenter(MainActivity mView) {
        super(mView);
    }

    @Override
    protected MainActivityModel getModel() {
        return null;
    }
}
