package cn.example.ioj.presenter;

import cn.example.ioj.contract.LoginContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.view.activity.LoginActivity;

/**
 * Created by Tolean on 2017/9/21.
 */

public class LoginPresenter extends BasePresenter<LoginActivity,BaseModel> implements LoginContract.Presenter {
    public LoginPresenter(LoginActivity mView) {
        super(mView);
    }

    @Override
    protected BaseModel getModel() {
        return null;
    }
}
