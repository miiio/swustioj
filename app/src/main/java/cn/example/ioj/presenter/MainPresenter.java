package cn.example.ioj.presenter;

import cn.example.ioj.contract.MainContract;
import cn.example.ioj.model.MainActivityModel;
import cn.example.ioj.view.activity.MainActivity;

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
