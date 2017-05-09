package com.chen.god.model;

import android.database.Cursor;
import android.provider.MediaStore;

import com.chen.god.imp.PhotoInfo;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/18</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class SystemPhotoModel implements PhotoInfo
{


    private String photoPath;//路径
    private int width;//宽度
    private int height;
    private String bucketDiaplayName;//所属文件夹的名称
    private String displayName;
    private long addDate;
    private long updateDate;
    private int photoSize;
    private String mineType;
    private double latitude;
    private double longitude;
    private String title;

    public String getPhotoPath()
    {
        return photoPath;
    }

    public void setPhotoPath(String photoPath)
    {
        this.photoPath = photoPath;
    }

    public int getWidth()
    {
        return width;
    }

    public void setWidth(int width)
    {
        this.width = width;
    }

    public int getHeight()
    {
        return height;
    }

    public void setHeight(int height)
    {
        this.height = height;
    }

    public String getBucketDiaplayName()
    {
        return bucketDiaplayName;
    }

    public void setBucketDiaplayName(String bucketDiaplayName)
    {
        this.bucketDiaplayName = bucketDiaplayName;
    }

    public String getDisplayName()
    {
        return displayName;
    }

    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }

    public long getAddDate()
    {
        return addDate;
    }

    public void setAddDate(long addDate)
    {
        this.addDate = addDate;
    }

    public long getUpdateDate()
    {
        return updateDate;
    }

    public void setUpdateDate(long updateDate)
    {
        this.updateDate = updateDate;
    }

    public int getPhotoSize()
    {
        return photoSize;
    }

    public void setPhotoSize(int photoSize)
    {
        this.photoSize = photoSize;
    }

    public String getMineType()
    {
        return mineType;
    }

    public void setMineType(String mineType)
    {
        this.mineType = mineType;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }
    public static SystemPhotoModel createFromCursor(Cursor cursor)
    {
        if (cursor==null)
        {
            return null;
        }
        SystemPhotoModel model=new SystemPhotoModel();
        model.setAddDate(cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media.DATE_ADDED)));
        model.setUpdateDate(cursor.getLong(cursor.getColumnIndex(MediaStore.Images.Media.DATE_MODIFIED)));
        model.setBucketDiaplayName(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.BUCKET_DISPLAY_NAME)));
        model.setDisplayName(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DISPLAY_NAME)));
        model.setHeight(cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media.HEIGHT)));
        model.setWidth(cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media.WIDTH)));
        model.setLatitude(cursor.getDouble(cursor.getColumnIndex(MediaStore.Images.Media.LATITUDE)));
        model.setLongitude(cursor.getDouble(cursor.getColumnIndex(MediaStore.Images.Media.LONGITUDE)));
        model.setMineType(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.MIME_TYPE)));
        model.setPhotoPath(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.DATA)));
        model.setPhotoSize(cursor.getInt(cursor.getColumnIndex(MediaStore.Images.Media.SIZE)));
        model.setTitle(cursor.getString(cursor.getColumnIndex(MediaStore.Images.Media.TITLE)));
        return model;
    }

    @Override
    public String getPicPath()
    {
        return photoPath;
    }

    @Override
    public int getPicWidth()
    {
        return width;
    }

    @Override
    public int getPicHeight()
    {
        return height;
    }
}
