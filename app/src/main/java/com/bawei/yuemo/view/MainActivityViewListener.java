package com.bawei.yuemo.view;

import com.bawei.yuemo.bean.Qbean;

/**
 * Created by Administrator on 2017/10/25.
 */

public interface MainActivityViewListener {
    public void callBackSuccess(Qbean qbean);
    public void callBackFailure(int code);
}
