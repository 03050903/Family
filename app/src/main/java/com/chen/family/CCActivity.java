package com.chen.family;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.chen.family.imp.PageInitImp;
import com.chen.family.utils.ActivityQueue;
import com.chen.family.utils.ViewFinder;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>基类，实现一些基本的功能</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/1</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public abstract class CCActivity extends AppCompatActivity implements PageInitImp
{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        ActivityQueue.getInstance().push(this);
        initView(savedInstanceState);
        initValues(savedInstanceState);
        initListeners(savedInstanceState);
    }
    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        ActivityQueue.getInstance().pop();
    }

    /**
     * 寻找View
     * @param viewID view的id
     * @param <T>
     * @return
     */
    protected <T> T findView(int viewID)
    {
        return ViewFinder.findView(this,viewID);
    }

    /**
     * 获取当前页面的一个context对象
     * @return
     */
    protected Context getPageContext()
    {
        return this;
    }
}
