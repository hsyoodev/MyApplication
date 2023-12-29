package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Map<String, Object>> items;

    public CustomAdapter(
            Context context, int layout, List<Map<String, Object>> items) {
        this.context = context;
        this.layout = layout;
        this.items = items;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(layout, null);
        }
        TextView shopName = view.findViewById(R.id.shop_name);
        TextView shopDesc = view.findViewById(R.id.shop_desc);

        Map<String, Object> item = items.get(position);
        Map<String, Object> snippet = (Map<String, Object>) item.get("snippet");
        String title = (String) snippet.get("title");
        String description = (String) snippet.get("description");
        shopName.setText(title);
        shopDesc.setText(description);
        
        return view;
    }

    @Override
    public int getCount() {
        return items.size();
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
