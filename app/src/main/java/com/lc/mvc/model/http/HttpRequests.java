package com.lc.mvc.model.http;

public class HttpRequests {
	private int requestCode;
	private IHttpRequest mHttpRequest = null;
	public HttpRequests(IHttpRequest httpRequest) {
		this.mHttpRequest = httpRequest;
	}

	public void startRequest() {
		String data = loadFromLocal();
		if(null==data){
			data=loadFromNet();
			if(null!=data){
				mHttpRequest.accessSucc(200,data);
				saveToLocal(data);
			}else{
				mHttpRequest.accessFail(404,data);
			}
		}else{
			mHttpRequest.accessSucc(200,data);
		}
	}

	private String loadFromLocal() {
		return null;
	}

	private String loadFromNet() {
		return null;
	}

	private void saveToLocal(String data) {
	}

	public int getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(int requestCode) {
		this.requestCode = requestCode;
	}
}
