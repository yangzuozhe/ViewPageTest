package com.example.viewpagetest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.viewpagetest.R;
import com.example.viewpagetest.adpter.ViewPagerTabLayoutAdapter;
import com.example.viewpagetest.bean.InfoBean;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerTabLayoutActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    ViewPagerTabLayoutAdapter mAdapter;
    List<TabLayout.Tab> tabList = new ArrayList<>();
    List<InfoBean> beanList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager__tab_layout);
        mTabLayout = findViewById(R.id.tlTabLayoutView);
        mViewPager = findViewById(R.id.vpViewPagerView);
        //首先创建数据bean类
        for (int i = 0; i < 4; i++) {
            beanList.add(new InfoBean("view" + i, "tab" + i));
        }
        for (int i = 0; i < beanList.size(); i++) {
            //创建我们的tab标签，这里是使用自定义的view作为标签，使用这个我们要注意，不使用 setupWithViewPager 方法，
            // 我们就需要在下面手动设置tabLayout和viewPager进行华东结合
            View view = LayoutInflater.from(getApplicationContext()).inflate(R.layout.custom_tablayout, null);
            TextView textView = view.findViewById(R.id.tvCustomText);
            textView.setText(beanList.get(i).getTabName());
            TabLayout.Tab tab = mTabLayout.newTab().setCustomView(view);
            mTabLayout.addTab(tab);
        }
        withViewPager2();

    }

    ObjectAnimator animator;

    public void withViewPager2() {
        mAdapter = new ViewPagerTabLayoutAdapter(getSupportFragmentManager(), beanList);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {

                mViewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mTabLayout.getTabAt(position).select();

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

//    public void withViewPager() {
//        mAdapter = new ViewPagerTabLayoutAdapter(getSupportFragmentManager(), mTabLayout);
//        mViewPager.setAdapter(mAdapter);
//        mTabLayout.setupWithViewPager(mViewPager);
//        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
//    }
}