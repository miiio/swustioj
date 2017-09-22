package cn.example.ioj.model.i;

import cn.example.ioj.bean.BannerData;

/**
 * Created by L on 2017/9/21.
 */

public interface IHomeModel extends IBaseModel {
    void loadBeannerData(NetWorkLoaderListener<BannerData> listener);
}
