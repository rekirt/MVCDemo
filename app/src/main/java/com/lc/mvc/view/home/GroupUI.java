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
 * 群组
 */
public class GroupUI extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("群组");
        setContentView(tv);
    }
}
