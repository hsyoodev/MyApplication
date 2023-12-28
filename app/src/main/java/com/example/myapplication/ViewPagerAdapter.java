package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment mf = new MyFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        mf.setArguments(bundle);
        return mf;
    }

    @Override
    public int getCount() {
        return 5;
    }
}
