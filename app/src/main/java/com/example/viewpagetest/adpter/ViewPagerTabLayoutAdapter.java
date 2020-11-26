package com.example.viewpagetest.adpter;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.viewpagetest.bean.InfoBean;
import com.example.viewpagetest.fragment.ViewPagerTabLayoutFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ViewPagerTabLayoutAdapter extends FragmentPagerAdapter {
    private String tabTitles[] = new String[]{"tab1", "tab2", "tab3"};
    List<InfoBean> mBeanList;
    public ViewPagerTabLayoutAdapter(@NonNull FragmentManager fm, List<InfoBean> beanList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mBeanList = beanList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ViewPagerTabLayoutFragment.newInstance(position,mBeanList.get(position).getName());
    }

    @Override
    public int getCount() {
        return mBeanList.size();
    }





}
