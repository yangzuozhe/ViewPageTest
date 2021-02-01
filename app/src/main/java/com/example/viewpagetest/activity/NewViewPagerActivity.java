package com.example.viewpagetest.activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.viewpagetest.R;
import com.example.viewpagetest.bean.InfoBean;
import com.example.viewpagetest.fragment.MyNewFragment;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * @author yang
 */
public class NewViewPagerActivity extends AppCompatActivity {
    public static final int NUMBER = 5;
    private ArrayList<InfoBean> mList = new ArrayList<>();
    ViewPager mVpMyNewViewPager;
    TabLayout mTlMyNewTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_view_pager);
        mVpMyNewViewPager = findViewById(R.id.vpMyNewViewPager);
        mTlMyNewTab = findViewById(R.id.tlMyNewTab);
        initData();
        initViewPager();
    }

    /**
     * 初始化数据bean类
     */
    private void initData() {
        for (int i = 0; i < NUMBER; i++) {
            InfoBean bean = new InfoBean("我是第" + i + "页", "标题" + i);
            mList.add(bean);
        }
    }

    /**
     * 初始化 viewpager 和 tabLayout 两者进行结合
     */
    private void initViewPager() {
        //创建viewPager 的 adapter
        MyAdapter myAdapter = new MyAdapter(getSupportFragmentManager(), mList);
        //将viewPager的Adapter 传入 viewPager
        mVpMyNewViewPager.setAdapter(myAdapter);
        //将 TabLayout 和 viewPager 进行结合
        mTlMyNewTab.setupWithViewPager(mVpMyNewViewPager);
        //TabLayout 的展示类型
        mTlMyNewTab.setTabMode(TabLayout.MODE_FIXED);
        initCustomTab();
        mTlMyNewTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    TextView textView = tab.getCustomView().findViewById(R.id.tvCustomText);
                    textView.setSelected(true);
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                if (tab.getCustomView() != null) {
                    TextView textView = tab.getCustomView().findViewById(R.id.tvCustomText);
                    textView.setSelected(false);
                }
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    /**
     * 设置自定义tab
     */
    private void initCustomTab() {
        //由于之前的 tabLayout 和 viewPager 已经进行结合了，因此，tabLayout 的个数是和 viewPager 的页数绑定，是一样的。
        // 因此，我们就通过 TabLayout 的 getTabCount 来知道 tabLayout 的所有tab个数
        for (int i = 0; i < mTlMyNewTab.getTabCount(); i++) {
            //获取
            TabLayout.Tab tab = mTlMyNewTab.getTabAt(i);
            final View view = LayoutInflater.from(NewViewPagerActivity.this).inflate(R.layout.custom_tablayout, null);
            TextView textView = view.findViewById(R.id.tvCustomText);
            textView.setText(mList.get(i).getTabName());
            if (tab != null) {
                tab.setCustomView(view);
            }
        }
    }

    static class MyAdapter extends FragmentPagerAdapter {
        private ArrayList<InfoBean> mList;

        public MyAdapter(@NonNull FragmentManager fm, ArrayList<InfoBean> list) {
            super(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
            mList = list;
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return MyNewFragment.newInstance(mList.get(position));
        }

        @Override
        public int getCount() {
            return mList.size();
        }

//        /**
//         * 这个方法不是说一定要重写，如果说想要通过系统的格式创建tabLayout
//         * 通过这个方法可以赋值给 tabLayout
//         * 如果说想要自定义 tab 就没有必要重写这个方法
//         *
//         * @param position
//         * @return
//         */
//        @Nullable
//        @Override
//        public CharSequence getPageTitle(int position) {
//            return mList.get(position).getTabName();
//        }
    }

}