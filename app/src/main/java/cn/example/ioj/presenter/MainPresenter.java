package cn.example.ioj.presenter;

import cn.example.ioj.IOJApplication;
import cn.example.ioj.bean.LoginResultBean;
import cn.example.ioj.bean.UserBean;
import cn.example.ioj.contract.MainContract;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.model.LoginModel;
import cn.example.ioj.model.MainActivityModel;
import cn.example.ioj.util.Constant;
import cn.example.ioj.util.OkHttpClientWithLogin;
import cn.example.ioj.view.activity.MainActivity;

/**
 * Created by L on 2017/9/21.
 */

public class MainPresenter extends BasePresenter<MainActivity,MainActivityModel> implements MainContract.Presenter {

    private LoginModel loginModel;
    public MainPresenter(MainActivity mView) {
        super(mView);

        loginModel = new LoginModel(mView);
    }

    @Override
    protected MainActivityModel getModel() {
        return null;
    }

    @Override
    public void loadUserInfo() {
        loginModel.loadUserInfo(new NetWorkLoaderListener<UserBean>() {
            @Override
            public void onSucceed(UserBean data) {
                ((IOJApplication)mView.getApplicationContext()).setUser(data);
                mView.onLoadUserInfo(data);
            }

            @Override
            public void onFailure(Throwable e) {
                mView.showError(Constant.Error_OJServerNetWorkError);
            }
        });
    }

    @Override
    public void mainLogin(int mode) {
        switch (mode){
            case Constant.LoginDirect: //使用保存过的密码登陆
                loginModel.login(new NetWorkLoaderListener<LoginResultBean>() {
                    @Override
                    public void onSucceed(LoginResultBean data) {
                        if(data.isCanlogin()){
                            ((IOJApplication)mView.getApplicationContext()).setSession(data.getSession());
                            OkHttpClientWithLogin.init(data.getSession(), Constant.Csrftoken);
                            loadUserInfo();
                        }else{
                            mView.showError(Constant.Error_OJServerNetWorkError);
                        }
                    }

                    @Override
                    public void onFailure(Throwable e) {
                        mView.showError(Constant.Error_OJServerNetWorkError);
                    }
                });
                break;
            case Constant.LoginUsePw: //已经在loginActivity内登陆
                //获取用户信息
                loadUserInfo();
                break;
            case Constant.LoginAsTr: //游客登陆模式
                OkHttpClientWithLogin.init("",Constant.Csrftoken);
                ((IOJApplication)mView.getApplicationContext()).setLogin(false);
                break;
        }
    }
}
