package cn.example.ioj.presenter;

import cn.example.ioj.bean.BannerData;
import cn.example.ioj.contract.HomeContract;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.model.HomeModel;
import cn.example.ioj.util.Constant;
import cn.example.ioj.view.fragment.HomeFragment;

/**
 * Created by L on 2017/9/21.
 */

public class HomePresenter extends BaseFragmentPresenter<HomeFragment,HomeModel> implements HomeContract.Presenter {
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
                mFragment.showError(Constant.Error_ServerNetWorkError);
            }
        });
    }
}
