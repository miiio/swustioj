package cn.example.ioj.contract;

import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.presenter.BasePresenter;

/**
 * Created by Tolean on 2017/9/26.
 */

public interface SearchContract {
    interface Model extends BaseContract.Model {
        void loadSuggest(String keyword, NetWorkLoaderListener<ProblemsList> listener);
    }

    interface View extends BaseContract.View {
        void addPrblemsList(ProblemsList problemsList, boolean clean);
        void setLoading(boolean loding);
        void switchView(int view);
        void showSuggest(ProblemsList list);
    }

    interface Presenter extends BaseContract.Presenter {
        void loadSearchProblemList(int searchtype,String text,int page,boolean clean);
        void getSuggest(String keyword);
    }
}
