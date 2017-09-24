package cn.example.ioj.presenter;

import cn.example.ioj.IOJApplication;
import cn.example.ioj.bean.LoginResultBean;
import cn.example.ioj.contract.LoginContract;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.model.LoginModel;
import cn.example.ioj.util.Constant;
import cn.example.ioj.util.OkHttpClientWithLogin;
import cn.example.ioj.view.activity.LoginActivity;

/**
 * Created by Tolean on 2017/9/21.
 */

public class LoginPresenter extends BasePresenter<LoginActivity,LoginModel> implements LoginContract.Presenter {
    public LoginPresenter(LoginActivity mView) {
        super(mView);
    }

    @Override
    protected LoginModel getModel() {
        return new LoginModel(mView);
    }

    @Override
    public void login(final String username, final String passworld) {
        mModel.login(username, passworld, new NetWorkLoaderListener<LoginResultBean>() {
            @Override
            public void onSucceed(LoginResultBean data) {
                if(data.isCanlogin()){
                    ((IOJApplication)mView.getApplicationContext()).setSession(data.getSession());
                    OkHttpClientWithLogin.init(data.getSession(), Constant.Csrftoken);
                    mModel.savePwInfo(username,passworld);
                    mView.onLoginSucceed();
                }else{
                    mView.onLoginFailure(data.getErrmsg());
                }
            }

            @Override
            public void onFailure(Throwable e) {
                mView.showError(0);
            }
        });
    }
}
