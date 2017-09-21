package cn.example.ioj.model.i;

/**
 * Created by L on 2017/9/22.
 */

public interface NetWorkLoaderListener<Bean> {
    void onSucceed(Bean data);
    void onFailure(Throwable e);
}
