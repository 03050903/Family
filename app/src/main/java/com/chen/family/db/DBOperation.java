package com.chen.family.db;

import android.database.sqlite.SQLiteDatabase;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>database操作的model</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/2/28</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public interface DBOperation
{
    /**
     * 需要进行的操作
     * @param db
     */
    void doOperation(SQLiteDatabase db);

    /**
     * 当前是只读还是写操作
     * @return
     */
    boolean isRead();
}
