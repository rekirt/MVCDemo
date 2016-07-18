package com.lc.mvc.control;

import com.lc.mvc.model.UserInfo;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-4-5.
 */
public class UserBussiness extends BaseBusiness<UserInfo> {

    public UserBussiness(IBaseBusiness baseBusiness) {
        super(baseBusiness);
    }


    @Override
    public void startRequest() {
       String json =  bean2Json(getData());
        //请求网络
        mHttpRequest.startRequest();
    }

    @Override
    public void noNetWork() {
        super.noNetWork();

    }

    @Override
    public void accessFail(int requestCode, Object obj) {
        super.accessFail(requestCode, obj);

    }

    @Override
    public void accessSucc(int requestCode, Object obj) {
        super.accessSucc(requestCode, obj);


    }
}
