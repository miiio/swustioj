package cn.example.ioj.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import cn.example.ioj.view.fragment.ContestListFragment;
import cn.example.ioj.view.fragment.MyAcProblemsFragment;


/**
 * Created by wax on 2017/10/14.
 */

public class AboutMeViewPagerAdapter extends FragmentPagerAdapter {
    private String[] tableTitle = new String[] {"已解决", "挑战中","关于我"};
    private List<Fragment> fragments;

    public AboutMeViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(new MyAcProblemsFragment());
        fragments.add(new MyAcProblemsFragment());
        fragments.add(new MyAcProblemsFragment());
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tableTitle[position];
    }
}
