package com.lxr.weiyingstudy.base;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Admin on 2017/2/28  17:03
 *
 * @desc
 */
public abstract class RootView<T extends BasePresenter> extends LinearLayout {

    protected Unbinder unbinder;
    protected T mPresenter;
    private Context mContext;
    private boolean mActive;

    public RootView(Context context) {
        this(context, null, 0);
    }

    public RootView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public RootView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    protected void init() {
        mContext = getContext();
        getLayout();
        unbinder = ButterKnife.bind(this);
        mActive = true;
        initView();
        initEvent();
    }

    protected abstract void initEvent();

    protected abstract void initView();

    protected abstract void getLayout();

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (mPresenter != null) {
            mPresenter.attachView(this);
        }
        mActive = true;
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (mPresenter != null)
            mPresenter.detachView();
        mActive = false;
        unbinder.unbind();
        mContext = null;
    }

}
