package cn.example.ioj.presenter.impl;

import cn.example.ioj.contract.i.MainContract;
import cn.example.ioj.model.impl.MainActivityModel;
import cn.example.ioj.view.activity.impl.MainActivity;

/**
 * Created by L on 2017/9/21.
 */

public class MainPresenter extends BasePresenter<MainActivity,MainActivityModel> implements MainContract.Presenter {
    public MainPresenter(MainActivity mView) {
        super(mView);
    }

    @Override
    protected MainActivityModel getModel() {
        return null;
    }
}
