package com.example.viewpagetest.OLD;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

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

/**
 * 这个类这样写viewPager 和 tabLayout 进行结合是不对的
 */
public class ViewPagerTabLayoutActivity extends AppCompatActivity {
    TabLayout mTabLayout;
    ViewPager mViewPager;
    ViewPagerTabLayoutAdapter mAdapter;
    List<View> viewList = new ArrayList<>();
    List<InfoBean> beanList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager__tab_layout);
        mTabLayout = findViewById(R.id.tlTabLayoutView);
        mViewPager = findViewById(R.id.vpViewPagerView);
        initBean();
        initTab();
        withViewPager();

    }


    public void initBean() {
        //首先创建数据bean类
        for (int i = 0; i < 6; i++) {
            beanList.add(new InfoBean("view" + i, "tab" + i));
        }
    }

    public void initTab() {
        for (int i = 0; i < beanList.size(); i++) {
            //注意这里from里面得参数是 mTabLayout.getContext() tabLayout 的参数
            //这样我们的自定义tab就创建好了
            View view = LayoutInflater.from(mTabLayout.getContext()).inflate(R.layout.custom_tablayout, mTabLayout, false);
            //这里我们将我们的自定义view存放起来，这是为了下面用的
            viewList.add(view);
            //获取自定义tab里面的textView
            TextView textView = view.findViewById(R.id.tvCustomText);
            //将我们的数据bean类的内容（tabName），存进textView中
            textView.setText(beanList.get(i).getTabName());
            //创建一个tab（mTabLayout.newTab()），然后使用 setCustomView 将我们刚刚自定义的 tab 的 view 存放进去
            TabLayout.Tab tab = mTabLayout.newTab().setCustomView(view);
            //将我们创建的 tab 添加进 TabLayout 中
            mTabLayout.addTab(tab);
        }
    }

    public void withViewPager() {
        //我们实例化 ViewPagerTabLayoutAdapter ，将我们的数据bean集合 和 系定义 view 集合存放进去,这里我们就用到了 viewList 。
        //这里是因为下面由于下面需要重新使用 setupWithViewPager 方法因此我们需要使用自定义的view
        mAdapter = new ViewPagerTabLayoutAdapter(getSupportFragmentManager(), beanList, viewList);
        //viewPager 和 Adapter 进行绑定
        mViewPager.setAdapter(mAdapter);
        //我们要注意，如果我们使用了 setupWithViewPager 之后 我们自定义的tab会被抹去必须重新调用一下各个tab的setCustomView方法
        //那么设置 setupWithViewPager 这个的方法是为什么呢，为了可以平滑的移动tab如果不用这个方法，我们滑动页面tab是没有反应的
        mTabLayout.setupWithViewPager(mViewPager);
        //我们自定义的tab会被抹去必须重新调用一下各个tab的setCustomView方法
        for (int i = 0; i < mTabLayout.getTabCount(); i++) {
            mTabLayout.getTabAt(i).setCustomView(mAdapter.getTabList(i));
        }
        //这是让tab 填充整个横面屏幕的方法（用这个MODE_FIXED）
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mViewPager.setCurrentItem(2);
        //这是tab的监听事件
        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                //这里是选中某个tab 的方法
                //我们从我们自定义的view中获取textView，然后给他设置 Selected
                final TextView myTv = tab.getCustomView().findViewById(R.id.tvCustomText);
//                final View viewUnderLine = tab.getCustomView().findViewById(R.id.viewUnderLine);
                myTv.setSelected(true);
//                viewUnderLine.setSelected(true);
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }


//    ObjectAnimator animator;
//    TextView textView1;
//    TextView textView2;
//    ValueAnimator valueAnimator1;
//    ValueAnimator valueAnimator2;
//
//
//    public void withViewPager2() {
//        mAdapter = new ViewPagerTabLayoutAdapter(getSupportFragmentManager(), beanList);
//        mViewPager.setAdapter(mAdapter);
//        mTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//
//            }
//        });
//        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
//            @Override
//            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
//
//            }
//
//            @Override
//            public void onPageSelected(int position) {
//                mTabLayout.getTabAt(position).select();
//
//            }
//
//            @Override
//            public void onPageScrollStateChanged(int state) {
//
//            }
//        });
//
//    }
//
//
//    public void onSelect(TabLayout.Tab tab) {
//        textView1 = tab.getCustomView().findViewById(R.id.tvCustomText);
//        valueAnimator1 = ValueAnimator.ofFloat(20, 30);
//        valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                textView1.setTextSize((Float) animation.getAnimatedValue());
//            }
//        });
//        valueAnimator1.start();
//        if (textView2 != null && valueAnimator2 != null) {
//            valueAnimator2 = ValueAnimator.ofFloat(30, 20);
//            valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    textView2.setTextSize((Float) animation.getAnimatedValue());
//                }
//            });
//            valueAnimator2.start();
//        }
//        mViewPager.setCurrentItem(tab.getPosition());
//    }
//
//    public void onUnselected(TabLayout.Tab tab) {
//        textView2 = tab.getCustomView().findViewById(R.id.tvCustomText);
//        valueAnimator2 = ValueAnimator.ofFloat(30, 20);
//        valueAnimator2.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//            @Override
//            public void onAnimationUpdate(ValueAnimator animation) {
//                textView2.setTextSize((Float) animation.getAnimatedValue());
//            }
//        });
//        valueAnimator2.start();
//
//        if (textView1 != null && valueAnimator1 != null) {
//            valueAnimator1 = ValueAnimator.ofFloat(20, 30);
//            valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
//                @Override
//                public void onAnimationUpdate(ValueAnimator animation) {
//                    textView1.setTextSize((Float) animation.getAnimatedValue());
//                }
//            });
//            valueAnimator1.start();
//        }
//    }
}