package cn.example.ioj.model;

import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.contract.NetWorkLoaderListener;
import cn.example.ioj.contract.SearchContract;
import cn.example.ioj.contract.ServicesRequest;
import cn.example.ioj.util.Constant;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Tolean on 2017/9/26.
 */

public class SearchModel extends ProblemsListModel implements SearchContract.Model {
    @Override
    public void onDestroy() {

    }


    @Override
    public void loadSuggest(String keyword, final NetWorkLoaderListener<ProblemsList> listener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.ServerHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ServicesRequest.class)
                .loadTitleSuggest(keyword)
                .enqueue(new Callback<ProblemsList>() {
                    @Override
                    public void onResponse(Call<ProblemsList> call, Response<ProblemsList> response) {
                        if(response.body()!=null){
                            listener.onSucceed(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<ProblemsList> call, Throwable t) {
                        listener.onFailure(t);
                    }
                });
    }
}
