package cn.example.ioj.contract.i;

/**
 * Created by L on 2017/9/22.
 */

public interface BaseContract {
    interface Model{
    }

    interface View{
        void showError(int code);
    }

    interface Presenter{
    }
}
