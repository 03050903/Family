package com.chen.family;

import android.app.Application;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>当前App的Application</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/5</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class MyApplication extends Application
{
    private static MyApplication mApplication;
    @Override
    public void onCreate()
    {
        super.onCreate();
        mApplication=this;
    }
    /**
     * 获取当前应用的实例
     * @return
     */
    public static MyApplication getInstance()
    {
        return mApplication;
    }
}
