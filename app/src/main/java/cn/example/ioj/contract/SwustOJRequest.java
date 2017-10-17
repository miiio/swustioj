package cn.example.ioj.contract;

import cn.example.ioj.bean.LoginResultBean;
import cn.example.ioj.bean.ProblemsList;
import cn.example.ioj.bean.RankListInfo;
import cn.example.ioj.bean.UserBean;
import cn.example.ioj.bean.UserProblemsBean;
import cn.example.ioj.util.Constant;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Streaming;

/**
 * 从oj服务器上获取数据
 *
 * Created by L on 2017/9/23.
 */

public interface SwustOJRequest {


    /**
     * 加载问题列表
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
     * 加载用户a题信息
     *
     * @return
     */
    @GET("user/jproblem/")
    Call<UserProblemsBean> loadUserProblemsInfo();

    /**
     * 用户登陆
     *
     * @param username
     * @param password
     * @param token
     * @return
     */
    @FormUrlEncoded()
    @Headers({"Cookie:csrftoken="+Constant.Csrftoken})
    @POST("user/ajaxlogin/")
    Call<LoginResultBean> login(@Field("username")String username,
                                @Field("password")String password,
                                @Field("csrfmiddlewaretoken")String token);


    /**
     * 加载基本信息
     *
     * @return
     */
    @GET("user/juserinfo/?operation=profile")
    Call<UserBean> loadUserInfo();

    /**
     * 加载排行榜
     *
     * @param username
     * @param page
     * @param range
     * @return
     */
    @GET("user/jranklist/")
    Call<RankListInfo> loadRankList(@Query("uchoice")String uchoick, @Query("username") String username, @Query("operation") String operation, @Query("page") int page, @Query("range") int range);

}
