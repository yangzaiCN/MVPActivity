package com.example.zhangy.androidmvpdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * Created by zhangy on 2016/4/15.
 */
public class BasePresenter <U extends BaseUI> implements BasePresenterInterface {

    /**
     * 是否是Fragment 备用
     */
    private boolean mIsFragment;
    /** 绑定的V层，有可能是Activity、Fragment */
    private U mUi;

    private Activity mActivity;

    private Fragment mFragment;

    public BasePresenter(boolean isFragment){
        super();
        mIsFragment = isFragment;
    }
    /** 在Fragment中绑定的V层 */
    public void onFragmentAttach(Activity activity, Fragment fragment) {
        mActivity = activity;
        mFragment = fragment;
    }
    /** 绑定Activity */
    public void onUiReady(U ui,Activity activity) {
        mUi = ui;
        mActivity = activity;
    }

    /**
     * @author ：zhangy
     *
     * @description : 在UI销毁时调用
     *
     *  DATE : 2016/4/15
     */
    public final void onUiDestroy(U ui) {
        onUiUnready(ui);
        mUi = null;
    }

    public U getUi() {
        return mUi;
    }

    public Activity getActivity() {
        return mActivity;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    /**
     * @author ：zhangy
     *
     * @description : 当Fragment或者Activity即将被销毁时调用，可用于取消监听事件、取消注册事件
     *
     *  DATE : 2016/4/15
     */
    public void onUiUnready(U ui) {
    }

    // 默认空实现Activity生命周期
    @Override
    public void onCreate(Bundle bundle) {

    }

    @Override
    public void onStart() {

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onStop() {

    }
}
