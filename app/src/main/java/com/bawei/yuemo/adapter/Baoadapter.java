package com.bawei.yuemo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.yuemo.CustomView;
import com.bawei.yuemo.R;
import com.bawei.yuemo.bean.ShopBean;
import com.bumptech.glide.Glide;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/10/25.
 */

public class Baoadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<ShopBean.OrderDataBean.CartlistBean> list ;
    private Context context;

    public Baoadapter(Context context,List<ShopBean.OrderDataBean.CartlistBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item4, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {


        if(holder instanceof ViewHolder){

            final ViewHolder viewHolder = (ViewHolder) holder ;


            Glide.with(context).load(list.get(position).getDefaultPic()).into(viewHolder.shopface);

            if(list.get(position).isSelect()){
                if(!viewHolder.checkbox.isChecked()){
                    viewHolder.checkbox.setChecked(true);
                }
            } else {
                viewHolder.checkbox.setChecked(false);
            }


            viewHolder.textView.setText(list.get(position).getPrice()+"");

            viewHolder.checkbox.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    boolean isChecked = list.get(position).isSelect() ;

                    list.get(position).setSelect(!isChecked);
                    notifyDataSetChanged();
                    if(listener != null){
                        listener.check(!isChecked,position);
                    }

                }
            });


            viewHolder.customviewid.setListener(new CustomView.ChangeListener() {
                @Override
                public void onChange(int count) {
                    list.get(position).setCount(count);
                    notifyDataSetChanged();

                    if(listener != null){
                        listener.check(list.get(position).isSelect(),position);
                    }
                }
            });


        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }




    public CheckListener listener;
    public void setCheckListener(CheckListener listener){
        this.listener = listener ;
    }
    public interface CheckListener {
        public void check(boolean check,int position);
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.checkbox)
        CheckBox checkbox;
        @BindView(R.id.shopface)
        ImageView shopface;
        @BindView(R.id.customviewid)
        CustomView customviewid;

        @BindView(R.id.danjia)
        TextView textView ;

        ViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
