package cn.example.ioj.contract;

/**
 * Created by L on 2017/9/22.
 */

public interface NetWorkLoaderListener<Bean> {
    void onSucceed(Bean data);
    void onFailure(Throwable e);
}
