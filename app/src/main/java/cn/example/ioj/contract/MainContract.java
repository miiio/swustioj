package cn.example.ioj.contract;

/**
 * Created by L on 2017/9/22.
 */

public interface MainContract {
    interface Model extends BaseContract.Model{
    }

    interface View extends BaseContract.View{
        void showError(int code);
    }

    interface Presenter extends BaseContract.Presenter{
    }
}
