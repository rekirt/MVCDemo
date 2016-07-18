package com.lc.mvc.control;


import com.lc.mvc.model.http.HttpRequests;
import com.lc.mvc.model.http.IHttpRequest;

/**
 * Author: lc
 * Email: rekirt@163.com
 * Date: 16-4-5.
 */
public abstract class BaseBusiness<T> implements IHttpRequest {

	private int requestCode;
	private String key;
	private Object data;
	private T bean;
	protected HttpRequests mHttpRequest = null;
	protected IBaseBusiness iBaseBusiness = null;

	public BaseBusiness(IBaseBusiness baseBusiness) {
		this.mHttpRequest = new HttpRequests(this);
		this.iBaseBusiness = baseBusiness;
	}

	public BaseBusiness(IBaseBusiness baseBusiness, int requestCode) {
		this.mHttpRequest = new HttpRequests(this);
		this.iBaseBusiness = baseBusiness;
		this.requestCode =requestCode;
		this.mHttpRequest.setRequestCode(getRequestCode());
	}

    @Override
	public abstract void startRequest();

    @Override
    public void requestHandler(Object obj){
        if (null != iBaseBusiness) {
        	iBaseBusiness.requestHandler(obj);
        }
    }
    
    @Override
    public void noNetWork() {
        if (null != iBaseBusiness) {
        	iBaseBusiness.setNetWork();
        }
    }

	@Override
	public void accessFail(int requestCode, Object obj) {
		if(null!=iBaseBusiness)iBaseBusiness.onBusinessFail(requestCode,obj);
	}

	@Override
	public void accessSucc(int requestCode, Object obj) {
//		bean = JSON.parse(obj,T.class);
		if(null!=iBaseBusiness)iBaseBusiness.onBusinessSucc(requestCode,bean);
	}

	public void recycle() {
        mHttpRequest = null;
        iBaseBusiness = null;
    }
    
    /**
     * 将bean转换位Json
     * @param obj
     * @return
     */
    public String bean2Json(Object obj){
		//JSON.toString(obj);
    	return null;
    }

	/**
	 * json转换位相应的尸体类
	 * @param json
	 * @return
	 */
	public String json2Bean(String json){
		//JSON.parse(json,T.class)
		return null;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public int getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(int requestCode) {
		this.requestCode = requestCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
