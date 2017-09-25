package cn.example.ioj.contract;

import cn.example.ioj.bean.ProblemsList;

/**
 * 题目列表
 *
 * Created by L on 2017/9/22.
 */

public interface ProblemsListContract {
    interface Model extends BaseFragmentContract.Model {
        void LoadProblemsListPage(int page, NetWorkLoaderListener<ProblemsList> listener);
        void LoadProblems(String prbid,String title,String Source,String cloud, int page, NetWorkLoaderListener<ProblemsList> listener);
    }

    interface View extends BaseFragmentContract.View{
        void addPrblemsList(ProblemsList problemsList,boolean clean);
    }

    interface Presenter extends BaseFragmentContract.Presenter{
        void LoadProblemsListPage(int page,boolean clean);
    }
}
