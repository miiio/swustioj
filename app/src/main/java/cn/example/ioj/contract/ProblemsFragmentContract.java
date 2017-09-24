package cn.example.ioj.contract;

/**
 * 题目与实验
 *
 * Created by L on 2017/9/22.
 */

public interface ProblemsFragmentContract {
    interface Model extends BaseContract.Model {
    }

    interface View extends BaseFragmentContract.View{
    }

    interface Presenter extends BaseFragmentContract.Presenter{
    }
}
