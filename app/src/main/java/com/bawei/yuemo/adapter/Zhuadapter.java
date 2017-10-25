package com.bawei.yuemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bawei.yuemo.R;
import com.bawei.yuemo.bean.Qbean;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/25.
 */

public class Zhuadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private int itemWidth ;
    private List<Qbean.SongListBean> list;

    public Zhuadapter(Context context) {
        this.context = context;
       /* Point point =  Utils.getDisplayInfomation(context);

        itemWidth = point.x / 3 ;*/
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item2, parent, false);
        QIViewHolder viewholder=new QIViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if(holder instanceof QIViewHolder){

            QIViewHolder iViewHolder = (QIViewHolder)holder;




            //        float scale =  (float) itemWidth / (float) list.get(position).getPicWidth()  ;
//        params.width = itemWidth;
//        params.height = (int)( (float)scale * (float)list.get(position).getPicHeight()) ;
/*
            LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iViewHolder.i2.getLayoutParams() ;
            params.width = itemWidth ;
            int height =  new Random().nextInt(1000);
            params.height =  height < 300 ? 300 : height ;

            iViewHolder.i2.setLayoutParams(params);*/

            Glide.with(context).load(list.get(position).getPic_big()).into(iViewHolder.i2);







        }


    }

    @Override
    public int getItemCount() {

        return list==null ? 0 :list.size();
    }

    public void setData(Qbean qbean) {
        if(this.list==null){
            this.list=new ArrayList<>();
        }
        this.list.addAll(qbean.getSong_list());
        notifyDataSetChanged();
    }


    static class QIViewHolder extends RecyclerView.ViewHolder{
        @BindView(R.id.i2)
        ImageView i2;

        QIViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }

}
