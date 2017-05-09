package com.chen.god.imp;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>关于图片的一些基本信息</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/18</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public interface PhotoInfo extends PhotoBaseInfo
{


    /**
     * 获取图片的宽度，没有获取到的时候返回0
     * @return
     */
    int getPicWidth();

    /**
     * 获取图片的高度，没有获取到的时候返回0
     * @return
     */
    int getPicHeight();
//    String getDisplayName();
//    String getMineType();
//    String getAddDate();
//    String getUpdateDate();
//    String getBucketDisplayName();
}
