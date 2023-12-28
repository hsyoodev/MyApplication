package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup vg, Bundle b) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        TextView textView = view.findViewById(R.id.text);

        Bundle bundle = getArguments();
        int position = bundle.getInt("position");
        textView.setText(position + "");
        return view;
    }
}

