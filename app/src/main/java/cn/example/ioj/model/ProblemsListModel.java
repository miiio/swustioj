package cn.example.ioj.model;

import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.ProblemsListContract;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.SwustOJRequest;
import cn.example.ioj.util.Constant;
import cn.example.ioj.util.OkHttpClientWithLogin;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsListModel extends BaseModel implements ProblemsListContract.Model {

    @Override
    public void onDestroy() {

    }

    @Override
    public void LoadProblemsListPage(int page, NetWorkLoaderListener<ProblemsList> listener) {
        LoadProblems("","","","",page,listener);
    }


    @Override
    public void LoadProblems(String prbid, String title, String source, String cloud, int page, final NetWorkLoaderListener<ProblemsList> listener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.OJServerHost)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientWithLogin.getOkHttpClientWithLogin())
                .build();
        retrofit.create(SwustOJRequest.class)
                .loadProblemsList(Constant.Csrftoken,
                        prbid,title,source,cloud,page,"COMBINE")
                .enqueue(new Callback<ProblemsList>() {
                    @Override
                    public void onResponse(Call<ProblemsList> call, Response<ProblemsList> response) {
                        listener.onSucceed(response.body());
                    }

                    @Override
                    public void onFailure(Call<ProblemsList> call, Throwable t) {
                        listener.onFailure(t);
                    }
                });
    }
}
