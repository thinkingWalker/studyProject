package com.lxr.weiyingstudy.presenter.contract;

import com.lxr.weiyingstudy.base.BasePresenter;
import com.lxr.weiyingstudy.base.BaseView;

import java.util.List;

/**
 * Created by Admin on 2017/2/28  17:16
 *
 * @desc
 */
public interface WelcomeContract {

    interface View extends BaseView<Presenter>{
        boolean isActive();

        void showContent(List<String> list);

        void jumpToMain();
    }

    interface Presenter extends BasePresenter{
        void getWelcomeData();
    }

}
