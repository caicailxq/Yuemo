package com.bawei.yuemo.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bawei.yuemo.fragment.BaoFragment;
import com.bawei.yuemo.fragment.GuanFragment;
import com.bawei.yuemo.fragment.XinFragment;
import com.bawei.yuemo.fragment.ZhuFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */

public class Myadapter extends FragmentStatePagerAdapter{
    private String[] titles = {"最新日报", "专栏","热门","主题日报"};
    private List<Fragment> mFragments = new ArrayList<>();
    private FragmentManager mFragmentManager;
    public Myadapter(FragmentManager fm) {
        super(fm);
        mFragmentManager=fm;
    }

    public Myadapter(FragmentManager fm, List<Fragment> temp) {
        super(fm);
        mFragmentManager=fm;
        mFragments=temp;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                XinFragment reFragment=new XinFragment();
                return reFragment;
            case 1:
                GuanFragment guanFragment = new GuanFragment();
                return guanFragment;
            case 2:

            BaoFragment baoFragment=new BaoFragment();
            return baoFragment;
            case 3:
                ZhuFragment zhuFragment=new ZhuFragment();
                return zhuFragment;
        }
        return null;

    }

    @Override
    public int getCount() {
        return titles.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
