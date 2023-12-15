package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

public class MyFragment extends Fragment {
    String animal;

    public MyFragment(String animal) {
        this.animal = animal;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, null);
        ImageView image = view.findViewById(R.id.image);
        int resource = 0;
        if (this.animal.equals("cat")) {
            resource = R.drawable.cat;
        } else if (this.animal.equals("dog")) {
            resource = R.drawable.dog;
        }
        image.setImageResource(resource);
        return view;
    }
}