package cn.example.ioj.contract;

import cn.example.ioj.bean.BannerData;
import cn.example.ioj.bean.ProblemBean;
import cn.example.ioj.bean.ProblemsList;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

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
    Call<BannerData> loadBannerData();


    @FormUrlEncoded()
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

    @FormUrlEncoded()
    @POST("problem/info/")
    Call<ProblemBean> loadProblemInfo(
            @Field("_id")String id
    );


}
