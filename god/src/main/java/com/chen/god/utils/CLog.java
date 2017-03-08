package com.chen.god.utils;

import android.util.Log;

import com.chen.god.BuildConfig;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/1/4</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class CLog
{
    private static final String TAG="chenTest";
    public static final void i(String msg)
    {
        Log.i(TAG,msg);
        Log.i(TAG,"build config:"+BuildConfig.DEBUG);
        if (BuildConfig.DEBUG)
        {
            Log.i(TAG,msg);
        }
    }
    public static final void v(String msg)
    {
        if (BuildConfig.DEBUG)
        {
            Log.v(TAG,msg);
        }
    }
    public static final void e(String msg)
    {
        if (BuildConfig.DEBUG)
        {
            Log.e(TAG,msg);
        }
    }
    public static final void w(String msg)
    {
        if (BuildConfig.DEBUG)
        {
            Log.w(TAG,msg);
        }
    }
}
