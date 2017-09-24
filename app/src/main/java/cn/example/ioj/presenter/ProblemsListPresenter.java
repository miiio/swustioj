package cn.example.ioj.presenter;

import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.ProblemsListContract;
import cn.example.ioj.model.ProblemsListModel;
import cn.example.ioj.util.Constant;
import cn.example.ioj.view.fragment.ProblemsListFragment;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsListPresenter extends BaseFragmentPresenter<ProblemsListFragment,ProblemsListModel> implements ProblemsListContract.Presenter {
    public ProblemsListPresenter(ProblemsListFragment fragment) {
        super(fragment);
    }

    @Override
    protected ProblemsListModel getModel() {
        return new ProblemsListModel();
    }

    @Override
    public void LoadProblemsListPage(int page) {
        mModel.LoadProblemsListPage(1, new NetWorkLoaderListener<ProblemsList>() {
            @Override
            public void onSucceed(ProblemsList data) {
                mFragment.addPrblemsList(data,true);
            }

            @Override
            public void onFailure(Throwable e) {
                mFragment.showError(Constant.Error_OJServerNetWorkError);
            }
        });
    }
}
