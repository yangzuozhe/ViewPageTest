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
public class MyFragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xml_page2, null);
        return view;
    }

    public static MyFragment2 newInstance() {

        Bundle args = new Bundle();

        MyFragment2 fragment = new MyFragment2();
        fragment.setArguments(args);
        return fragment;
    }
}
