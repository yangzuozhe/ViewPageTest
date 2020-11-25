package com.example.viewpagetest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpagetest.R;

public class MyFragment3 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.xml_page3,null);
        return view;
    }

    public static MyFragment3 newInstance() {
        Bundle args = new Bundle();
        MyFragment3 fragment = new MyFragment3();
        fragment.setArguments(args);
        return fragment;
    }
}
