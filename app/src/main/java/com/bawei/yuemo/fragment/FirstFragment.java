package com.bawei.yuemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yuemo.R;
import com.bawei.yuemo.adapter.Myadapter;

/**
 * Created by Administrator on 2017/10/25.
 */

public class FirstFragment extends Fragment {
    private TabLayout tabLayout2;
    private ViewPager pager2;
    private View view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.tuijian_item,container,false);
        initView(view);

        return view;
    }

    private void initView(View view) {
        pager2=view.findViewById(R.id.pager2);
         tabLayout2=view.findViewById(R.id.tab2);
        pager2.setAdapter(new Myadapter(getActivity().getSupportFragmentManager()));
         tabLayout2.setupWithViewPager(pager2);
    }



}
