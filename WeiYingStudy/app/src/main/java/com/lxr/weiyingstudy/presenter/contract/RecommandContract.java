package com.lxr.weiyingstudy.presenter.contract;

import com.lxr.weiyingstudy.base.BasePresenter;
import com.lxr.weiyingstudy.base.BaseView;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public interface RecommandContract {

    interface View extends BaseView<Presenter>{
        boolean isActive();
        void showContent();
        void refreshFaild(String msg);
        void stopBanner(boolean stop);
    }


    interface Presenter extends BasePresenter{
        void onRefresh();
    }
}
