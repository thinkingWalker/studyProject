package com.lxr.weiyingstudy.ui.activity;

import android.os.Bundle;

import com.lxr.weiyingstudy.R;
import com.lxr.weiyingstudy.base.BaseActivity;
import com.lxr.weiyingstudy.presenter.WelcomePresenter;
import com.lxr.weiyingstudy.ui.view.WelcomeView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/2/28  15:40
 *
 * @desc
 */
public class WelcomeActivity  extends BaseActivity {
    @BindView(R.id.welcome_view)
    WelcomeView welcomeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        unbinder = ButterKnife.bind(this);
        mPresenter = new WelcomePresenter(welcomeView);
    }
}
