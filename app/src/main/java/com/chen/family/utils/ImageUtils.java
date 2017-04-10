package com.chen.family.utils;

import android.text.TextUtils;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/8</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class ImageUtils
{
    private static ImageUtils mImageUtils=new ImageUtils();
    private ImageUtils()
    {

    }
    public static final ImageUtils getInstance()
    {
        return mImageUtils;
    }
    public void loadImage(ImageView imageView,String imageUrl)
    {
        if (imageView==null|| TextUtils.isEmpty(imageUrl))
        {
            return ;
        }
        Glide.with(imageView.getContext()).load(imageUrl).into(imageView);
    }
    public void loadImage(ImageView imageView,int defaultImage,String imageUrl)
    {
        if (imageView==null||TextUtils.isEmpty(imageUrl))
        {
            return ;
        }
        Glide.with(imageView.getContext()).load(imageUrl).placeholder(defaultImage).into(imageView);
    }
    public static final String getPathFromAssets(String fileName)
    {
        return "file:///android_asset/"+fileName;
    }

}
