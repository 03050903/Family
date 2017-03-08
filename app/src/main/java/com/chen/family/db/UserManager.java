package com.chen.family.db;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>管理用户数据</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/2/28</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class UserManager
{
    private static UserManager mUserManager=new UserManager();

    public static UserManager getInstance()
    {
        return mUserManager;
    }
}
