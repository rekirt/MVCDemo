package com.lc.mvc.base;

import android.app.Activity;
import android.app.TabActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import com.lc.mvc.control.IBaseBusiness;

import butterknife.ButterKnife;


/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-4-5.
 */
public class BaseActivity extends TabActivity implements BaseContainer,IBaseBusiness {

	protected Bundle instanceState;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		initTitle();
		instanceState = savedInstanceState;
		initIntentValue();
		initView();
		setListener();
		initData();
	}

	@Override
	public void setContentView(int layoutResID) {
		super.setContentView(layoutResID);
		ButterKnife.inject(this);
	}

	protected void initTitle() {
	}

	@Override
	public void initIntentValue() {

	}

	@Override
	public void initView() {

	}

	@Override
	public void setListener() {

	}

	@Override
	public void initData() {

	}

	@Override
	public void onBusinessSucc(int bCode, Object obj) {

	}

	@Override
	public void onBusinessFail(int bCode, Object obj) {

	}

	@Override
	public void setNetWork() {

	}

	@Override
	public void requestHandler(Object obj) {

	}
}
