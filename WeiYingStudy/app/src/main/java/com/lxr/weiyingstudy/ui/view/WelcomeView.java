package com.lxr.weiyingstudy.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.lxr.weiyingstudy.R;
import com.lxr.weiyingstudy.base.RootView;
import com.lxr.weiyingstudy.component.ImageLoader;
import com.lxr.weiyingstudy.presenter.contract.WelcomeContract;
import com.lxr.weiyingstudy.ui.activity.WelcomeActivity;
import com.lxr.weiyingstudy.utils.EventUtil;
import com.lxr.weiyingstudy.utils.JumpUtil;
import com.lxr.weiyingstudy.utils.Preconditions;
import com.lxr.weiyingstudy.utils.StringUtils;

import java.util.List;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class WelcomeView extends RootView<WelcomeContract.Presenter> implements WelcomeContract.View {
    @BindView(R.id.iv_welcome_bg)
    ImageView ivWelcomeBg;
    private WelcomeContract.Presenter mPresenter;

    public WelcomeView(Context context) {
        super(context);
    }

    public WelcomeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean isActive() {
        return mActive;
    }

    @Override
    public void showContent(List<String> list) {
        if (list != null) {
            int page = StringUtils.getRandomNumber(0, list.size() - 1);
            ImageLoader.load(mContext, list.get(page), ivWelcomeBg);
            ivWelcomeBg.animate().scaleX(1.12f).scaleY(1.12f).setDuration(2000).setStartDelay(100).start();
        }

    }

    @Override
    public void jumpToMain() {
        JumpUtil.go2MainActivity(mContext);
        ((WelcomeActivity) mContext).overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    @Override
    public void setPresenter(WelcomeContract.Presenter presenter) {
        mPresenter = Preconditions.checkNotNull(presenter);
    }

    @Override
    public void showError(String msg) {
        EventUtil.showToast(mContext, msg);
    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.activity_welcome_view, this);
    }
}
