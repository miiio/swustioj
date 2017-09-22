package cn.example.ioj.presenter;

import cn.example.ioj.contract.i.ProblemsContract;
import cn.example.ioj.model.ProblemsModel;
import cn.example.ioj.view.fragment.ProblemsFragment;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsPresenter extends BaseFragmentPresenter<ProblemsFragment,ProblemsModel> implements ProblemsContract.Presenter {
    public ProblemsPresenter(ProblemsFragment fragment) {
        super(fragment);
    }

    @Override
    protected ProblemsModel getModel() {
        return null;
    }
}
