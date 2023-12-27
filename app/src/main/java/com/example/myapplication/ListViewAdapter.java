package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import java.util.Map;

public class ListViewAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Map<String, Object>> list;
    LayoutInflater inflater;

    public ListViewAdapter(Context context, int layout, List<Map<String, Object>> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return list.size();
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
        if (convertView == null) {
            convertView = inflater.inflate(layout, null);
        }
        Map<String, Object> shop = list.get(position);
        ImageView imgPath = convertView.findViewById(R.id.img_path);
        TextView shopName = convertView.findViewById(R.id.shop_name);
        TextView shopDesc = convertView.findViewById(R.id.shop_desc);
        TextView restDate = convertView.findViewById(R.id.rest_date);
        TextView parkingInfo = convertView.findViewById(R.id.parking_info);

        Glide.with(context)
                .load("http://ggoreb.com" + shop.get("img_path"))
                .into(imgPath);
        shopName.setText(shop.get("shop_name").toString());
        shopDesc.setText(shop.get("shop_desc").toString());
        restDate.setText(shop.get("rest_date").toString());
        parkingInfo.setText(shop.get("parking_info").toString());

        return convertView;
    }
}
