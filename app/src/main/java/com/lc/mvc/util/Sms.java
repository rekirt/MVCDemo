package com.lc.mvc.util;

import android.net.Uri;
/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-18
 */
public class Sms {

	public static final Uri CONVERSATION_URI = Uri.parse("content://sms/conversations");
	public static final Uri SMS_URI = Uri.parse("content://sms/");
	public static final Uri INBOX_URI = Uri.parse("content://sms/inbox");
	public static final Uri OUTBOX_URI = Uri.parse("content://sms/outbox");
	public static final Uri SENT_URI = Uri.parse("content://sms/sent");
	public static final Uri DRAFT_URI = Uri.parse("content://sms/draft");
	
	public static final int RECEVIE_TYPE = 1;
	public static final int SEND_TYPE = 2;
	
}
