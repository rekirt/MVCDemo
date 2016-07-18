package com.lc.mvc.base;

/**
 * @ClassName BaseContainer
 * @Description  所有Activity、Fragment 都继承这个接口。
 * @author lc
 * @date 2013年7月17日
 */
public interface BaseContainer {
    /**
     * @Method: initView
     * @Description:
     * <p>
     * 初始化Intent数据
     * <p>
     * @param
     * @return void
     * @throws
     */
    public void initIntentValue();
    /**
     * @Method: initView
     * @Description: 
     * <p>
     * 初始化界面
     * <p>
     * @param
     * @return void
     * @throws
     */
    public void initView();

    /**
     * @Method: setListener
     * @Description: 
     * <p>
     * 初始化监听
     * <p>
     * @param
     * @return void
     * @throws
     */
    public void setListener();

    /**
     * @Method: initData
     * @Description: 
     * <p>
     * 初始化数据
     * <p>
     * @param
     * @return void
     * @throws
     */
    public void initData();
}
