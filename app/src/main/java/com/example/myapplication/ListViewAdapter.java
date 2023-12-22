package com.example.myapplication;

import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends BaseAdapter {
    private Activity act;
    private int layout;
    private ArrayList<ShopVO> shopList;

    public ListViewAdapter(Activity act, int layout, ArrayList<ShopVO> shopList) {
        this.act = act;
        this.layout = layout;
        this.shopList = shopList;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Log.w("getView", i + "");

        View v = null;

        if (view == null) {
            LayoutInflater inflater = act.getLayoutInflater();
            v = inflater.inflate(layout, null);
        } else {
            v = view;
        }

        // View Holder
        ImageView shopImg = v.findViewById(R.id.shop_img);
        TextView shopName = v.findViewById(R.id.shop_name);
        TextView shopDesc = v.findViewById(R.id.shop_desc);
        shopImg.setImageResource(shopList.get(i).getShopImg());
        shopName.setText(shopList.get(i).getShopName());
        shopDesc.setText(shopList.get(i).getShopDesc());
        return v;
    }

    @Override
    public int getCount() {
        return shopList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

}
