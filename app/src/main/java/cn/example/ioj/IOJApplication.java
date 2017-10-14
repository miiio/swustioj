package cn.example.ioj;

import android.app.Application;

import cn.example.ioj.bean.UserBean;
import cn.example.ioj.bean.UserProblemsBean;

/**
 * Created by wax on 2017/9/21.
 */

public class IOJApplication extends Application {
    private String session; //保存登陆的session
    private UserBean user;
    private boolean isLogin; //是否已登录

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }

    public UserBean getUser() {
        return user;
    }

    public void setUser(UserBean user) {
        this.user = user;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

}
