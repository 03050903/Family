package com.chen.family.cache;

import android.content.Context;
import android.content.SharedPreferences;

import com.chen.family.MyApplication;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/8</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class PreferenceUtils
{
    /**
     * 获取字符串
     * @param configFile
     * @param paramName
     * @return
     */
    public static final String getString(String configFile,String paramName)
    {
        return getSharedPreference(configFile).getString(paramName,null);
    }

    /**
     * 获取sharedpreference
     * @param configFile
     * @return
     */
    public static final SharedPreferences getSharedPreference(String configFile)
    {
        return MyApplication.getInstance().getSharedPreferences(configFile,Context.MODE_PRIVATE);
    }

    /**
     * 获取editor
     * @param configFile
     * @return
     */
    public static final SharedPreferences.Editor getEditor(String configFile)
    {
        return getSharedPreference(configFile).edit();
    }

    /**
     * 保存字符串
     * @param configFile
     * @param paramName
     * @param paramValue
     */
    public static final void saveString(String configFile,String paramName,String paramValue)
    {
        SharedPreferences.Editor editor = getEditor(configFile);
        editor.putString(paramName,paramValue);
        editor.apply();
    }

    /**
     * 获取int值
     * @param configFile
     * @param paramName
     * @return
     */
    public static final int getInt(String configFile,String paramName)
    {
        return getSharedPreference(configFile).getInt(paramName,0);
    }

    /**
     * 保存int值
     * @param configFile
     * @param paramName
     * @param paramValue
     */
    public static final void saveInt(String configFile,String paramName,int paramValue)
    {
        SharedPreferences.Editor editor = getEditor(configFile);
        editor.putInt(paramName,paramValue);
        editor.apply();
    }



}
