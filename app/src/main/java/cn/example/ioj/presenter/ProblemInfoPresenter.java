package cn.example.ioj.presenter;

import cn.example.ioj.contract.ProblemInfoContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.model.ProblemInfoModel;
import cn.example.ioj.view.activity.PromblemInfoActivity;

/**
 * Created by Tolean on 2017/10/17.
 */

public class ProblemInfoPresenter extends BasePresenter<PromblemInfoActivity,ProblemInfoModel> implements ProblemInfoContract.Presenter {
    public ProblemInfoPresenter(PromblemInfoActivity mView) {
        super(mView);
    }

    @Override
    protected ProblemInfoModel getModel() {
        return new ProblemInfoModel();
    }
}
