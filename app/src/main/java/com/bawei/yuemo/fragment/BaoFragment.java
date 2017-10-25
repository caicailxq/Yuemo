package com.bawei.yuemo.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import com.bawei.yuemo.R;
import com.bawei.yuemo.StringUtils;
import com.bawei.yuemo.adapter.Baoadapter;
import com.bawei.yuemo.bean.ShopBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/10/25.
 */

public class BaoFragment extends Fragment {
   private RecyclerView thirdRecyclerview;
    private CheckBox checkAll;
    private TextView allprice;
    private LinearLayoutManager manager;

    List<ShopBean.OrderDataBean.CartlistBean> list = new ArrayList<ShopBean.OrderDataBean.CartlistBean>();

    private Baoadapter baoadapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bao_item, container, false);
        thirdRecyclerview=view.findViewById(R.id.third_recyclerview);
        checkAll=view.findViewById(R.id.check_all);
        allprice=view.findViewById(R.id.allprice);
     tabView();






        return view;
    }

    private void tabView() {
        try {
            InputStream inputStream = getActivity().getAssets().open("shop.json");
            String data = StringUtils.convertStreamToString(inputStream);
            Gson gson = new Gson();
            ShopBean shopBean = gson.fromJson(data, ShopBean.class);

            for (int i = 0; i < shopBean.getOrderData().size(); i++) {
                int length = shopBean.getOrderData().get(i).getCartlist().size();
                for (int j = 0; j < length; j++) {
                    list.add(shopBean.getOrderData().get(i).getCartlist().get(j));
                }
            }

            manager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
            thirdRecyclerview.setLayoutManager(manager);

            baoadapter = new Baoadapter(getActivity(), list);

            thirdRecyclerview.setAdapter(baoadapter);

            baoadapter.setCheckListener(new Baoadapter.CheckListener() {
                @Override
                public void check(boolean check, int position) {

                    boolean allCheck = true;

                    float price = 0;

                    for (int i = 0; i < list.size(); i++) {
                        if (list.get(i).isSelect()) {
                            price += list.get(i).getPrice() * list.get(i).getCount();

                        }

                    }


                    for (int i = 0; i < list.size(); i++) {


                        if (!list.get(i).isSelect()) {
                            allCheck = false;
                            break;
                        }
                    }

                    allprice.setText(price + "元");

                    if (allCheck) {
                        checkAll.setChecked(true);
                    } else {
                        checkAll.setChecked(false);
                    }

                }
            });
            checkAll.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    boolean check =  checkAll.isChecked();
                    float price  = 0 ;

                    for (int i = 0; i < list.size(); i++) {
                        list.get(i).setSelect(check);
                        if(check){
                            if (list.get(i).isSelect()) {
                                price += list.get(i).getPrice() * list.get(i).getCount();
                            }
                        }
                    }
                    baoadapter.notifyDataSetChanged();

                    allprice.setText(price+"元");


                }
            });













        } catch (IOException e) {
            e.printStackTrace();
        }








    }



   /* @OnClick(R.id.check_all)
    public void onClick(){

        boolean check =  checkAll.isChecked();
        float price  = 0 ;

        for (int i = 0; i < list.size(); i++) {
            list.get(i).setSelect(check);
            if(check){
                if (list.get(i).isSelect()) {
                    price += list.get(i).getPrice() * list.get(i).getCount();
                }
            }
        }
        baoadapter.notifyDataSetChanged();

        allprice.setText(price+"元");



    }
*/



    }


