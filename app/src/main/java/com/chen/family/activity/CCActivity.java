package com.chen.family.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chen.family.imp.PageInitImp;


/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>基类,主要实现在页面创建的时候不执行获取数据或者不现实进度条加载数据的页面</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/1</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public abstract class CCActivity extends CActivity implements PageInitImp
{

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
        initValues(savedInstanceState);
        initListeners(savedInstanceState);
    }


}
