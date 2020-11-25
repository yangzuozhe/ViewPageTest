package com.example.viewpagetest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpagetest.R;

/**
 * 类描述
 *
 * @author HB.yangzuozhe
 * @date 2020-11-24
 */
public class MyFragment1 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xml_page1, null);
        return view;
    }

    /**
     * 推荐使用这个方法（或者getInstance）来获得Fragment1，而不是使用构造方法
     */
    public static MyFragment1 newInstance() {
        Bundle args = new Bundle();
        MyFragment1 fragment = new MyFragment1();
        fragment.setArguments(args);
        return fragment;
    }

}
