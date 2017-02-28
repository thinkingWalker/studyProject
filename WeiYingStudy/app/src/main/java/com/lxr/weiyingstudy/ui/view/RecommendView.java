package com.lxr.weiyingstudy.ui.view;

import android.content.Context;
import android.util.AttributeSet;

import com.lxr.weiyingstudy.R;
import com.lxr.weiyingstudy.base.RootView;
import com.lxr.weiyingstudy.presenter.contract.RecommandContract;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class RecommendView extends RootView<RecommandContract.Presenter> implements RecommandContract.View {
    public RecommendView(Context context) {
        super(context);
    }

    public RecommendView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public void setPresenter(RecommandContract.Presenter presenter) {

    }

    @Override
    public void showError(String msg) {

    }

    @Override
    protected void initEvent() {

    }

    @Override
    protected void initView() {

    }

    @Override
    protected void getLayout() {
        inflate(mContext, R.layout.fragment_recommend_view, this);

    }

    @Override
    public boolean isActive() {
        return false;
    }

    @Override
    public void showContent() {

    }

    @Override
    public void refreshFaild(String msg) {

    }

    @Override
    public void stopBanner(boolean stop) {

    }
}
