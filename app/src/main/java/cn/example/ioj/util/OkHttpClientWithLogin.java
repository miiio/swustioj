package cn.example.ioj.util;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 一个单例的带session的httpclient
 *
 * Created by L on 2017/9/24.
 */

public class OkHttpClientWithLogin {
    private static OkHttpClientWithLogin okHttpClientWithLogin;
    private static ReadCookiesInterceptor readCookiesInterceptor;
    private static OkHttpClient.Builder httpClient;
    private static String session;
    private static String token;

    private OkHttpClientWithLogin(){

    }

    /**
     * 必须初始化
     *
     * @param session
     * @param token
     */
    public static void init(String session,String token){
        okHttpClientWithLogin = new OkHttpClientWithLogin();
        readCookiesInterceptor = new ReadCookiesInterceptor(session,token);

        OkHttpClientWithLogin.session = session;
        OkHttpClientWithLogin.token = token;
        okHttpClientWithLogin.httpClient = new OkHttpClient.Builder();
        okHttpClientWithLogin.httpClient.addInterceptor(readCookiesInterceptor);
    }

    public static OkHttpClient getOkHttpClientWithLogin(){
        if(okHttpClientWithLogin == null){
            init("",Constant.Csrftoken);
        }
        return okHttpClientWithLogin.httpClient.build();
    }
}



    class ReadCookiesInterceptor implements Interceptor {

        private String session;
        private String token;

        public ReadCookiesInterceptor(String session, String token) {
            this.session = session;
            this.token = token;
        }


        @Override
        public Response intercept(Chain chain) throws IOException {
            Request original = chain.request();
            //Cookie:sessionid=3c5uwq59dnkbnm1cw6mf5f0mxfr7ldls;
            // csrftoken=9ncByde5lp5i4fYYG5fPC1CMjLimE9fF
            Request request = original.newBuilder()
                    .header("Cookie", "sessionid="+this.session+";csrftoken="+this.token)
                    .method(original.method(), original.body())
                    .build();
            return chain.proceed(request);
        }
}
