package cn.example.ioj.contract;

/**
 * Created by L on 2017/9/22.
 */

public interface FirstContract {
    interface Model extends BaseContract.Model {
    }

    interface View extends BaseContract.View{
    }

    interface Presenter extends BaseContract.Presenter{
    }
}
