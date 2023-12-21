package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Product> list;

    public CustomAdapter(
            Context context, int layout, List<Product> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layout, null);
        ImageView image = v.findViewById(R.id.image);
        image.setImageResource(list.get(i).getIcon());

        TextView title = v.findViewById(R.id.title);
        title.setText(list.get(i).getTitle());

        Button btn_order = v.findViewById(R.id.btn_order);
        btn_order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(Intent.ACTION_VIEW, Uri.parse(list.get(i).getUrl()));
                context.startActivity(intent);
            }
        });

        Button btn_cancel = v.findViewById(R.id.btn_cancel);
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(i);
                notifyDataSetChanged();
            }
        });

        return v;
    }

    @Override
    public int getCount() {
        return list.size();
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
