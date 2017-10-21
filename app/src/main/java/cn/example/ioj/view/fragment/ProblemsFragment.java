package cn.example.ioj.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.R;
import cn.example.ioj.contract.ProblemsFragmentContract;
import cn.example.ioj.presenter.BaseFragmentPresenter;
import cn.example.ioj.view.activity.SearchActivity;
import cn.example.ioj.view.activity.StatusBarManager;
import cn.example.ioj.view.adapter.ProblemsViewPagerAdapter;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsFragment extends BaseFragment implements ProblemsFragmentContract.View {
    View fragmentRootView;
    @BindView(R.id.prb_toolbar)
    LinearLayout prbToolbar;
    Unbinder unbinder;
    @BindView(R.id.tablayout_prb)
    TabLayout tablayoutPrb;
    @BindView(R.id.viewpager_prb)
    ViewPager viewpagerPrb;
    @BindView(R.id.search_et_input)
    FrameLayout mSearchEtInput;
    @BindView(R.id.et_search)
    TextView mEtSearch;
    @BindView(R.id.fakeBar)
    View fakeBar;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        fragmentRootView = inflater.inflate(R.layout.fragment_problems, container, false);
        unbinder = ButterKnife.bind(this, fragmentRootView);
        initView();
        return fragmentRootView;

    }

    private void initView() {
        // 获得状态栏高度
        int resourceId = getActivity().getResources().getIdentifier("status_bar_height", "dimen", "android");
        int statusHeight = getActivity().getResources().getDimensionPixelSize(resourceId);
        //设置高度
        LinearLayout.LayoutParams param = (LinearLayout.LayoutParams)fakeBar.getLayoutParams();
        //获取当前控件的布局对象
        param.height = statusHeight;//设置当前控件布局的高度
        fakeBar.setLayoutParams(param);//将设置好的布局参数应用到控件中


        viewpagerPrb.setAdapter(new ProblemsViewPagerAdapter(getFragmentManager()));
        tablayoutPrb.setupWithViewPager(viewpagerPrb);
        tablayoutPrb.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

                ((ProblemsViewPagerAdapter) viewpagerPrb.getAdapter()).moveToTop(tab.getPosition());
            }
        });
        viewpagerPrb.setCurrentItem(0);
        mEtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到搜索界面
                Log.i("Lyon", "successed");
                startActivity(new Intent(ProblemsFragment.this.getActivity(), SearchActivity.class));
            }
        });
    }

    @Override
    public void showError(int code) {

    }

    @Override
    protected BaseFragmentPresenter getPresenter() {
        return null;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
