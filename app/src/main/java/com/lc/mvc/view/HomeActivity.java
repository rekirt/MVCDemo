package com.lc.mvc.view;

import android.content.Intent;
import android.util.Log;
import android.widget.TabHost;

import com.lc.mvc.R;
import com.lc.mvc.base.BaseActivity;
import com.lc.mvc.view.home.ConversationUI;
import com.lc.mvc.view.home.FolderUI;
import com.lc.mvc.view.home.GroupUI;

import butterknife.InjectView;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-18
 */
public class HomeActivity extends BaseActivity {

    @InjectView(android.R.id.tabhost)
    TabHost tabHost;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_home);
        initTabHost();
    }

    private void initTabHost() {
        addTabSpec("conversation","回话",R.drawable.tab_icon_a,new Intent(this, ConversationUI.class));
        addTabSpec("folder","文件夹",R.drawable.tab_icon_b,new Intent(this, FolderUI.class));
        addTabSpec("group","群组",R.drawable.tab_icon_c,new Intent(this, GroupUI.class));
    }

    private void addTabSpec(String tag, String label, int icon, Intent intent){
        TabHost.TabSpec newTabSpec =  tabHost.newTabSpec(tag);
        //设置标题和图标
        newTabSpec.setIndicator(label,getResources().getDrawable(icon));
        //添加显示内容的activity
        newTabSpec.setContent(intent);
        Log.e("test",tabHost+"==="+newTabSpec);
        //添加标签
        try {
            tabHost.addTab(newTabSpec);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void initData() {
        super.initData();

    }
}
