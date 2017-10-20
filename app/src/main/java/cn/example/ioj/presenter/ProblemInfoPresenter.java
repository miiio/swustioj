package cn.example.ioj.presenter;

import cn.example.ioj.bean.ProblemBean;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.ProblemInfoContract;
import cn.example.ioj.model.ProblemInfoModel;
import cn.example.ioj.util.Constant;

import cn.example.ioj.view.activity.ProblemInfoActivity;

/**
 * Created by Tolean on 2017/10/17.
 */

public class ProblemInfoPresenter extends BasePresenter<ProblemInfoActivity,ProblemInfoModel> implements ProblemInfoContract.Presenter {
    public ProblemInfoPresenter(ProblemInfoActivity mView) {
        super(mView);
    }

    @Override
    protected ProblemInfoModel getModel() {
        return new ProblemInfoModel();
    }

    @Override
    public void loadInfo(String id) {
        mModel.loadInfoOnMyService(id, new NetWorkLoaderListener<ProblemBean>() {
            @Override
            public void onSucceed(ProblemBean data) {
                mView.onSuccessed(data);
            }

            @Override
            public void onFailure(Throwable e) {
                mView.showError(Constant.Error_ServerNetWorkError);
            }
        });
    }
}
