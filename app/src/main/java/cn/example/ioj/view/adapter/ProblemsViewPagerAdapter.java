package cn.example.ioj.view.adapter;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.widget.TableLayout;

import java.util.ArrayList;
import java.util.List;

import cn.example.ioj.view.fragment.ContestListFragment;
import cn.example.ioj.view.fragment.ProblemsListFragment;

/**
 * Created by L on 2017/9/22.
 */

public class ProblemsViewPagerAdapter extends FragmentPagerAdapter {
    private String[] tableTitle = new String[] {"题目", "实验"};
    private List<Fragment> fragments;

    public ProblemsViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(new ProblemsListFragment());
        fragments.add(new ContestListFragment());
    }

    /**
     * 移动到顶部
     */
    public void moveToTop(int position){
        if(position == 0) {
            ((ProblemsListFragment) fragments.get(0)).moveToTop();
        }
    }
    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tableTitle[position];
    }
}
