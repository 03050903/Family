package com.chen.family.db;


import android.database.sqlite.SQLiteDatabase;

import com.chen.family.utils.DLog;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>数据库操作的管理类</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/2/28</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class OperationManager
{
    private static OperationManager mOperationManager=new OperationManager();
    private LinkedBlockingQueue<DBOperation> mOperationQueue=new LinkedBlockingQueue<>();
    private OperationManager()
    {
        startOperation();
    }
    public static OperationManager getInstance()
    {
        return mOperationManager;
    }

    /**
     * 添加操作
     * @param operation
     */
    public synchronized void addOperation(DBOperation operation)
    {
        try
        {
            mOperationQueue.put(operation);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
            DLog.i("添加数据库操作出现异常:"+e.getMessage()+","+e.getClass());
        }
    }

    /**
     * 移除操作
     * @param operation
     */
    public synchronized void removeOperation(DBOperation operation)
    {
        mOperationQueue.remove(operation);
    }
    private void startOperation()
    {
        new Thread(new Runnable()
        {
            @Override
            public void run()
            {
                while(true)
                {
                    try
                    {
                        DBOperation take = mOperationQueue.take();
                        DBManager manager=new DBManager(null);
                        SQLiteDatabase dataBase = DBManager.getInstance().getDataBase(take.isRead());
                        take.doOperation(dataBase);
                        Thread.sleep(100);
                    } catch (Exception e)
                    {
                        e.printStackTrace();
                        DLog.i("执行数据库操作的时候出现异常:"+e.getMessage()+","+e.getClass());
                    }
                }
            }
        }).start();
    }

}
