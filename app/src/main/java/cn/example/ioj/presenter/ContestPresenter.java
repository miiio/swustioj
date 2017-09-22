package cn.example.ioj.presenter;

import cn.example.ioj.contract.ContestContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.model.ContestModel;
import cn.example.ioj.view.fragment.BaseFragment;

/**
 *
 * Created by L on 2017/9/22.
 */

public class ContestPresenter extends BaseFragmentPresenter implements ContestContract.Presenter {
    public ContestPresenter(BaseFragment fragment) {
        super(fragment);
    }

    @Override
    protected BaseModel getModel() {
        return new ContestModel();
    }
}
