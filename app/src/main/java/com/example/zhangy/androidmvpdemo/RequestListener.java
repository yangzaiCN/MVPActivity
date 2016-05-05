package com.example.zhangy.androidmvpdemo;


import java.util.List;

/**
 * Created by reborn on 2016/5/5.
 */
public interface RequestListener {

   void onSucces(List datas);

    void onFail();
}
