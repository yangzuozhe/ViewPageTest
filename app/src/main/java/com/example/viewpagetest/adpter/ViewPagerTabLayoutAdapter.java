package com.example.viewpagetest.adpter;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.viewpagetest.fragment.ViewPagerTabLayoutFragment;

public class ViewPagerTabLayoutAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"tab1", "tab2", "tab3"};
    Context mContext;
    public ViewPagerTabLayoutAdapter(@NonNull FragmentManager fm, Context context) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mContext = context;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ViewPagerTabLayoutFragment.newInstance(position+1);
    }

    @Override
    public int getCount() {
        return tabTitles.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
