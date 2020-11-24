package com.example.viewpagetest;

import android.content.Context;
import android.widget.Toast;

/**
 * 类描述
 *
 * @author HB.yangzuozhe
 * @date 2020-11-24
 */
public class ToastUtils {
    public static void show(Context context,String name) {
        Toast.makeText(context, name,Toast.LENGTH_SHORT).show();
    }

}
