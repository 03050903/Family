package com.chen.family.imp;

import android.os.Bundle;
import android.view.View;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>用于页面的初始化</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/5</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public interface PageInitImp
{
    /**
     * 初始化View
     */
    View initView(Bundle savedInstanceState);

    /**
     * 初始化值
     */
    void initValues(Bundle savedInstanceState);

    /**
     * 初始化监听器
     */
    void initListeners(Bundle savedInstanceState);
}
