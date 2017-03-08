package com.chen.family.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

import com.chen.family.LoginActivity;

import java.util.HashMap;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/2/23</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class ActivityUtils
{
    public static final int CODE_LOGIN=0x1000;

    /**
     * 跳转到登录页面
     * @param activity      当前的Activity
     * @param forResult     是否需要以startActivityForResult的方式打开Loginactivity，如是是，那么requestCode是CODE_LOGIN
     */
    public static void startLogin(Activity activity, boolean forResult)
    {
        Intent intent=new Intent(activity, LoginActivity.class);
        if (forResult)
        {
            activity.startActivityForResult(intent,CODE_LOGIN);
        }else
        {
            activity.startActivity(intent);
        }
    }
}
