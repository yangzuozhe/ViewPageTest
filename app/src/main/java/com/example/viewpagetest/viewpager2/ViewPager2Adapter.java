package com.example.viewpagetest.viewpager2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2Adapter extends FragmentStateAdapter {
    List<String> mStringList = new ArrayList<>();

    public ViewPager2Adapter(@NonNull FragmentActivity fragmentActivity,List<String> list) {
        super(fragmentActivity);
        mStringList = list;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return ViewPager2Fragment.newInstance(mStringList.get(position));
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }
}
