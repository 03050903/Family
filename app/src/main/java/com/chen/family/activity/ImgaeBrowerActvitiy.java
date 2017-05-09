package com.chen.family.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.chen.family.R;
import com.chen.family.utils.ViewFinder;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>图片预览</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/19</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class ImgaeBrowerActvitiy extends CCActivity
{
    private ViewPager viewPager;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_image_brower);
        viewPager= ViewFinder.findView(this,R.id.viewPager);
        return null;
    }

    @Override
    public void initValues(Bundle savedInstanceState)
    {

    }

    @Override
    public void initListeners(Bundle savedInstanceState)
    {

    }
}
