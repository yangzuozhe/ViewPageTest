//package com.example.viewpagetest.activity;
//
//import androidx.appcompat.app.AppCompatActivity;
//import androidx.fragment.app.Fragment;
//import androidx.fragment.app.FragmentManager;
//import androidx.fragment.app.FragmentTransaction;
//
//import android.os.Bundle;
//import android.widget.FrameLayout;
//
//import com.example.viewpagetest.R;
//import com.example.viewpagetest.fragment.MyFragment1;
//import com.example.viewpagetest.fragment.MyFragment2;
//import com.example.viewpagetest.fragment.MyFragment3;
//import com.google.android.material.tabs.TabLayout;
//
//public class TabLayoutActivity extends AppCompatActivity {
//    TabLayout mTlMyTab;
//    FrameLayout mFlMyFl;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_tab_layout);
//        mTlMyTab = findViewById(R.id.tlMyTab);
//        mFlMyFl = findViewById(R.id.flMyFl);
//        //通过 TabLayout 的 newTab 方法 创建一个新的 tab 标签
//
//        TabLayout.Tab tab1 = mTlMyTab.newTab();
//        //我们可以给这个标签命名
//        tab1.setText("你好");
//        //将我们要添加的tag存放进tab中，在TabLayout的点击事件中将其取出来。
//        tab1.setTag(MyFragment1.newInstance());
//
//        TabLayout.Tab tab2 = mTlMyTab.newTab();
//        //我们也可以给标签放图片
//        tab2.setIcon(R.drawable.ic_launcher_background);
//        tab2.setTag(MyFragment2.newInstance());
//
//        TabLayout.Tab tab3 = mTlMyTab.newTab();
//        //我们还可以自定义xml布局文件给tabLayout标签
//        tab3.setCustomView(R.layout.custom_tablayout);
//        tab3.setTag(MyFragment3.newInstance());
//
//        //然后我们用 TabLayout 的 addTab 方法将
//        mTlMyTab.addTab(tab1);
//        mTlMyTab.addTab(tab2);
//        mTlMyTab.addTab(tab3);
//        replaceFragment(MyFragment1.newInstance(), R.id.flMyFl);
//
//        mTlMyTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//            @Override
//            public void onTabSelected(TabLayout.Tab tab) {
//                //选中某个tab
//                replaceFragment((Fragment) tab.getTag(), R.id.flMyFl);
//            }
//
//            @Override
//            public void onTabUnselected(TabLayout.Tab tab) {
//                //当tab从选择到未选择
//
//            }
//
//            @Override
//            public void onTabReselected(TabLayout.Tab tab) {
//                //已经选中tab后的重复点击tab
//
//            }
//        });
//    }
//
//    /**
//     * 用来将碎片添加到 父布局 FrameLayout 中
//     *
//     * @param fragment 需要添加的碎片类
//     * @param parentId 父布局的id
//     */
//    public void replaceFragment(Fragment fragment, int parentId) {
//        FragmentManager manager = getSupportFragmentManager();
//        FragmentTransaction transaction = manager.beginTransaction();
//        transaction.replace(parentId, fragment);
//        //这句话让碎片有返回栈，没有这个的话，就相当于之前的碎片就被消除了，按下返回键直接退出程序了
//        //这里我们不加，这样就可以点击返回就退出了
////        transaction.addToBackStack(null);
//        transaction.commit();
//    }
//}