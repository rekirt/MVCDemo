package com.lc.mvc.view.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.widget.TextView;

import com.lc.mvc.base.BaseActivity;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-18
 * 文件夹
 */
public class FolderUI extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("文件夹");
        setContentView(tv);
    }
}
