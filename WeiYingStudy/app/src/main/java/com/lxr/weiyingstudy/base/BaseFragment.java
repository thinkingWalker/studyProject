package com.lxr.weiyingstudy.base;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.lxr.weiyingstudy.R;
import com.lxr.weiyingstudy.ui.fragment.MineFragment;
import com.lxr.weiyingstudy.utils.ScreenUtil;
import com.lxr.weiyingstudy.widget.theme.ColorRelativeLayout;

import org.simple.eventbus.EventBus;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public abstract class BaseFragment<T extends BasePresenter> extends SupportFragment {
    protected Context mContext;
    protected View rootView;
    private Unbinder unbinder;

    @Override
    public void onAttach(Context mContext) {
        super.onAttach(mContext);
        if (mContext != null) {
            this.mContext = mContext;
        } else {
            this.mContext = getActivity();
        }
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(getLayout(), container, false);
        }
        ViewGroup parent = (ViewGroup) rootView.getParent();
        if (parent != null) {
            parent.removeView(rootView);
        }
        unbinder = ButterKnife.bind(this, rootView);
        initView(inflater);
        EventBus.getDefault().register(this);
        setTitleHeight(rootView);
        return rootView;

    }

    private final String TAG = getClass().getSimpleName();

    private void setTitleHeight(View view) {

        }
    private void initView(LayoutInflater inflater) {

    }

    protected abstract int getLayout();
}
