package com.example.zhangy.androidmvpdemo.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

/**
 * Created by zhangy on 2016/4/15.
 * <p/>
 * des : 将presenter与UI层绑定
 */
public abstract class BaseMVPActivity<T extends BasePresenter<U>, U extends BaseUI> extends FragmentActivity {//泛型控制，保证每个V层都有对应的P层
    //要绑定的Presenter，每个Activity都会有一个与自己对应的Presenter
    private T mPresenter;

    protected abstract T createPresenter();
    //这里的U是一个接口，定义了我们要返回的UI，例如，activity中有ListView，fragment，TextView等等，我们如果想暴露给外面，可以在这个接口中声明
    protected abstract U getUi();

    public T getPresenter() {
        return mPresenter;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter = createPresenter();//创建Presenter
        mPresenter.onUiReady(getUi(), this);//给 P 层传递我们的 V 层（MVP）
        mPresenter.onCreate(getIntent().getExtras());
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.onStart();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onUiDestroy(getUi());
        mPresenter.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mPresenter.onStop();
    }
}
