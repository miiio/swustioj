package cn.example.ioj.view.activity;

import android.app.Activity;

import java.util.Stack;

/**
 * Activity的管理类，维护一个Activity栈
 *
 * Created by wax on 2017/9/21.
 */

public class ActivityManager {
    private static ActivityManager mInstance; //单例实体
    private static Stack<Activity> mActivityStack;

    private ActivityManager(){
        mActivityStack = new Stack<>();
    }


    /**
     * 获取ActivityManager单例
     *
     * @return ActivityManager单例
     */
    public static ActivityManager getActivityManager(){
        if(mInstance == null){
            mInstance = new ActivityManager();
        }
        return mInstance;
    }

    /**
     * 获取栈顶添加activity
     *
     * @return 返回栈顶activity，空栈返回null
     */
    public static Activity peekActivity(){
        if(mActivityStack != null && !mActivityStack.empty()){
            return mActivityStack.peek();
        }else{
            return null;
        }
    }

    /**
     * 添加activity到栈顶
     *
     * @param activity 添加的activity
     */
    public static void pushActivity(Activity activity){
        if(mActivityStack == null){
            mActivityStack = new Stack<>();
        }
        mActivityStack.push(activity);
    }

    /**
     * 将栈顶出栈
     */
    public static void popActivity(){
        if (mActivityStack != null && !mActivityStack.isEmpty()) {
            mActivityStack.pop();
        }
        //如果移除一个activity之后栈为空,将本类的引用取消,以便于让虚拟机回收
        if (mActivityStack != null && mActivityStack.isEmpty()) {
            mInstance = null;
        }
    }
}
