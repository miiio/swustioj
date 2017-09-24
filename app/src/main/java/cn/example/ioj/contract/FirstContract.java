package cn.example.ioj.contract;

/**
 * Created by L on 2017/9/22.
 */

public interface FirstContract {
    interface Model extends BaseContract.Model {
        boolean isFirst(); //是否第一次进入
        boolean isLogin(); //是否登陆过
        void setFirst(boolean is);
    }

    interface View extends BaseContract.View{
        void jumpToFirst();
        void jumpToHome();
        void jumpToLogin();
    }

    interface Presenter extends BaseContract.Presenter{
        void judgeJump(); //检查需要跳转的哪个界面
    }
}
