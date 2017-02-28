package com.lxr.weiyingstudy.base;

import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.lxr.weiyingstudy.App;
import com.lxr.weiyingstudy.base.BasePresenter;

import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Admin on 2017/2/28  16:33
 *
 * @desc
 */
public class BaseActivity<T extends BasePresenter> extends SupportActivity {

    protected Unbinder unbinder;
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        init();
    }

    private void init() {
        setTranslucentStatus(true);
        onPreCreate();
        App.getInstance().registerActivity(this);
    }

    @Override
    protected void onStart() {
        super.onStart();
//        setTitleHeight(getRootView(this));

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        App.getInstance().unregisterActivity(this);
        if (unbinder != null)
            unbinder.unbind();
        mPresenter = null;
    }

//    private void setTitleHeight(View view) {
//        if (view != null) {
//            ColorRelativeLayout title = (ColorRelativeLayout) view.findViewById(R.id.title);
//            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.KITKAT) {
//                if (title != null) {
//                    ViewGroup.LayoutParams lp = title.getLayoutParams();
//                    lp.height = ScreenUtil.dip2px(this, 48);
//                    title.setLayoutParams(lp);
//                    title.setPadding(0, 0, 0, 0);
//                }
//            }
//        }
//    }

    private void onPreCreate() {
//        Theme theme = PreUtils.getCurrentTheme(this);
//        switch (theme) {
//            case Blue:
//                setTheme(R.style.BlueTheme);
//                break;
//            case Red:
//                setTheme(R.style.RedTheme);
//                break;
//            case Brown:
//                setTheme(R.style.BrownTheme);
//                break;
//            case Green:
//                setTheme(R.style.GreenTheme);
//                break;
//            case Purple:
//                setTheme(R.style.PurpleTheme);
//                break;
//            case Teal:
//                setTheme(R.style.TealTheme);
//                break;
//            case Pink:
//                setTheme(R.style.PinkTheme);
//                break;
//            case DeepPurple:
//                setTheme(R.style.DeepPurpleTheme);
//                break;
//            case Orange:
//                setTheme(R.style.OrangeTheme);
//                break;
//            case Indigo:
//                setTheme(R.style.IndigoTheme);
//                break;
//            case LightGreen:
//                setTheme(R.style.LightGreenTheme);
//                break;
//            case Lime:
//                setTheme(R.style.LimeTheme);
//                break;
//            case DeepOrange:
//                setTheme(R.style.DeepOrangeTheme);
//                break;
//            case Cyan:
//                setTheme(R.style.CyanTheme);
//                break;
//            case BlueGrey:
//                setTheme(R.style.BlueGreyTheme);
//                break;
//            case Black:
//                setTheme(R.style.BlackTheme);
//                break;
//        }

    }



    /**
     * 设置沉浸式
     *
     * @param on
     */
    protected void setTranslucentStatus(boolean on) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window win = getWindow();
            WindowManager.LayoutParams winParams = win.getAttributes();
            final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            if (on) {
                winParams.flags |= bits;
            } else {
                winParams.flags &= ~bits;
            }
            win.setAttributes(winParams);
        }
    }
}
