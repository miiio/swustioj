package cn.example.ioj;

import android.app.Application;

import cn.example.ioj.bean.UserBean;

/**
 * Created by wax on 2017/9/21.
 */

public class IOJApplication extends Application {
    private String session; //保存登陆的session
    private UserBean user;

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
