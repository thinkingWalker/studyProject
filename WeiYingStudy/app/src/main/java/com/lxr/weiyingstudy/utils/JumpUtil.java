package com.lxr.weiyingstudy.utils;

import android.content.Context;
import android.content.Intent;

import com.lxr.weiyingstudy.ui.activity.MainActivity;
import com.lxr.weiyingstudy.ui.activity.WelcomeActivity;


/**
 * Description: JumpUtil
 * Creator: yxc
 * date: 2016/9/21 14:46
 */
public class JumpUtil {

    public static void go2MainActivity(Context context) {
        jump(context, MainActivity.class);
        ((WelcomeActivity) context).finish();
    }

    private static void jump(Context a, Class<?> clazz) {
        Intent intent = new Intent(a, clazz);
        a.startActivity(intent);
    }
}
