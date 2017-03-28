package com.chen.family.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.chen.family.MyApplication;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/2/28</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

class DBManager extends SQLiteOpenHelper
{
    public static final String DATABASE_NAME="family";
    public static final int DATABASE_VERSION=1;
    private static  DBManager mDataBaseManager;

    /**
     * 获取当前数据的管理器
     * @return
     */
    public static DBManager getInstance()
    {
        synchronized (DBManager.class)
        {
            if (mDataBaseManager==null)
            {
                mDataBaseManager=new DBManager(MyApplication.getInstance());
            }
        }
        return mDataBaseManager;
    }

    /**
     * 数据库管理器的构造类，不建议直接调用该方法，建议使用getInstance方法
     * @param context
     */
    public DBManager(Context context)
    {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db)
    {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {

    }
    public SQLiteDatabase getDataBase(boolean read)
    {
        if (read)
        {
            return getReadableDatabase();
        }else
        {
            return getWritableDatabase();
        }
    }
}
