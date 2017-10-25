package com.bawei.yuemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bawei.yuemo.GlideImageLoader;
import com.bawei.yuemo.R;
import com.bawei.yuemo.adapter.Iadapter;
import com.bawei.yuemo.bean.Qbean;
import com.bawei.yuemo.presenter.MainActivityPresenter;
import com.bawei.yuemo.view.MainActivityViewListener;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */

public class XinFragment extends Fragment implements MainActivityViewListener{
    private List<String> mListImage,mListTitle;
    private View view;
    MainActivityPresenter presenter;

private Banner banner;
    private Iadapter iadapter;
    private RecyclerView recycleview;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xin_item, container, false);
        xinView(view);
        presenter=new MainActivityPresenter(this);
         recycleview=view.findViewById(R.id.recy);

         iadapter=new Iadapter(getActivity());
        recycleview.setAdapter(iadapter);

        LinearLayoutManager manger=new LinearLayoutManager(getActivity());
        recycleview.setLayoutManager(manger);
        manger.setOrientation(LinearLayoutManager.VERTICAL);

        presenter.getData(true);

        return view;
    }

    private void xinView(View view) {
    banner=view.findViewById(R.id.banner);
        banner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);

//加载图片的方法

        banner.setImageLoader(new GlideImageLoader());

        mListImage= new ArrayList<>();

//想图片集合中添加网网址

        mListImage.add("http://www.93.gov.cn/11002/upload/webcms/content/image/2017/08/10/17_12_46_619_02480_1.jpg");

        mListImage.add("http://www.93.gov.cn/11002/upload/webcms/content/image/2017/08/15/16_42_14_391_56386_QQjt20170815164126.jpg");

        mListImage.add("http://www.93.gov.cn/11002/upload/webcms/content/image/2017/08/15/16_39_29_705_09313_QQjt20170815163838.jpg");

        mListImage.add("http://www.93.gov.cn/11002/upload/webcms/content/image/2017/08/15/15_27_10_054_07707_lmzabzregxaxcxmlyshddy.jpg");

        mListImage.add("http://www.93.gov.cn/11002/upload/webcms/content/image/2017/08/13/11_17_32_194_14971_640(1).webp.jpg");

//设置Banner图片集合

        banner.setImages(mListImage);

//设置banner的动画效果

        banner.setBannerAnimation(Transformer.DepthPage);

//切换的时间

        banner.setDelayTime(2000);
        mListTitle=new ArrayList<>();

//添加Title

        mListTitle.add("第一张图片");

        mListTitle.add("第二张图片");

        mListTitle.add("第三张图片");

        mListTitle.add("第四张图片");

        mListTitle.add("第五张图片");

//设置Banner标题集合（当banner样式有显示title时）

        banner.setBannerTitles(mListTitle);

//title的位置在banner的显示

        banner.setIndicatorGravity(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE);

//启动banner

        banner.start();

    }


    @Override
    public void callBackSuccess(final Qbean qbean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                iadapter.setData(qbean);
            }
        });



    }

    @Override
    public void callBackFailure(int code) {

    }
}
