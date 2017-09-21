package cn.example.ioj.presenter.impl;

import cn.example.ioj.bean.BannerData;
import cn.example.ioj.model.i.NetWorkLoaderListener;
import cn.example.ioj.model.impl.HomeModel;
import cn.example.ioj.presenter.i.IHomePresenter;
import cn.example.ioj.view.fragment.impl.HomeFragment;

/**
 * Created by L on 2017/9/21.
 */

public class HomePresenter extends BaseFragmentPresenter<HomeFragment,HomeModel> implements IHomePresenter {
    public HomePresenter(HomeFragment mView) {
        super(mView);
    }
    @Override
    protected HomeModel getModel() {
        return new HomeModel();
    }

    /**
     *  加载Banner
     */
    @Override
    public void loadBanner() {
        mModel.loadBeannerData(new NetWorkLoaderListener<BannerData>() {
            @Override
            public void onSucceed(BannerData data) {
                mFragment.startBanner(data);
            }

            @Override
            public void onFailure(Throwable e) {

            }
        });
    }
}
