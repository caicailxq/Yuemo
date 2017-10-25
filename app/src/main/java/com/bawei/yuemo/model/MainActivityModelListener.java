package com.bawei.yuemo.model;

import com.bawei.yuemo.bean.Qbean;

/**
 * Created by Administrator on 2017/10/25.
 */

public interface MainActivityModelListener {
    public void callBackSuccess(Qbean qbean);
    public void callBackFailure(int code);
}
