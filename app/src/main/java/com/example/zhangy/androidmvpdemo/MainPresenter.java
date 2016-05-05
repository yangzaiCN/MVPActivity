package com.example.zhangy.androidmvpdemo;

import android.widget.ArrayAdapter;

import com.example.zhangy.androidmvpdemo.activity.BasePresenter;

import java.util.List;

/**
 * Created by zhangy on 2016/5/5.
 */
public class MainPresenter extends BasePresenter<MainUI> {
    /** Mode层管理类 */
    private FrontMode frontMode;

    public MainPresenter(boolean isFragment) {
        super(isFragment);
        frontMode = new FrontMode();//创建一个Mode层管理类
    }

    public void loadData() {
        /** 让Mode管理层去处理数据的请求，解析，我们只处理回调 */
        frontMode.requestData(getActivity(), new RequestListener() {
            @Override
            public void onSucces(List datas) {
                setDatas(datas);
            }
            @Override
            public void onFail() {

            }
        });
    }
    /**
     * author : zhangy
     *
     * des : 给V层加载数据
     *
     * date : 2016/5/5
     */
    private void setDatas(List datas) {
        getUi().getListView().setAdapter(new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, datas));
    }
}
