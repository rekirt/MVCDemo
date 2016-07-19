package com.lc.mvc.view.home;

import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.text.format.DateFormat;
import android.text.format.DateUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CursorAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.lc.mvc.R;
import com.lc.mvc.base.BaseActivity;
import com.lc.mvc.util.CommonAsyncQuery;
import com.lc.mvc.util.Sms;
import com.lc.mvc.util.Utils;

import java.util.HashSet;

import butterknife.ButterKnife;
import butterknife.InjectView;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-7-18
 * 回话
 */
public class ConversationUI extends FragmentActivity implements AdapterView.OnItemClickListener {

    @InjectView(R.id.btn_conversation_new_message)
    Button btn_conversation_new_message;
    @InjectView(R.id.btn_conversation_select_all)
    Button btn_conversation_select_all;
    @InjectView(R.id.btn_conversation_cancel_select)
    Button btn_conversation_cancel_select;
    @InjectView(R.id.lv_conversation)
    ListView lv_conversation;
    @InjectView(R.id.btn_conversation_delete_message)
    Button btn_conversation_delete_message;


    private final int LIST_STATE = -1;
    private final int EDIT_STATE = -2;
    private int currentState = LIST_STATE;

    private String[] projection = {
            "sms.group_id AS _id",
            "sms.body AS body",
            "groups.msg_count AS count",
            "sms.date AS date",
            "sms.address AS address"
    };
    private final int THREAD_ID_COLUMN_INDEX = 0;
    private final int BODY_COLUMN_INDEX = 1;
    private final int COUNT_COLUMN_INDEX = 2;
    private final int DATE_COLUMN_INDEX = 3;
    private final int ADDRESS_COLUMN_INDEX = 4;
    private ConversationAdapter mAdapter;
    private HashSet<Integer> mMultiDeleteSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.conversation);
        ButterKnife.inject(this);
        initView();
        prepareData();
    }

    private void initView() {
        mMultiDeleteSet = new HashSet<Integer>();

        mAdapter = new ConversationAdapter(this, null);
        lv_conversation.setAdapter(mAdapter);
        lv_conversation.setOnItemClickListener(this);
    }
    private void prepareData() {
        CommonAsyncQuery asyncQuery = new CommonAsyncQuery(getContentResolver());
        asyncQuery.startQuery(0, mAdapter, Sms.CONVERSATION_URI, projection, null, null, "date desc");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }


    class ConversationAdapter extends CursorAdapter {

        private ConversationHolderView mHolder;

        public ConversationAdapter(Context context, Cursor c) {
            super(context, c);
        }

        @Override
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            View view = View.inflate(context, R.layout.conversation_item, null);
            mHolder = new ConversationHolderView();
            mHolder.checkBox = (CheckBox) view.findViewById(R.id.cb_conversation_item);
            mHolder.ivIcon = (ImageView) view.findViewById(R.id.iv_conversation_item_icon);
            mHolder.tvName = (TextView) view.findViewById(R.id.tv_conversation_item_name);
            mHolder.tvDate = (TextView) view.findViewById(R.id.tv_conversation_item_date);
            mHolder.tvBody = (TextView) view.findViewById(R.id.tv_conversation_item_body);
            view.setTag(mHolder);
            return view;
        }

        @Override
        public void bindView(View view, Context context, Cursor cursor) {
            mHolder = (ConversationHolderView) view.getTag();
            int id = cursor.getInt(THREAD_ID_COLUMN_INDEX);
            String address = cursor.getString(ADDRESS_COLUMN_INDEX);
            int count = cursor.getInt(COUNT_COLUMN_INDEX);
            long date = cursor.getLong(DATE_COLUMN_INDEX);
            String body = cursor.getString(BODY_COLUMN_INDEX);
            if(currentState == EDIT_STATE) {
                mHolder.checkBox.setVisibility(View.VISIBLE);
                mHolder.checkBox.setChecked(mMultiDeleteSet.contains(id));
            } else {
                mHolder.checkBox.setVisibility(View.GONE);
            }
            String contactName = Utils.getContactName(getContentResolver(), address);
            if(TextUtils.isEmpty(contactName)) {
                mHolder.tvName.setText(address + "(" + count + ")");
                mHolder.ivIcon.setBackgroundResource(R.drawable.ic_unknow_contact_picture);
            } else {
                mHolder.tvName.setText(contactName + "(" + count + ")");
                Bitmap contactIcon = Utils.getContactIcon(getContentResolver(), address);
                if(contactIcon != null) {
                    mHolder.ivIcon.setBackgroundDrawable(new BitmapDrawable(contactIcon));
                } else {
                    mHolder.ivIcon.setBackgroundResource(R.drawable.ic_contact_picture);
                }
            }
            String strDate = null;
            if(DateUtils.isToday(date)) {
                strDate = DateFormat.getTimeFormat(context).format(date);
            } else {
                strDate = DateFormat.getDateFormat(context).format(date);
            }
            mHolder.tvDate.setText(strDate);
            mHolder.tvBody.setText(body);
        }
    }

    public class ConversationHolderView {
        public CheckBox checkBox;
        public ImageView ivIcon;
        public TextView tvName;
        public TextView tvDate;
        public TextView tvBody;
    }

}
