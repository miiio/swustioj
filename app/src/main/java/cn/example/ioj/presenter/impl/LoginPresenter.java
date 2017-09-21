package cn.example.ioj.presenter.impl;

import cn.example.ioj.model.impl.BaseModel;
import cn.example.ioj.presenter.i.ILoginPresenter;
import cn.example.ioj.view.activity.impl.LoginActivity;

/**
 * Created by Tolean on 2017/9/21.
 */

public class LoginPresenter extends BasePresenter<LoginActivity,BaseModel>implements ILoginPresenter {
    public LoginPresenter(LoginActivity mView) {
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
