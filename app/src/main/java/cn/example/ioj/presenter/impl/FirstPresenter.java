package cn.example.ioj.presenter.impl;

import cn.example.ioj.model.impl.BaseModel;
import cn.example.ioj.presenter.i.IFirstPresenter;
import cn.example.ioj.view.activity.impl.FirstActivity;

/**
 * Created by L on 2017/9/21.
 */

public class FirstPresenter extends BasePresenter<FirstActivity,BaseModel> implements IFirstPresenter {
    public FirstPresenter(FirstActivity mView) {
        super(mView);
    }

    @Override
    protected BaseModel getModel() {
        return null;
    }

    @Override
    public void showError(int code) {

    }
}
