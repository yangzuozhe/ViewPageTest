package com.example.viewpagetest.viewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.viewpagetest.R;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2Activity extends AppCompatActivity {
    List<String> mStringList = new ArrayList<>();

    ViewPager2 mVpViewPager2;
    TabLayout mTlLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);
        mVpViewPager2 = findViewById(R.id.vp2);
        mTlLayout = findViewById(R.id.tlLayout);
        //数据
        initData();
        //两种 adpter 二选一
        ViewPager2Adapter adapter = new ViewPager2Adapter(this, mStringList);
        ViewPager2RecyclerAdapter recyclerAdapter = new ViewPager2RecyclerAdapter(mStringList);
        mVpViewPager2.setAdapter(recyclerAdapter);
        //注意顺序，要在 viewPager 设置adapter 后再将tab和viewPager结合
        setViewPagerWithTab(mTlLayout, mVpViewPager2);
        //可以在这里面对 viewPager 的滑动过程进行操作
        mVpViewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                super.onPageScrolled(position, positionOffset, positionOffsetPixels);
            }

            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                super.onPageScrollStateChanged(state);
            }
        });
    }

    /**
     * 设置 tabLayout 和viewPager结合
     *
     * @param tabLayout
     * @param viewPager2
     */
    private void setViewPagerWithTab(TabLayout tabLayout, ViewPager2 viewPager2) {
        //用来对tabLayout 和 viewPager 进行结合
        final TabLayoutMediator tabLayoutMediator = new TabLayoutMediator(tabLayout, viewPager2, new TabLayoutMediator.TabConfigurationStrategy() {
            @Override
            public void onConfigureTab(@NonNull TabLayout.Tab tab, int position) {
                tab.setText(mStringList.get(position));
            }
        });
        tabLayoutMediator.attach();

        //注意结合完以后再调用这个方法，就可以很好的获取tab的个数，能够更好的自定义
        initCustomTab(tabLayout);
    }

    /**
     * 自定义 tabLayout
     */
    private void initCustomTab(TabLayout tabLayout) {
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        for (int i = 0; i < tabLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tabLayout.getTabAt(i);
            if (tab != null) {
                View view = LayoutInflater.from(ViewPager2Activity.this).inflate(R.layout.custom_tablayout, null);
                tab.setCustomView(view);
            }
        }
    }

    private void initData() {
        mStringList.add("我是第一页");
        mStringList.add("我是第2页");
        mStringList.add("我是第3页");
        mStringList.add("我是第4页");
        mStringList.add("我是第5页");
        mStringList.add("我是第6页");
    }

}