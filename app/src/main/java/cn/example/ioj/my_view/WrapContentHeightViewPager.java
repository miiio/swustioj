package cn.example.ioj.my_view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * 解决ViewPager高度不能自适应的问题
 *
 * Created by wax on 2017/10/14.
 */

public class WrapContentHeightViewPager extends ViewPager {
    private static final String TAG = "WrapContentHeightViewPager";


    public WrapContentHeightViewPager(Context context) {
        super(context);
    }

    public WrapContentHeightViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);

    }


}