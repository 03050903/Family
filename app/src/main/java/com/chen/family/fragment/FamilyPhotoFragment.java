package com.chen.family.fragment;

import android.os.Bundle;
import android.view.View;

import com.chen.family.R;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>显示家庭的照片</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/10</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class FamilyPhotoFragment extends CCFragment
{
    @Override
    public View initView(Bundle savedInstanceState)
    {
        View view=View.inflate(getActivity(), R.layout.frag_family_photo,null);
        return view;
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
