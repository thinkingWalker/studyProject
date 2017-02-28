package com.lxr.weiyingstudy;

import android.os.Bundle;

import butterknife.ButterKnife;

/**
 * Created by Admin on 2017/2/28  15:40
 *
 * @desc
 */
public class WelcomeActivity  extends BaseActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        unbinder = ButterKnife.bind(this);
        mPresenter = new WelcomePresenter(welcomeView);
    }
}
