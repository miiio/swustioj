package cn.example.ioj.contract;


import cn.example.ioj.bean.UserBean;

/**
 * Created by L on 2017/9/22.
 */

public interface MainContract {
    interface Model extends BaseContract.Model {
    }

    interface View extends BaseContract.View{
        void onLoadUserInfo(UserBean userBean);
    }

    interface Presenter extends BaseContract.Presenter{
        void loadUserInfo();
        void mainLogin(int mode);
    }
}
