package com.example.zhangy.androidmvpdemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

/**
 * Created by zhangy on 2016/4/15.
 */
public abstract class BaseMVPFragment <T extends BasePresenter<U>, U extends BaseUI> extends Fragment {

    private T mPresenter;

    protected abstract T createPresenter();

    protected abstract U getUi();

    public T getPresenter() {
        return mPresenter;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mPresenter = createPresenter();
        mPresenter.onFragmentAttach(activity, this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    /**
     * @author ：zhangy
     *
     * @description : 绑定具体Fragment或Activity中具体的UI
     *
     *  DATE : 2016/4/15
     */
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mPresenter.onUiReady(getUi(), getActivity());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        mPresenter.onUiDestroy(getUi());
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.onCreate(genBundle(savedInstanceState));
    }

    /**
     * @author ：zhangy
     *
     * @description : 将savedInstanceState 和 getArguments() 合成一个Bundle
     *
     *  DATE : 2016/4/15
     */
    private Bundle genBundle(Bundle savedInstanceState) {
        if (null != savedInstanceState) {
            if (null != getArguments()) {
                savedInstanceState.putAll(getArguments());
            }
            return savedInstanceState;
        } else {
            return getArguments();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        mPresenter.onStop();
    }

    @Override
    public void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.onPause();
    }
}
