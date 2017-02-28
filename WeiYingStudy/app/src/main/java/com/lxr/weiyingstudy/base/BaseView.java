package com.lxr.weiyingstudy.base;

/**
 * Created by Admin on 2017/2/28  17:11
 *
 * @desc
 */
public interface BaseView<T> {
    void setPresenter(T presenter);

    void showError(String msg);
}