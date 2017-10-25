package com.bawei.yuemo;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.bawei.yuemo.adapter.FragAdapter;
import com.bawei.yuemo.fragment.DuanFragment;
import com.bawei.yuemo.fragment.FirstFragment;
import com.bawei.yuemo.fragment.ShiFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.view_pager)
    ViewPager viewPager;
    @BindView(R.id.tab_layout)
    TabLayout tabLayout;
    String[] name = {"推荐","段子","视频"};
    List<String> list_tab = new ArrayList<>();
    List<Fragment> list_frag = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        tabVeiw();

    }

    private void tabVeiw() {
        for (String bean : name) {
            list_tab.add(bean);
            tabLayout.addTab(tabLayout.newTab().setText(bean));
        }
        FirstFragment firstFragment = new FirstFragment();
        DuanFragment duanFragment = new DuanFragment();
        ShiFragment shiFragment = new ShiFragment();


        list_frag.add(firstFragment);
        list_frag.add(duanFragment);
        list_frag.add(shiFragment);

        FragAdapter adapter=new FragAdapter(getSupportFragmentManager(), list_frag,list_tab);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setText(list_tab.get(0)).setIcon(R.mipmap.ic_launcher_round);
        tabLayout.getTabAt(1).setText(list_tab.get(1)).setIcon(R.mipmap.ic_launcher_round);
        tabLayout.getTabAt(2).setText(list_tab.get(2)).setIcon(R.mipmap.ic_launcher_round);
    }



}
