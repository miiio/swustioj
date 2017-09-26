package cn.example.ioj.view.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import cn.example.ioj.R;
import cn.example.ioj.contract.ProblemsFragmentContract;
import cn.example.ioj.presenter.BaseFragmentPresenter;
import cn.example.ioj.view.activity.MainActivity;
import cn.example.ioj.view.activity.SearchActivity;
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
    EditText mSearchEtInput;

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
        mSearchEtInput.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //跳转到搜索界面
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
