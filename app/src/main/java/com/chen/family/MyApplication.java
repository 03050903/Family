package com.chen.family;

import android.app.Application;
import android.widget.CheckedTextView;

import com.letv.sarrsdesktop.blockcanaryex.jrt.BlockCanaryEx;
import com.letv.sarrsdesktop.blockcanaryex.jrt.Config;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
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
        BlockCanaryEx.install(new Config(this){
            @Override
            public boolean isBlock(long startTime, long endTime, long startThreadTime, long endThreadTime)
            {
                long realTime=endTime-startTime;
                return realTime>160;
            }
        });
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
