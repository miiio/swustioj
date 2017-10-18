package cn.example.ioj.model;

import cn.example.ioj.bean.ProblemBean;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.ProblemInfoContract;
import cn.example.ioj.contract.ServicesRequest;
import cn.example.ioj.util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tolean on 2017/10/17.
 */

public class ProblemInfoModel extends BaseModel implements ProblemInfoContract.Model {
    @Override
    public void onDestroy() {

    }

    @Override
    public void loadInfoOnMyService(String id, final NetWorkLoaderListener<ProblemBean> listener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.ServerHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ServicesRequest.class)
                .loadProblemInfo(id)
                .enqueue(new Callback<ProblemBean>() {
                    @Override
                    public void onResponse(Call<ProblemBean> call, Response<ProblemBean> response) {
                        if(response.body()!=null){
                            listener.onSucceed(response.body());
                        }else{
                            listener.onFailure(new NullPointerException());
                        }
                    }

                    @Override
                    public void onFailure(Call<ProblemBean> call, Throwable t) {
                        listener.onFailure(t);
                    }
                });
    }
}
