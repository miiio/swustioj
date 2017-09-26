package cn.example.ioj.presenter;

import cn.example.ioj.contract.SearchContract;
import cn.example.ioj.model.BaseModel;
import cn.example.ioj.view.activity.BaseActivity;

/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchPresenter extends BasePresenter implements SearchContract.Presenter {
    public SearchPresenter(BaseActivity mView) {
        super(mView);
    }

    @Override
    protected BaseModel getModel() {
        return null;
    }
}
