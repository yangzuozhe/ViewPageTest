package com.example.viewpagetest.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.viewpagetest.R;
import com.example.viewpagetest.bean.infoBean;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerTabLayoutFragment extends Fragment implements View.OnClickListener {
    public static final String ARG_PAGE = "ARG_PAGE";
    public static final String NAME = "NAME";
    private int mPage;
    private infoBean mInfoBean;
    private Button mMyButton;

    /**
     * 他推荐用newInstance方法来获取取Fragment对象以及传值
     */
    public static ViewPagerTabLayoutFragment newInstance(int page, infoBean info) {
        //用Bundle存值
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, page);
        //数据bean类用 putSerializable
        args.putSerializable(NAME, info);
        //实例化本Fragment
        ViewPagerTabLayoutFragment fragment = new ViewPagerTabLayoutFragment();
        //将我们的Bundle用 setArguments 存进Fragment
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //在初始化Fragment的时候获取值
        if (getArguments() != null) {
            mPage = getArguments().getInt(ARG_PAGE);
            mInfoBean = (infoBean) getArguments().getSerializable(NAME);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewpager_tablayout_item, null);
        initView(view);
        return view;
    }

    Button myBtn2;
    Button myBtn3;
    List<Button> buttonList;

    public void initView(View view) {
        mMyButton = view.findViewById(R.id.myBtn);
        myBtn2 = view.findViewById(R.id.myBtn2);
        myBtn3 = view.findViewById(R.id.myBtn3);
        mMyButton.setOnClickListener(this);
        myBtn2.setOnClickListener(this);
        myBtn3.setOnClickListener(this);
        buttonList = new ArrayList<>();
        buttonList.add(mMyButton);
        buttonList.add(myBtn2);
        buttonList.add(myBtn3);
        TextView textView = view.findViewById(R.id.tvCustomText);
        textView.setText("Fragment #" + mPage + mInfoBean.getName());
    }


    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.myBtn) {
            clickButton(mMyButton);
        } else if (v.getId() == R.id.myBtn2) {
            clickButton(myBtn2);
        } else if (v.getId() == R.id.myBtn3) {
            clickButton(myBtn3);
        }
    }

    public void clickButton(Button button) {
        for (Button btn : buttonList) {
            btn.setSelected(false);
        }
        button.setSelected(true);
    }

}
