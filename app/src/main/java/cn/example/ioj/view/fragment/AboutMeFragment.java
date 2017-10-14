package cn.example.ioj.view.fragment;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.jaeger.library.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.IOJApplication;
import cn.example.ioj.R;
import cn.example.ioj.bean.UserBean;
import cn.example.ioj.contract.AboutMeContract;
import cn.example.ioj.my_view.MyNestedScrollView;
import cn.example.ioj.presenter.AboutMePresenter;
import cn.example.ioj.view.adapter.AboutMeViewPagerAdapter;
import jp.wasabeef.glide.transformations.BlurTransformation;

/**
 * Created by Tolean on 2017/9/22.
 */

public class AboutMeFragment extends BaseFragment<AboutMePresenter> implements AboutMeContract.View {

    @BindView(R.id.img_me_topBg)
    ImageView imgMeTopBg;
    @BindView(R.id.img_me_image)
    ImageView imgMeImage;
    @BindView(R.id.Linearlayout_me_top)
    LinearLayout LinearlayoutMeTop;
    @BindView(R.id.nsvScrollview_me)
    MyNestedScrollView nsvScrollviewMe;
    @BindView(R.id.img_me_barBg)
    ImageView imgMeBarBg;
    @BindView(R.id.toolbar_me)
    Toolbar toolbarMe;
    Unbinder unbinder;
    @BindView(R.id.tv_me_username)
    TextView tvMeUsername;
    @BindView(R.id.tv_me_acnum)
    TextView tvMeAcnum;
    @BindView(R.id.tablayout_me)
    TabLayout tablayoutMe;
    @BindView(R.id.viewpager_me)
    ViewPager viewpagerMe;
    private View fragmentRootView;

    private UserBean mUserBean;


    private int slidingDistance;
    private int imageBgHeight;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_about_me, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);
        if(((IOJApplication)getActivity().getApplicationContext()).isLogin()) {
            mUserBean = ((IOJApplication) getActivity().getApplicationContext()).getUser();
            initView();
        }
        return fragmentRootView;
    }


    private void initView() {
        //tablayout
        viewpagerMe.setAdapter(new AboutMeViewPagerAdapter(getFragmentManager()));
        tablayoutMe.setupWithViewPager(viewpagerMe);

        tvMeUsername.setText(mUserBean.getUsername());
        tvMeAcnum.setText("解决 " + mUserBean.getProblemsInfo().getNum_ac() + " | 挑战中" + " " + mUserBean.getProblemsInfo().getNum_ch()
                + " | 排名 " + mUserBean.getRank());

        Glide.with(this).load(mUserBean.getAvatar()).into(imgMeImage);
        Glide.with(this)
                .load(mUserBean.getAvatar())
                .bitmapTransform(new BlurTransformation(getActivity(), 20, 3))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        return false;
                    }
                })
                .into(imgMeTopBg);

        Glide.with(this)
                .load(mUserBean.getAvatar())
                .bitmapTransform(new BlurTransformation(getActivity(), 20, 3))
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        imgMeBarBg.setImageAlpha(0);
                        return false;
                    }
                }).into(imgMeBarBg);

        int toolbarHeight = toolbarMe.getLayoutParams().height;

        int headerBgHeight = toolbarHeight + getStatusBarHeight(getActivity());
        LinearlayoutMeTop.setPadding(0, headerBgHeight + 10, 0, 0);
        // 使背景图向上移动到图片的最底端，保留toolbar+状态栏的高度
        ViewGroup.LayoutParams params = imgMeBarBg.getLayoutParams();
        ViewGroup.MarginLayoutParams ivTitleHeadBgParams = (ViewGroup.MarginLayoutParams) imgMeBarBg.getLayoutParams();
        int marginTop = params.height - headerBgHeight;
        ivTitleHeadBgParams.setMargins(0, -marginTop, 0, 0);
        imgMeBarBg.setVisibility(View.VISIBLE);

        // 设置状态栏透明
        toolbarMe.setBackgroundColor(Color.TRANSPARENT);
        StatusBarUtil.setTranslucentForImageView(getActivity(), 0, toolbarMe);

        ViewGroup.LayoutParams imgItemBgparams = imgMeTopBg.getLayoutParams();
        // 获得高斯图背景的高度
        imageBgHeight = imgItemBgparams.height;

        // 监听改变透明度
        initScrollViewListener();
    }


    private void initScrollViewListener() {
        final int titleBarAndStatusHeight = toolbarMe.getLayoutParams().height + getStatusBarHeight(getActivity());
        slidingDistance = imageBgHeight - titleBarAndStatusHeight;

        nsvScrollviewMe.setMyNestedScrollViewScrollChangeListen(new MyNestedScrollView.MyNestedScrollViewScrollChangeListen() {
            @Override
            public void onScrollChange(int scrollX, int scrollY, int oldscrollX, int oldscrollY) {
                //根据页面滑动距离改变Header透明度
                if (scrollY < 0) {
                    scrollY = 0;
                }
                float alpha = scrollY * 1.0f / (slidingDistance);
                Drawable drawable = imgMeBarBg.getDrawable();
                //Log.v("v",scrollY+" "+slidingDistance);
                if (drawable != null) {
                    if (scrollY <= slidingDistance) {
                        //渐变
                        drawable.mutate().setAlpha((int) (alpha * 255));
                        imgMeBarBg.setImageDrawable(drawable);
                        toolbarMe.setTitle("");
                    } else {
                        drawable.mutate().setAlpha(255);
                        imgMeBarBg.setImageDrawable(drawable);
                        if (scrollY > slidingDistance + 120) {
                            //mToolbar.setTitle(mMovie.getTitle());
                        } else {
                            //mToolbar.setTitle("");
                        }
                    }
                }
            }
        });

    }

    @Override
    public void showError(int code) {

    }

    @Override
    protected AboutMePresenter getPresenter() {
        return new AboutMePresenter(this);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    public static int getStatusBarHeight(Context context) {
        //return 0;
        // 获得状态栏高度
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        return context.getResources().getDimensionPixelSize(resourceId);
    }
}