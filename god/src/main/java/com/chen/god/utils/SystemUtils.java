package com.chen.god.utils;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;
import android.util.Log;

import com.chen.god.model.SystemPhotoModel;

import java.util.ArrayList;


/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/18</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class SystemUtils
{
    public static ArrayList<SystemPhotoModel> getSystemPhotoList(Context context)
    {
        ArrayList<SystemPhotoModel> list=new ArrayList<>();
        if (context!=null)
        {
            Cursor query = context.getContentResolver().query(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, null, null, null, null);
            if (query!=null)
            {
                while(query.moveToNext())
                {
                    SystemPhotoModel model=SystemPhotoModel.createFromCursor(query);
                    Log.i("chenTest","name:"+model.getPhotoPath());
                    list.add(model);
                }
                query.close();
            }
        }
        return list;
    }
}
