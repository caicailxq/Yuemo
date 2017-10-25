package com.bawei.yuemo.presenter;

import com.bawei.yuemo.bean.Qbean;
import com.bawei.yuemo.model.MainActivityModel;
import com.bawei.yuemo.model.MainActivityModelListener;
import com.bawei.yuemo.view.MainActivityViewListener;

/**
 * Created by Administrator on 2017/10/25.
 */

public class MainActivityPresenter {
    public MainActivityViewListener mainActivityViewListener;
    public MainActivityModel model;
    public MainActivityPresenter(MainActivityViewListener mainActivityViewListener) {
        this.mainActivityViewListener=mainActivityViewListener;
        this.model=new MainActivityModel();
    }

    public void getData(boolean up){
        model.getData(up, new MainActivityModelListener() {
            @Override
            public void callBackSuccess(Qbean qbean) {
                mainActivityViewListener.callBackSuccess(qbean);
            }

            @Override
            public void callBackFailure(int code) {
                mainActivityViewListener.callBackFailure(code);
            }
        });

    }
}
