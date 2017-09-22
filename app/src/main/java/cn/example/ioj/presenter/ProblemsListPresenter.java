package cn.example.ioj.presenter;

import cn.example.ioj.contract.ProblemsListContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.model.ProblemsListModel;
import cn.example.ioj.view.fragment.BaseFragment;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsListPresenter extends BaseFragmentPresenter implements ProblemsListContract.Presenter {
    public ProblemsListPresenter(BaseFragment fragment) {
        super(fragment);
    }

    @Override
    protected BaseModel getModel() {
        return new ProblemsListModel();
    }
}
