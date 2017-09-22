package cn.example.ioj.view.fragment.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerListener;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.R;
import cn.example.ioj.bean.BannerData;
import cn.example.ioj.presenter.impl.HomePresenter;
import cn.example.ioj.util.BannerImageLoader;
import cn.example.ioj.view.fragment.i.IHomeFragment;

/**
 * Created by L on 2017/9/21.
 */

public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeFragment {
    @BindView(R.id.banner_home)
    Banner bannerHome;
    Unbinder unbinder;
    private View fragmentRootView;
    private BannerData mBannerData;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);


        mPresenter.loadBanner();
        return fragmentRootView;
    }

    @Override
    protected HomePresenter getPresenter() {
        return new HomePresenter(this);
    }

    @Override
    public void showError(int code) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    /**
     * 显示banner
     *
     * @param bannerData 要被显示的banner数据
     */
    @Override
    public void startBanner(BannerData bannerData) {
        this.mBannerData = bannerData;
        bannerHome.setImageLoader(new BannerImageLoader());
        List<String> images = new ArrayList<>();
        for(BannerData.BannerdataBean bannerdataBean : bannerData.getBannerdata()){
            images.add(bannerdataBean.getImage());
        }
        bannerHome.setImages(images);
        bannerHome.start();
        bannerHome.setOnBannerListener(new OnBannerListener() {
            @Override
            public void OnBannerClick(int position) {
                BannerData.BannerdataBean bannerdataBean = mBannerData.getBannerdata().get(position);
                if(bannerdataBean.getUrl()!=null && bannerdataBean.getUrl()!=""){
                    Log.v("url",bannerdataBean.getUrl());
                }
            }
        });
    }
}
