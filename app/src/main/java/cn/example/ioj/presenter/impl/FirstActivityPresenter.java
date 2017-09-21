package cn.example.ioj.presenter.impl;

import cn.example.ioj.model.impl.BaseModel;
import cn.example.ioj.presenter.i.IFirstActivityPresenter;
import cn.example.ioj.view.activity.impl.FirstActivity;

/**
 * Created by L on 2017/9/21.
 */

public class FirstActivityPresenter extends BasePresenter<FirstActivity,BaseModel> implements IFirstActivityPresenter {
    public FirstActivityPresenter(FirstActivity mView) {
        super(mView);
    }

    @Override
    protected BaseModel getModel() {
        return null;
    }
}
