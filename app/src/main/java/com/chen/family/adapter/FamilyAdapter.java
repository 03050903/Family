package com.chen.family.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.chen.family.R;
import com.chen.family.fragment.FamilyInfoFragment;
import com.chen.family.fragment.FamilyPhotoFragment;
import com.chen.family.fragment.UnCompleteFragment;
import com.chen.family.utils.DLog;

import java.util.HashMap;
import java.util.Map;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/10</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class FamilyAdapter extends FragmentPagerAdapter
{

    private Map<String,Fragment> list;
    private String[] titleArray;

    public FamilyAdapter(FragmentManager fm)
    {

        super(fm);
        DLog.i("初始化adapter");
        titleArray = MyApplication.getInstance().getResources().getStringArray(R.array.main_family);
        list = new HashMap<>();
    }

    @Override
    public Fragment getItem(int position)
    {
        Fragment fragment = list.get(titleArray[position]);
        if (list.get(position) == null)
        {
            fragment = getFragmentByPosition(position);
            list.put(titleArray[position], fragment);
        }
        DLog.i("fragment is:"+fragment);
        return fragment;
    }

    @Override
    public int getCount()
    {
        return titleArray.length;
    }

    @Override
    public CharSequence getPageTitle(int position)
    {
        return titleArray[position];
    }

    private Fragment getFragmentByPosition(int position)
    {
        Fragment fragment = null;
        switch (position)
        {
            case 0:
                fragment = new FamilyInfoFragment();
                break;
            case 1:
                fragment = new FamilyPhotoFragment();
                break;
            default:
                fragment = new UnCompleteFragment();
                break;
        }
        return fragment;
    }
}
