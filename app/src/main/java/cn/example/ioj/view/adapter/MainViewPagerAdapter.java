package cn.example.ioj.view.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import cn.example.ioj.view.fragment.AboutMeFragment;
import cn.example.ioj.view.fragment.HomeFragment;
import cn.example.ioj.view.fragment.ProblemsFragment;

/**
 * Created by L on 2017/9/22.
 */

public class MainViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragmentList;

    public MainViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragmentList = new ArrayList<>();
        fragmentList.add(new HomeFragment());
        fragmentList.add(new ProblemsFragment());
        fragmentList.add(new AboutMeFragment());
    }



    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        //super.destroyItem(container, position, object);
    }
}
