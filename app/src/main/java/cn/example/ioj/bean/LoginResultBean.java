package cn.example.ioj.bean;

/**
 * Created by L on 2017/9/24.
 */

public class LoginResultBean {
    /**
     * canlogin : false
     * errmsg : Gate error. Gate cann't get idstar.
     */

    private boolean canlogin;
    private String errmsg;

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    private String session;

    public boolean isCanlogin() {
        return canlogin;
    }

    public void setCanlogin(boolean canlogin) {
        this.canlogin = canlogin;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
