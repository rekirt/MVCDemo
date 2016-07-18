package com.lc.mvc.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.lc.mvc.R;
import com.lc.mvc.base.BaseActivity;
import com.lc.mvc.control.UserBussiness;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-4-5.
 */
public class WelcomeActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
              startActivity(new Intent(WelcomeActivity.this,HomeActivity.class));
            }
        },1000);
    }

    //    @Override
//    public void initView() {
//        setContentView(R.layout.activity_main);
//    }
//
//    @Override
//    public void initData() {
//        super.initData();
//        //执行网络请求
//        UserBussiness userBussiness = new UserBussiness(this);
//        userBussiness.setKey("login");
//        userBussiness.setData(new Object());
//        userBussiness.startRequest();
//    }
//
//    //没有网络时的回调
//    @Override
//    public void setNetWork() {
//        super.setNetWork();
//
//    }
//
//    //网络请求失败时的回调
//    @Override
//    public void onBusinessFail(int bCode, Object obj) {
//        super.onBusinessFail(bCode, obj);
//
//    }
//
//    //网络请求成功时的回调
//    @Override
//    public void onBusinessSucc(int bCode, Object obj) {
//        super.onBusinessSucc(bCode, obj);
//
//    }
}
