package cn.example.ioj.model;

import android.content.Context;
import android.content.SharedPreferences;

import cn.example.ioj.bean.LoginResultBean;
import cn.example.ioj.bean.UserBean;
import cn.example.ioj.contract.LoginContract;
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
 * Created by L on 2017/9/24.
 */

public class LoginModel extends BaseModel implements LoginContract.Model {
    private Context context;
    public LoginModel(Context context) {
        this.context = context;
    }

    @Override
    public void login(String username, String passworld, final NetWorkLoaderListener<LoginResultBean> listener) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.OJServerHost)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(SwustOJRequest.class).login(username,passworld,Constant.Csrftoken)
                .enqueue(new Callback<LoginResultBean>() {
                    @Override
                    public void onResponse(Call<LoginResultBean> call, Response<LoginResultBean> response) {
                        if(response.body()!=null){
                            LoginResultBean loginResultBean = response.body();
                            String session = response.headers().get("Set-Cookie");
                            if(session==null){
                                listener.onFailure(new NullPointerException());
                            }else {
                                session = session.substring(10, session.length() - 18);
                                loginResultBean.setSession(session);
                                listener.onSucceed(loginResultBean);
                            }
                        }else{

                            listener.onFailure(new NullPointerException());
                        }
                    }

                    @Override
                    public void onFailure(Call<LoginResultBean> call, Throwable t) {
                        listener.onFailure(t);
                    }
                });
    }

    @Override
    public void login(NetWorkLoaderListener<LoginResultBean> listener) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SharedPreferencesUser,Context.MODE_PRIVATE);
        String username = sp.getString("username","");
        String passworld = sp.getString("passworld","");
        login(username,passworld,listener);
    }

    @Override
    public void loadUserInfo(final NetWorkLoaderListener<UserBean> listener) {
        SharedPreferences sp = context.getSharedPreferences(Constant.SharedPreferencesUser,Context.MODE_PRIVATE);
        String username = sp.getString("username","");
        String passworld = sp.getString("passworld","");


        Retrofit retrofit = new Retrofit.Builder().baseUrl(Constant.OJServerHost)
                .addConverterFactory(GsonConverterFactory.create())
                .client(OkHttpClientWithLogin.getOkHttpClientWithLogin())
                .build();
        retrofit.create(SwustOJRequest.class)
                .loadUserInfo()
                .enqueue(new Callback<UserBean>() {
                    @Override
                    public void onResponse(Call<UserBean> call, Response<UserBean> response) {
                        if(response.body()!=null){
                            listener.onSucceed(response.body());
                        }else{
                            listener.onFailure(new NullPointerException());
                        }
                    }

                    @Override
                    public void onFailure(Call<UserBean> call, Throwable t) {
                        listener.onFailure(t);
                    }
                });

    }

    @Override
    public void savePwInfo(String username, String passworld) {
        SharedPreferences sp = context.getSharedPreferences("user",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("username",username);
        editor.putString("passworld",passworld);
        editor.commit();
    }

    @Override
    public void onDestroy() {

    }
}
