package cn.example.ioj.contract;

import cn.example.ioj.bean.ProblemsList;

/**
 * Created by Tolean on 2017/9/26.
 */

public interface SearchContract {
    interface Model extends BaseContract.Model {

    }

    interface View extends BaseFragmentContract.View {
        void addPrblemsList(ProblemsList problemsList, boolean clean);
    }

    interface Presenter extends BaseFragmentContract.Presenter {
        public void loadSearchProblemList(int searchtype,int page,boolean clean);
    }
}
