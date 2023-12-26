package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    Context context;
    int layout;
    List<Group> list;

    public CustomAdapter(
            Context context, int layout, List<Group> list) {
        this.context = context;
        this.layout = layout;
        this.list = list;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(layout, null);
        TextView gName = v.findViewById(R.id.gName);
        TextView gNumber = v.findViewById(R.id.gNumber);
        gName.setText(list.get(i).gName);
        gNumber.setText(list.get(i).gNumber + "");
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


