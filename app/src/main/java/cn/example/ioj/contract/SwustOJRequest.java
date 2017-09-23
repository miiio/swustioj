package cn.example.ioj.contract;

import cn.example.ioj.bean.ProblemsList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * 从oj服务器上获取数据
 *
 * Created by L on 2017/9/23.
 */

public interface SwustOJRequest {

//    csrfmiddlewaretoken:BBIDEo60b6V9OIajiTSksqMfvkOp7xrL
//    _id:
//    title:
//    source:
//    cloud:
//    page:1
//    operation:COMBINE

    @FormUrlEncoded()
    @Headers({"Cookie:csrftoken=9ncByde5lp5i4fYYG5fPC1CMjLimE9fF"})
    @POST("problem/jlist/")
    Call<ProblemsList> loadProblemsList(
            @Field("csrfmiddlewaretoken") String token,
            @Field("_id")String id,
            @Field("title")String title,
            @Field("source")String source,
            @Field("cloud")String cloud,
            @Field("page")int page,
            @Field("operation")String COMBINE
            );

}
