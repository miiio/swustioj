package cn.example.ioj.contract;


import cn.example.ioj.bean.ProblemBean;

/**
 * Created by Tolean on 2017/10/17.
 */

public interface ProblemInfoContract {
    interface Model extends BaseContract.Model{
    }

    interface View extends BaseContract.View{
        void onSuccessed(ProblemBean problem);
    }

    interface Presenter extends BaseContract.Presenter{
    }
}
