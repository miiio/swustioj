package cn.example.ioj.presenter;

import cn.example.ioj.contract.FirstContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.view.activity.FirstActivity;

/**
 * Created by L on 2017/9/21.
 */

public class FirstPresenter extends BasePresenter<FirstActivity,BaseModel> implements FirstContract.Presenter {
    public FirstPresenter(FirstActivity mView) {
        super(mView);
    }

    @Override
    protected BaseModel getModel() {
        return null;
    }
}
