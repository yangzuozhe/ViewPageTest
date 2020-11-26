package com.example.viewpagetest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpagetest.R;

public class ViewPagerTabLayoutFragment extends Fragment {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String NAME = "NAME";
    private int mPage;
    private String mName;
    public static ViewPagerTabLayoutFragment newInstance(int page,String name) {
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        args.putString(NAME,name);
        ViewPagerTabLayoutFragment fragment = new ViewPagerTabLayoutFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
            mName = getArguments().getString(NAME);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_tablayout_item, null);
        TextView textView = view.findViewById(R.id.tvCustomText);
        textView.setText("Fragment #" + mPage+mName);
        return view;
    }


}
