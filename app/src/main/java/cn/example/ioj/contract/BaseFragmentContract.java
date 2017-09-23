package cn.example.ioj.contract;

/**
 * Created by L on 2017/9/22.
 */

public interface BaseFragmentContract {
    interface Model{

    }

    interface View{
        void showError(int code);
    }

    interface Presenter{
    }
}
