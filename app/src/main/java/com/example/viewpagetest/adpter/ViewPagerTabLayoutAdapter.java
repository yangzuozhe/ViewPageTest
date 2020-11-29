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

    //获取数据bean类，获取我们自定义的view
    public ViewPagerTabLayoutAdapter(@NonNull FragmentManager fm, List<infoBean> beanList, List<View> tabList) {
        this(fm, beanList);
        mViewList = tabList;
    }

    //自定义的方法，为了获取自定义的view
    public View getTabList(int position) {
        return mViewList.get(position);
    }

    //获取当前的页面，这里我们也是将我们的数据bean类传进去
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return ViewPagerTabLayoutFragment.newInstance(position, mBeanList.get(position));
    }

    //用数据bean类获取总共有多少页数
    @Override
    public int getCount() {
        return mBeanList.size();
    }
}
