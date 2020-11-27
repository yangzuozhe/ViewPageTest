package com.example.viewpagetest.adpter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.viewpagetest.bean.infoBean;
import com.example.viewpagetest.fragment.ViewPagerTabLayoutFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class ViewPagerTabLayoutAdapter extends FragmentPagerAdapter {
    List<infoBean> mBeanList;
    List<View> mViewList;

    public ViewPagerTabLayoutAdapter(@NonNull FragmentManager fm, List<infoBean> beanList) {
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mBeanList = beanList;
    }

    public ViewPagerTabLayoutAdapter(@NonNull FragmentManager fm, List<infoBean> beanList, List<View> tabList) {
        this(fm, beanList);
        mViewList = tabList;
    }

    public View getTabList(int position) {
        return mViewList.get(position);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ViewPagerTabLayoutFragment.newInstance(position, mBeanList.get(position).getName());
    }

    @Override
    public int getCount() {
        return mBeanList.size();
    }


}
