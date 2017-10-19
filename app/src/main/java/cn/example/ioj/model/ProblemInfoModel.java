package cn.example.ioj.model;

import cn.example.ioj.bean.ProblemBean;
import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.ProblemInfoContract;
import cn.example.ioj.contract.SwustOJRequest;
import cn.example.ioj.util.Constant;
import cn.example.ioj.util.OkHttpClientWithLogin;
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
    public void loadProblem(String id) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.OJServerHost)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientWithLogin.getOkHttpClientWithLogin())
                .build();
        retrofit.create(SwustOJRequest.class)
                .loadProblem(id)
                .enqueue(new Callback<ProblemBean>() {

                    @Override
                    public void onResponse(Call<ProblemBean> call, Response<ProblemBean> response) {

                    }

                    @Override
                    public void onFailure(Call<ProblemBean> call, Throwable t) {

                    }
                });
    }
}
