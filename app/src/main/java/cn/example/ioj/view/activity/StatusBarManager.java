package cn.example.ioj.view.activity;

import android.app.Activity;
import android.os.Build;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
/**
 * Created by L on 2017/9/22.
 */
public class StatusBarManager {

    private Activity activity;

    public StatusBarManager(Activity activity) {
        this.activity = activity;
    }

    /**
     * 设置状态栏透明
     * 使用于非为DrawerLayout.当以图片作为背景时,图片会铺满全屏
     */
    public void setStatusBarTransparent() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //设置跟布局的参数,让布局从状态栏下方开始,而不是跟状态栏重合
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity
                    .findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(false);
            rootView.setClipToPadding(false);
        }
    }

    /**
     * 设置状态栏颜色
     * 适用于非DrawerLayout,布局包含toolbar时，可以将状态栏设置为何toolbar相同的颜色
     *
     * @param color 设置的状态栏的颜色ARGB值
     */
    public void setStatusBarColor(int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View statusView = createStatusBarView(color);  //生成一个和状态栏一样大小的View
            ViewGroup decorView = (ViewGroup) activity.getWindow().getDecorView(); //获取布局容器
            decorView.addView(statusView);  //添加View到布局中
            //设置跟布局的参数,让布局从状态栏下方开始,而不是跟状态栏重合
            ViewGroup rootView = (ViewGroup) ((ViewGroup) activity
                    .findViewById(android.R.id.content)).getChildAt(0);
            rootView.setFitsSystemWindows(true);
            rootView.setClipToPadding(true);
        }
    }

    /**
     * 设置状态栏透明
     * 适用于DrawerLayout
     *
     * @param drawerLayout drawerLayout
     */
    public void setStatusBarTransparentForDrawerLayout(DrawerLayout drawerLayout) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            // 设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            // 设置内容布局属性
            ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);
            contentLayout.setFitsSystemWindows(false);
            contentLayout.setClipToPadding(false);
            // 设置抽屉布局属性
            ViewGroup drawer = (ViewGroup) drawerLayout.getChildAt(1);
            drawer.setFitsSystemWindows(true);
            drawer.setClipToPadding(true);
            // 设置 DrawerLayout 属性
            drawerLayout.setFitsSystemWindows(false);
        }
    }

    /**
     * 设置状态栏颜色
     * 适用于DrawerLayout
     *
     * @param drawerLayout drawerLayout
     * @param color        设置的颜色值ARGB
     */
    public void setStatusBarColorForDrawerLayout(DrawerLayout drawerLayout, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //设置状态栏透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            View statusBarView = createStatusBarView(color); //生成一个和状态栏一样大小的View
            ViewGroup contentLayout = (ViewGroup) drawerLayout.getChildAt(0);       //获取布局容器
            contentLayout.addView(statusBarView, 0);                            //添加View到布局中
            // 内容布局不是 LinearLayout 时,设置padding top,避免布局和状态栏重叠
            if (!(contentLayout instanceof LinearLayout) && contentLayout.getChildAt(1) != null) {
                contentLayout.getChildAt(1).setPadding(0, getStatusBarHeight(), 0, 0);
            }
            // 设置属性
            ViewGroup drawer = (ViewGroup) drawerLayout.getChildAt(1);
            drawerLayout.setFitsSystemWindows(false);
            contentLayout.setFitsSystemWindows(false);
            contentLayout.setClipToPadding(true);
            drawer.setFitsSystemWindows(true);
            drawer.setClipToPadding(true);
        }
    }

    /**
     * 获取状态栏高度
     *
     * @return 状态栏高度
     */
    public int getStatusBarHeight() {
        int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return activity.getResources().getDimensionPixelSize(resourceId);
    }

    /**
     * 获取一个和状态栏大小相同的View
     *
     * @param color view的颜色,ARGB值
     * @return view
     */
    private View createStatusBarView(int color) {
        //绘制一个和状态栏大小相同的view
        View statusView = new View(activity);
        ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, getStatusBarHeight());
        statusView.setLayoutParams(params);
        statusView.setBackgroundColor(color);              //设置背景色
        return statusView;
    }


}