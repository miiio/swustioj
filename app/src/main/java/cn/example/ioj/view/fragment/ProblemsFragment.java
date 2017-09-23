package cn.example.ioj.view.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.R;
import cn.example.ioj.contract.ProblemsFragmentContract;
import cn.example.ioj.presenter.BaseFragmentPresenter;
import cn.example.ioj.view.adapter.ProblemsViewPagerAdapter;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsFragment extends BaseFragment implements ProblemsFragmentContract.View {
    View fragmentRootView;
    @BindView(R.id.prb_toolbar)
    Toolbar prbToolbar;
    Unbinder unbinder;
    @BindView(R.id.tablayout_prb)
    TabLayout tablayoutPrb;
    @BindView(R.id.viewpager_prb)
    ViewPager viewpagerPrb;

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
        viewpagerPrb.setAdapter(new ProblemsViewPagerAdapter(getFragmentManager()));
        tablayoutPrb.setupWithViewPager(viewpagerPrb);
        viewpagerPrb.setCurrentItem(0);
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
