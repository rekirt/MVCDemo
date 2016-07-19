package com.lc.mvc.view;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TabHost;

import com.lc.mvc.R;
import com.lc.mvc.base.BaseActivity;
import com.lc.mvc.view.home.ConversationUI;
import com.lc.mvc.view.home.FolderUI;
import com.lc.mvc.view.home.GroupUI;

import butterknife.InjectView;
import butterknife.OnClick;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-18
 */
public class HomeActivity extends BaseActivity {

    @InjectView(android.R.id.tabhost)
    TabHost tabHost;

    @InjectView(R.id.slide_view)
    View slide_view;
    @InjectView(R.id.rl_conversation)
    RelativeLayout rl_conversation;
    @InjectView(R.id.ll_conversation)
    LinearLayout ll_conversation;
    @InjectView(R.id.ll_folder)
    LinearLayout ll_folder;
    @InjectView(R.id.ll_group)
    LinearLayout ll_group;

    int basicWidth;
    private int startX = 0;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_home);
        initTabHost();
    }

    private void initTabHost() {

        ll_conversation.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

            @Override
            public void onGlobalLayout() {
                ll_conversation.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                RelativeLayout.LayoutParams lp = (RelativeLayout.LayoutParams) slide_view.getLayoutParams();
                lp.width = ll_conversation.getWidth();
                lp.height = ll_conversation.getHeight();
                lp.leftMargin = ll_conversation.getLeft();
                slide_view.setLayoutParams(lp);
                basicWidth = rl_conversation.getWidth();
            }
        });
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

    @OnClick({R.id.ll_conversation,R.id.ll_folder,R.id.ll_group})
    public void click(View v){
        switch (v.getId()){
            case R.id.ll_conversation:
                if(!"conversation".equals(tabHost.getCurrentTabTag())) {
                    tabHost.setCurrentTabByTag("conversation");
                    startTranslateAnimation(startX, 0);
                    startX = 0;
                }
                break;
            case R.id.ll_folder:
                if(!"folder".equals(tabHost.getCurrentTabTag())) {
                    tabHost.setCurrentTabByTag("folder");
                    startTranslateAnimation(startX, basicWidth);
                    startX = basicWidth;
                }
                break;
            case R.id.ll_group:
                if(!"group".equals(tabHost.getCurrentTabTag())) {
                    tabHost.setCurrentTabByTag("group");
                    startTranslateAnimation(startX, basicWidth * 2);
                    startX = basicWidth * 2;
                }
                break;
        }
    }

    private void startTranslateAnimation(int fromXDelta, int toXDelta) {
        TranslateAnimation ta = new TranslateAnimation(fromXDelta, toXDelta, 0, 0);
        ta.setDuration(500);
        ta.setFillAfter(true);
        slide_view.startAnimation(ta);
    }

    @Override
    public void initData() {
        super.initData();

    }
}
