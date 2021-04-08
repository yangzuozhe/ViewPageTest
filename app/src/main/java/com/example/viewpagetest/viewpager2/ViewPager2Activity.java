package com.example.viewpagetest.viewpager2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import com.example.viewpagetest.R;

import java.util.ArrayList;
import java.util.List;

public class ViewPager2Activity extends AppCompatActivity {
    List<String> stringList = new ArrayList<>();

    ViewPager2 vpViewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);
        vpViewPager2 = findViewById(R.id.vp2);
        //数据
        initData();
        //两种 adpter 二选一
        ViewPager2Adapter adapter = new ViewPager2Adapter(this,stringList);
        ViewPager2RecyclerAdapter recyclerAdapter = new ViewPager2RecyclerAdapter(stringList);
        vpViewPager2.setAdapter(recyclerAdapter);
    }
    private void initData(){
        stringList.add("我是第一页");
        stringList.add("我是第2页");
        stringList.add("我是第3页");
        stringList.add("我是第4页");
        stringList.add("我是第5页");
        stringList.add("我是第6页");
    }

}