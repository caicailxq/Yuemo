package com.bawei.yuemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yuemo.R;
import com.bawei.yuemo.adapter.Zhuadapter;
import com.bawei.yuemo.bean.Qbean;
import com.bawei.yuemo.presenter.MainActivityPresenter;
import com.bawei.yuemo.view.MainActivityViewListener;

/**
 * Created by Administrator on 2017/10/25.
 */

public class ZhuFragment extends Fragment implements MainActivityViewListener{
    private RecyclerView recycleview2;
    MainActivityPresenter presenter;
    private GridLayoutManager manager;
    private Zhuadapter zhuadapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.zhu_item, container, false);
        presenter=new MainActivityPresenter(this);
        recycleview2=view.findViewById(R.id.recy2);

        presenter=new MainActivityPresenter(this);

         zhuadapter=new Zhuadapter(getActivity());
        recycleview2.setAdapter(zhuadapter);
        manager = new GridLayoutManager(getActivity(),2);
        recycleview2.setLayoutManager(manager);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        presenter.getData(true);
        return view;
    }

    @Override
    public void callBackSuccess(final Qbean qbean) {
    getActivity().runOnUiThread(new Runnable() {
        @Override
        public void run() {
            zhuadapter.setData(qbean);
        }
    });
    }

    @Override
    public void callBackFailure(int code) {

    }
}
