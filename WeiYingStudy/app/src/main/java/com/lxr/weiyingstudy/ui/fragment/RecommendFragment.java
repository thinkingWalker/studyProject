package com.lxr.weiyingstudy.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.lxr.weiyingstudy.R;
import com.lxr.weiyingstudy.base.BaseFragment;
import com.lxr.weiyingstudy.ui.view.RecommendView;

import butterknife.BindView;

/**
 * Created by Administrator on 2017/2/28 0028.
 */
public class RecommendFragment extends BaseFragment {

    @BindView(R.id.one_view)
    RecommendView oneView;


    @Override
    protected int getLayout() {
        return R.layout.fragment_recommend;

    }
}
