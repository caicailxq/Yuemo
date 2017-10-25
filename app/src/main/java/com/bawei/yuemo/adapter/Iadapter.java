package com.bawei.yuemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

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

public class Iadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private int itemWidth;
    private List<Qbean.SongListBean> list;

    public Iadapter(Context context) {
        this.context = context;

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        QIViewHolder viewholder = new QIViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {


        if (holder instanceof QIViewHolder) {

            QIViewHolder iViewHolder = (QIViewHolder) holder;


            //        float scale =  (float) itemWidth / (float) list.get(position).getPicWidth()  ;
//        params.width = itemWidth;
//        params.height = (int)( (float)scale * (float)list.get(position).getPicHeight()) ;

           /* LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) iViewHolder.i1.getLayoutParams() ;
            params.width = itemWidth ;
            int height =  new Random().nextInt(1000);
            params.height =  height < 300 ? 300 : height ;

            iViewHolder.i1.setLayoutParams(params);*/

            Glide.with(context).load(list.get(position).getPic_small()).into(iViewHolder.i1);
          iViewHolder.t1.setText(list.get(position).getTitle());
          iViewHolder.t2.setText(list.get(position).getAuthor());
            iViewHolder.t3.setText(list.get(position).getSi_proxycompany());
        }


    }

    @Override
    public int getItemCount() {

        return list == null ? 0 : list.size();
    }

    public void setData(Qbean qbean) {
        if (this.list == null) {
            this.list = new ArrayList<>();
        }
        this.list.addAll(qbean.getSong_list());
        notifyDataSetChanged();
    }


    static class QIViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.i1)
        ImageView i1;
        @BindView(R.id.t1)
        TextView t1;
        @BindView(R.id.t2)
        TextView t2;
        @BindView(R.id.t3)
        TextView t3;
        QIViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }


}
