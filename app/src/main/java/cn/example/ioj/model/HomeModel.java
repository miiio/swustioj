package cn.example.ioj.model;

import cn.example.ioj.bean.BannerData;
import cn.example.ioj.contract.i.HomeContract;
import cn.example.ioj.contract.i.NetWorkLoaderListener;
import cn.example.ioj.contract.i.ServicesRequest;
import cn.example.ioj.util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by L on 2017/9/21.
 */

public class HomeModel extends BaseModel implements HomeContract.Model {


    @Override
    public void onDestroy() {

    }

    @Override
    public void loadBeannerData(final NetWorkLoaderListener<BannerData> listener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.ServerHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ServicesRequest.class).getBannerData().enqueue(new Callback<BannerData>() {
            @Override
            public void onResponse(Call<BannerData> call, Response<BannerData> response) {
                listener.onSucceed(response.body());
            }

            @Override
            public void onFailure(Call<BannerData> call, Throwable t) {
                listener.onFailure(t);
            }
        });



    }
}
