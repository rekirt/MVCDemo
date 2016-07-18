package com.lc.mvc.model.http;

/**
 * @ClassName IHttpRequest
 * @Description  网络访问回调接口，继承此接口后可以获得访问成功和失败的数据
 * @author lc
 */
public interface IHttpRequest {
	
    public void accessSucc(int requestCode, Object obj);

    public void accessFail(int requestCode, Object obj);

    public void startRequest();

    public void noNetWork();

    public void requestHandler(Object obj);

}
