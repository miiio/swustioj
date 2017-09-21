package cn.example.ioj.view.activity.i;

/**
 * Activity需要实现的接口的父接口
 * Presenter通过Activity实现的接口来回调
 *
 * Created by wax on 2017/9/21.
 */

public interface IBaseActivity {
    void showError(int code);
}
