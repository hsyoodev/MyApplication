package com.example.myapplication;

import android.app.Activity;
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
    public int getCount() {
        return shopList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = act.getLayoutInflater();
        View v = inflater.inflate(layout, null);
        ImageView imageView = v.findViewById(R.id.shop_img);
        TextView shopName = v.findViewById(R.id.shop_name);
        TextView shopDesc = v.findViewById(R.id.shop_desc);
        imageView.setImageResource(shopList.get(position).shopImg);
        shopName.setText(shopList.get(position).shopName);
        shopDesc.setText(shopList.get(position).shopDesc);
        return v;
    }
}
