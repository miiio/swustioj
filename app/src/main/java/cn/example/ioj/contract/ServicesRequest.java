package cn.example.ioj.contract;

import cn.example.ioj.bean.BannerData;
import cn.example.ioj.bean.ProblemBean;
import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.bean.RankListInfo;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

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


    /**
     * 从服务器备份数据中获取问题列表
     *
     * @param token
     * @param id
     * @param title
     * @param source
     * @param cloud
     * @param page
     * @param COMBINE
     * @return
     */
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


    /**
     * 从服务器备份数据中获取问题信息
     *
     * @param id
     * @return
     */
    @FormUrlEncoded()
    @POST("problem/info/")
    Call<ProblemBean> loadProblemInfo(
            @Field("_id")String id
    );


    /**
     * 从服务器备份数据中获取排行榜
     *
     * @param username
     * @param page
     * @param range
     * @return
     */
    @GET("user/jranklist/")
    Call<RankListInfo> loadRankList(
            @Query("uchoice")String uchoick,
            @Query("username") String username,
            @Query("operation") String operation,
            @Query("page") int page,
            @Query("range") int range
    );


}
