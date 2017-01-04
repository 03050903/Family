package com.chen.family.utils;

import android.app.Activity;
import android.view.View;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>寻找View的一个帮助类</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/5</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class ViewFinder
{
    public static <T> T findView(View parentView, int viewID)
    {
        return (T) parentView.findViewById(viewID);
    }
    public static <T> T findView(Activity activity,int viewID)
    {
        return (T) activity.findViewById(viewID);
    }
}
