package com.example.viewpagetest.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import com.example.viewpagetest.R;
import com.example.viewpagetest.adpter.MainFragmentAdapter;
import com.example.viewpagetest.fragment.MyFragment1;
import com.example.viewpagetest.fragment.MyFragment2;
import com.example.viewpagetest.pagetransformer.ZoomOutPageTransformer;
import com.example.viewpagetest.view.MyView1;
import com.example.viewpagetest.view.MyView2;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ViewPager mVpMainPage;
    List<Fragment> mFragmentList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        //将xml布局添加到 List<View> 集合中
//        addXml(mMainList);
//添加view布局到 List<View> 集合中
//        addView(mMainList);
//        //将布局添加到 ViewPager 中
//        mVpMainPage.setAdapter(new MainAdapter(mMainList));
        addFragment();
        mVpMainPage.setAdapter(new MainFragmentAdapter(getSupportFragmentManager(), mFragmentList));
        mVpMainPage.setPageTransformer(true,new ZoomOutPageTransformer());
    }

    public void initView() {
        mVpMainPage = findViewById(R.id.vpMainPage);
    }

    public void addFragment() {
        mFragmentList.add(new MyFragment1());
        mFragmentList.add(new MyFragment2());
    }

    public void addView(List<View> list) {
        list.add(new MyView1(MainActivity.this));
        list.add(new MyView2(MainActivity.this));
    }

    public void addXml(List<View> list) {
        //将xml布局转化为view
        View page1 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.xml_page1, null);
        View page2 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.xml_page2, null);
        View page3 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.xml_page3, null);
        View page4 = LayoutInflater.from(getApplicationContext()).inflate(R.layout.xml_page4, null);
        list.add(page1);
        list.add(page2);
        list.add(page3);
        list.add(page4);
    }


}