package com.lc.mvc.control;

/**
 * @ClassName IBaseBusiness
 * @Description
 * @author lc
 * @date 2013年7月17日
 */
public interface IBaseBusiness {

    public void onBusinessSucc(int bCode, Object obj);

    public void onBusinessFail(int bCode, Object obj);
    
    public void setNetWork();

    public void requestHandler(Object obj);
    
}
