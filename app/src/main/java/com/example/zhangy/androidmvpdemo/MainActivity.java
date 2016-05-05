package com.example.zhangy.androidmvpdemo;

import android.os.Bundle;
import android.widget.ListView;

import com.example.zhangy.androidmvpdemo.activity.BaseMVPActivity;

public class MainActivity extends BaseMVPActivity<MainPresenter, MainUI> implements MainUI {

    private ListView mListView;
    private MainPresenter mainPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.list_view);
        loadData();
    }

    @Override
    public void loadData() {
        mainPresenter.loadData();
    }

    @Override
    protected MainPresenter createPresenter() {
        mainPresenter = new MainPresenter(false);
        return mainPresenter;
    }

    @Override
    protected MainUI getUi() {
        return this;
    }


    @Override
    public ListView getListView() {
        return mListView;
    }
}
