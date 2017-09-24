package cn.example.ioj.presenter;

import cn.example.ioj.contract.FirstContract;
import cn.example.ioj.model.FirstModel;
import cn.example.ioj.view.activity.FirstActivity;

/**
 * Created by L on 2017/9/21.
 */

public class FirstPresenter extends BasePresenter<FirstActivity,FirstModel> implements FirstContract.Presenter {
    public FirstPresenter(FirstActivity mView) {
        super(mView);
    }

    @Override
    protected FirstModel getModel() {
        return new FirstModel(mView);
    }

    @Override
    public void judgeJump() {
        if(mModel.isFirst()){
            mModel.setFirst(false);
            mView.jumpToFirst();
        }else if(mModel.isLogin()){
            mView.jumpToHome();
        }else{
            mView.jumpToLogin();
        }
    }
}
