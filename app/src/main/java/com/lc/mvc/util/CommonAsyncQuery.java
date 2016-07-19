package com.lc.mvc.util;

import android.content.AsyncQueryHandler;
import android.content.ContentResolver;
import android.database.Cursor;
import android.util.Log;
import android.widget.CursorAdapter;
/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-18
 */
public class CommonAsyncQuery extends AsyncQueryHandler {

	private static final String TAG = "CommonAsyncQuery";
	private OnQueryNotifyCompleteListener mOnQueryNotifyCompleteListener;

	public CommonAsyncQuery(ContentResolver cr) {
		super(cr);
	}

	/**
	 * 异步查询时返回结果时的回调,这个回调还在子线程中
	 * @param token
	 * @param cookie
	 * @param cursor
     */
	@Override
	protected void onQueryComplete(int token, Object cookie, Cursor cursor) {
		if(mOnQueryNotifyCompleteListener != null) {
			mOnQueryNotifyCompleteListener.onPreNotify(token, cookie, cursor);
		}
		
		if(cookie != null) {
			notifyAdapter((CursorAdapter) cookie, cursor);
		}
		
		if(mOnQueryNotifyCompleteListener != null) {
			mOnQueryNotifyCompleteListener.onPostNotify(token, cookie, cursor);
		}
	}
	
	private void notifyAdapter(CursorAdapter adapter, Cursor cursor) {
		adapter.changeCursor(cursor);
	}
	
	public void setOnQueryNotifyCompleteListener(OnQueryNotifyCompleteListener l) {
		this.mOnQueryNotifyCompleteListener = l;
	}
	
	public interface OnQueryNotifyCompleteListener {
		void onPreNotify(int token, Object cookie, Cursor cursor);
		void onPostNotify(int token, Object cookie, Cursor cursor);
	}
}
