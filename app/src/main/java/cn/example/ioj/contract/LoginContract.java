package cn.example.ioj.contract;

import cn.example.ioj.bean.LoginResultBean;
import cn.example.ioj.bean.UserBean;

/**
 * Created by L on 2017/9/22.
 */

public interface LoginContract {
    interface Model extends BaseContract.Model {
        void login(String username, String passworld, NetWorkLoaderListener<LoginResultBean>listener);
        void login(NetWorkLoaderListener<LoginResultBean> listener);
        void loadUserInfo(NetWorkLoaderListener<UserBean> listener);
        void savePwInfo(String username, String passworld);
    }

    interface View extends BaseContract.View{
        void onLoginSucceed();
        void onLoginFailure(String errmsg);
    }

    interface Presenter extends BaseContract.Presenter{
        void login(String username, String passworld);
    }
}
