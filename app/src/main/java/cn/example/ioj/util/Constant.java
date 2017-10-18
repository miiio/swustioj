package cn.example.ioj.util;

/**
 * 常量值
 *
 * Created by L on 2017/9/22.
 */

public class Constant {
    public final static String ServerHost = "http://123.207.241.46/ioj/api/";
    public final static String OJServerHost = "http://acm.swust.edu.cn/";
    public final static String Csrftoken = "9ncByde5lp5i4fYYG5fPC1CMjLimE9fF";

    public final static String SharedPreferencesUser = "user";

    public final static int LoginDirect = 0; //使用保存过的密码登陆
    public final static int LoginUsePw = 1; //已经在loginActivity内登陆
    public final static int LoginAsTr = 2; //游客登陆模式

    public final static int Error_OJServerNetWorkError = 0; //OJ服务器网络错误
    public final static int Error_ServerNetWorkError = 1;  //服务器网络错误
}

