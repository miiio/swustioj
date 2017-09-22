package cn.example.ioj.contract.i;

import cn.example.ioj.bean.BannerData;

/**
 * Created by L on 2017/9/22.
 */

public interface HomeContract {
    interface Model extends BaseContract.Model {
        void loadBeannerData(NetWorkLoaderListener<BannerData> listener);
    }

    interface View extends BaseFragmentContract.View {
        void startBanner(BannerData bannerData);
    }

    interface Presenter extends BaseFragmentContract.Presenter {
        void loadBanner();
    }
}
