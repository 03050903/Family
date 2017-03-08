package com.chen.family;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chen.family.fragment.CircleFragment;
import com.chen.family.utils.ViewFinder;
import com.yalantis.phoenix.PullToRefreshView;

public class MainActivity extends CCActivity
{
    private DrawerLayout drawerLayout;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);
        showPage();
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
    private void showPage()
    {
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,new CircleFragment()).commitAllowingStateLoss();
    }
}
