package com.bawei.yuemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */

public class FragAdapter extends FragmentStatePagerAdapter{
    List<Fragment> list;
    List<String> list_tab;

    public FragAdapter(FragmentManager fm, List<Fragment> list, List<String> list_tab) {
        super(fm);
        this.list = list;
        this.list_tab = list_tab;
    }


    @Override
    public Fragment getItem(int position) {
        return list.get(position);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return list_tab.get(position);
    }
}
