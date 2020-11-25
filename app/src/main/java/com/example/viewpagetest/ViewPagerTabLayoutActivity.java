package com.example.viewpagetest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

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
        mAdapter = new ViewPagerTabLayoutAdapter(getSupportFragmentManager(),ViewPagerTabLayoutActivity.this);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_FIXED);

    }
}