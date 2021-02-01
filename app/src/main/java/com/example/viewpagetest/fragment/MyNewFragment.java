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
import com.example.viewpagetest.bean.InfoBean;

/**
 * 我的新的Fragment
 *
 * @author HB.yangzuozhe
 * @date 2021-02-01
 */
public class MyNewFragment extends Fragment {
    public static final String KEY_MY_BEAN = "KEY_MY_BEAN";
    InfoBean mInfoBean;

    public static MyNewFragment newInstance(InfoBean bean) {
        //实例化本Fragment
        MyNewFragment fragment = new MyNewFragment();
        //用Bundle存值
        Bundle args = new Bundle();
        //数据bean类用 putSerializable
        args.putSerializable(KEY_MY_BEAN, bean);
        //将我们的Bundle用 setArguments 存进Fragment
        fragment.setArguments(args);
        return fragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.my_new_fragment, container, false);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            mInfoBean = (InfoBean) bundle.getSerializable(KEY_MY_BEAN);
            TextView textView = view.findViewById(R.id.tvMyText);
            textView.setText(mInfoBean.getName());
        }
        return view;
    }
}
