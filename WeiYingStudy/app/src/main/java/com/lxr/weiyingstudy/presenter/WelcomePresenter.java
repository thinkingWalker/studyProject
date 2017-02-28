package com.lxr.weiyingstudy.presenter;

import android.support.annotation.NonNull;

import com.lxr.weiyingstudy.presenter.contract.WelcomeContract;
import com.lxr.weiyingstudy.utils.Preconditions;
import com.lxr.weiyingstudy.utils.RxUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

/**
 * Created by Administrator on 2017/2/28 0028.
 */

public class WelcomePresenter extends RxPresenter implements WelcomeContract.Presenter {

    WelcomeContract.View mView;
    private static final int COUNT_DOWN_TIME = 2200;

    public WelcomePresenter(@NonNull WelcomeContract.View oneView) {
        mView = Preconditions.checkNotNull(oneView);
        mView.setPresenter(this);
        getWelcomeData();
    }
    @Override
    public void getWelcomeData() {
        mView.showContent(getImgData());
        startCountDown();
    }

    private void startCountDown() {
        Subscription rxSubscription = Observable.timer(COUNT_DOWN_TIME, TimeUnit.MILLISECONDS)
                .compose(RxUtil.<Long>rxSchedulerHelper())
                .subscribe(new Action1<Long>() {
                    @Override
                    public void call(Long aLong) {
                        mView.jumpToMain();
                    }
                });
        addSubscribe(rxSubscription);
    }

    private List<String> getImgData() {
        List<String> imgs = new ArrayList<>();
        imgs.add("file:///android_asset/a.jpg");
        imgs.add("file:///android_asset/b.jpg");
        imgs.add("file:///android_asset/c.jpg");
//        imgs.add("file:///android_asset/d.jpg");
        imgs.add("file:///android_asset/e.jpg");

        imgs.add("file:///android_asset/f.jpg");
        imgs.add("file:///android_asset/g.jpg");
        return imgs;
    }
}
