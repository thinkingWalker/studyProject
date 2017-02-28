package com.lxr.weiyingstudy.ui.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lxr.weiyingstudy.R;
import com.lxr.weiyingstudy.base.BaseActivity;

import butterknife.ButterKnife;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        unbinder = ButterKnife.bind(this);
    }
}
