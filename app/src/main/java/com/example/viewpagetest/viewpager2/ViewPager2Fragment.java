package com.example.viewpagetest.viewpager2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpagetest.R;

public class ViewPager2Fragment extends Fragment {
    public static ViewPager2Fragment newInstance(String data) {

        Bundle args = new Bundle();
        args.putString("key",data);
        ViewPager2Fragment fragment = new ViewPager2Fragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = LayoutInflater.from(getContext()).inflate(R.layout.my_new_fragment, null);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            String data = bundle.getString("key", "aaa");
            TextView textView = view.findViewById(R.id.tvMyText);
            textView.setText(data);
        }
        return view;
    }
}
