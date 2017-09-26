package cn.example.ioj.view.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import cn.example.ioj.R;
import cn.example.ioj.contract.SearchContract;
import cn.example.ioj.presenter.BasePresenter;
import cn.example.ioj.presenter.SearchPresenter;

/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchActivity extends BaseActivity implements SearchContract.View {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
    }

    @Override
    public void showError(int code) {

    }

    @Override
    protected BasePresenter getPresenter() {
        return new SearchPresenter(this);
    }
}
