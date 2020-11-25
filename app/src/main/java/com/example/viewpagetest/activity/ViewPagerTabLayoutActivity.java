package com.example.viewpagetest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.example.viewpagetest.R;
import com.example.viewpagetest.adpter.ViewPagerTabLayoutAdapter;
import com.google.android.material.tabs.TabLayout;

public class ViewPagerTabLayoutActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    ViewPagerTabLayoutAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager__tab_layout);
        mTabLayout = findViewById(R.id.tlTabLayoutView);
        mViewPager = findViewById(R.id.vpViewPagerView);
        initTable();

    }

    public void withViewPager(){
        mAdapter = new ViewPagerTabLayoutAdapter(getSupportFragmentManager(),ViewPagerTabLayoutActivity.this);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);
    }

    public void initTable(){
        TabLayout.Tab tab1 = mTabLayout.newTab();
        tab1.setText("n你好");
        TabLayout.Tab tab2 = mTabLayout.newTab();
        tab2.setText("haha");
        mTabLayout.addTab(tab1);
        mTabLayout.addTab(tab2);
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //选中某个tab

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                //当tab从选择到未选择

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                //已经选中tab后的重复点击tab
            }
        });
    }
}