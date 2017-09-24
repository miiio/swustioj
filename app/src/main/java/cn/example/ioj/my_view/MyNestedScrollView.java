package cn.example.ioj.my_view;

import android.content.Context;
import android.support.v4.widget.NestedScrollView;
import android.util.AttributeSet;

/**
 * Created by wax on 2017/9/3.
 */

public class MyNestedScrollView extends NestedScrollView{
    public void setMyNestedScrollViewScrollChangeListen(MyNestedScrollViewScrollChangeListen myNestedScrollViewScrollChangeListen) {
        this.myNestedScrollViewScrollChangeListen = myNestedScrollViewScrollChangeListen;
    }

    private MyNestedScrollViewScrollChangeListen myNestedScrollViewScrollChangeListen;
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
        public void onScrollChange(int scrollX, int scrollY, int oldscrollX, int oldscrollY);
    }


    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        if(myNestedScrollViewScrollChangeListen!=null) {
            myNestedScrollViewScrollChangeListen.onScrollChange(l, t, oldl, oldt);
        }
    }
}
