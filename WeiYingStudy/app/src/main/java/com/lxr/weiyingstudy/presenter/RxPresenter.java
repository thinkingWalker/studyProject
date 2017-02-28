package com.lxr.weiyingstudy.presenter;

import com.lxr.weiyingstudy.base.BasePresenter;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class RxPresenter<T> implements BasePresenter<T> {

    protected T mView;
    protected CompositeSubscription mCompositeSubscription;


    public void unSubscribe(){
        if (mCompositeSubscription!=null){
            mCompositeSubscription.unsubscribe();
        }
    }
    protected void addSubscribe(Subscription subscription) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeSubscription();
        }
        mCompositeSubscription.add(subscription);
    }
    @Override
    public void attachView(T view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
        unSubscribe();
    }
}
