package cn.example.ioj.my_view;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by wax on 2017/9/3.
 */

public class MyNestedScrollView extends NestedScrollView{


    public void setMyNestedScrollViewScrollChangeListen(MyNestedScrollViewScrollChangeListen myNestedScrollViewScrollChangeListen) {
        this.myNestedScrollViewScrollChangeListen = myNestedScrollViewScrollChangeListen;
    }

    private MyNestedScrollViewScrollChangeListen myNestedScrollViewScrollChangeListen;

    public void setMyNestedInterceptTouchEvent(MyNestedInterceptTouchEvent myNestedInterceptTouchEvent) {
        this.myNestedInterceptTouchEvent = myNestedInterceptTouchEvent;
    }

    private MyNestedInterceptTouchEvent myNestedInterceptTouchEvent;
    public MyNestedScrollView(Context context) {
        super(context);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public interface MyNestedScrollViewScrollChangeListen{
        void onScrollChange(int scrollX, int scrollY, int oldscrollX, int oldscrollY);
    }
    public interface MyNestedInterceptTouchEvent{
        boolean onInterceptTouchEvent(MotionEvent ev);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(myNestedScrollViewScrollChangeListen!=null) {
            myNestedScrollViewScrollChangeListen.onScrollChange(l, t, oldl, oldt);
        }
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return (nestedScrollAxes & ViewCompat.SCROLL_AXIS_VERTICAL) != 0;
    }

    public void setmTopHeight(int mTopHeight) {
        this.mTopHeight = mTopHeight;
    }

    private int mTopHeight;

    @Override
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        boolean hiddenTop = dy > 0 && getScrollY() < mTopHeight;
        boolean showTop = dy < 0 && getScrollY() > 0 && !ViewCompat.canScrollVertically(target, -1);

        if (hiddenTop || showTop) {
            scrollBy(0, dy);
            consumed[1] = dy;
        }else {
            super.onNestedPreScroll(target, dx, dy, consumed);
        }
    }

    @Override
    public boolean onNestedPreFling(View target, float velocityX, float velocityY) {
        if (getScrollY() >= mTopHeight) return false;
        fling((int) velocityY);
        super.onNestedPreFling(target, velocityX, velocityY);
        return true;
    }
}
