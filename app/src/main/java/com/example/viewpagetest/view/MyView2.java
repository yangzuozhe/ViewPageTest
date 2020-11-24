package com.example.viewpagetest.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.viewpagetest.R;
import com.example.viewpagetest.ToastUtils;

/**
 * 类描述
 *
 * @author HB.yangzuozhe
 * @date 2020-11-24
 */
public class MyView2 extends FrameLayout {
    public MyView2(@NonNull Context context) {
        this(context, null);
    }

    public MyView2(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MyView2(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        inflate(getContext(), R.layout.xml_page2, this);
        Button button = findViewById(R.id.btnView2);
        button.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                ToastUtils.show(getContext(), "我是view2");
            }
        });
    }
}
