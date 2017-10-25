package com.bawei.yuemo;

import android.content.Context;
import android.graphics.Point;
import android.util.DisplayMetrics;

/**
 * Created by Administrator on 2017/10/25.
 */

public class Utils {
    /**
     * 获取设备屏幕尺寸
     * @param context
     * @return
     */
    public static Point getDisplayInfomation(Context context){
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        return new Point(dm.widthPixels,dm.heightPixels);
    }
}
