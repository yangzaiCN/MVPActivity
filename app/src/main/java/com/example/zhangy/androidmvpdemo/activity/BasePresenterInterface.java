package com.example.zhangy.androidmvpdemo.activity;

import android.os.Bundle;

/**
 * Created by zhangy on 2016/4/15.
 */
public interface BasePresenterInterface {

    /**
     * onCreate:对应生命周期方法onCreate(). <br/>
     * @author zhangy
     */
    void onCreate(Bundle bundle);

    /**
     * onStart:对应生命周期方法onStart(). <br/>
     * @author zhangy
     */
    void onStart();

    /**
     * onResume:对应生命周期方法onResume(). <br/>
     * @author zhangy
     */
    void onResume();

    /**
     * onPause:对应生命周期方法onPause(). <br/>
     * @author zhangy
     */
    void onPause();

    /**
     * onDestroy:对应生命周期方法onDestroy(). <br/>
     * @author zhangy
     */
    void onDestroy();

    /**
     * onStop:对应生命周期方法onStop(). <br/>
     * @author zhangy
     */
    void onStop();

}
