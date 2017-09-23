package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cn.example.ioj.R;
import cn.example.ioj.bean.BannerData;
import cn.example.ioj.contract.HomeContract;
import cn.example.ioj.presenter.AboutMePresenter;

/**
 * Created by Tolean on 2017/9/22.
 */

public class AboutMeFragment extends BaseFragment<AboutMePresenter> implements HomeContract.View {
    private View fragmentRootView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_about_me, container, false);

        return fragmentRootView;
    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void startBanner(BannerData bannerData) {

    }

    @Override
    protected AboutMePresenter getPresenter() {
        return new AboutMePresenter(this);
    }
}
