package com.example.viewpagetest.adpter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.List;

/**
 * 类描述
 *
 * @author HB.yangzuozhe
 * @date 2020-11-24
 */
public class MainFragmentAdapter extends FragmentPagerAdapter {
    List<Fragment> mFragmentList;

    public MainFragmentAdapter(@NonNull FragmentManager fm, List<Fragment> fragmentList) {
        //注意要使用 BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT 这个常数，否则如果使用单参构造方法，会显示过时。
        super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mFragmentList = fragmentList;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {//必须写
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {//必须写
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {//选择写，可以不写
        //这里显示获得碎片类名
        return mFragmentList.get(position).getClass().getSimpleName();
    }
}
