package com.lc.mvc.receiver;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;
/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-18
 */
public class ReceiveSmsBroadcastReceive extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {

		int resultCode = getResultCode();
		if(resultCode == Activity.RESULT_OK) {
			Toast.makeText(context, "ok", Toast.LENGTH_SHORT).show();
		} else {
			Toast.makeText(context, "error", Toast.LENGTH_SHORT).show();
		}
	}

}
