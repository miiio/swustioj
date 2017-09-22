package cn.example.ioj.model.i;

import cn.example.ioj.bean.BannerData;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by L on 2017/9/22.
 */

public interface ServicesRequest {

    /**
     * 从服务器上获取banner数据
     *
     * @return
     */
    @GET("banner.php")
    Call<BannerData> getBannerData();
}
