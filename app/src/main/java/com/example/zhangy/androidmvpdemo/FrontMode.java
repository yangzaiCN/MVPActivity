package com.example.zhangy.androidmvpdemo;

import android.app.Activity;
import android.os.SystemClock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangy on 2016/5/5.
 * <p/>
 * MVP中的M层，处理网络请求，数据解析、数据封装，与Bean、presenter交互
 */
public class FrontMode {
    /**
     * author : zhangy
     * <p/>
     * des : 这里的数据请求可以换成volley、okHttp.
     * <p/>
     * date : 2016/5/5
     */
    public List requestData(final Activity activity, final RequestListener listener) {
        final ArrayList datas = new ArrayList();
        //模拟数据请求
        new Thread(new Runnable() {

            @Override
            public void run() {
                SystemClock.sleep(2000);//模拟耗时
                datas.add("pfg");
                datas.add("124");
                datas.add("234");
                datas.add("456");
                datas.add("567");

                if (datas.isEmpty()) {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listener.onFail();
                        }
                    });
                } else {
                    activity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            listener.onSucces(datas);
                        }
                    });
                }
            }
        }).start();
        return datas;
    }
}
