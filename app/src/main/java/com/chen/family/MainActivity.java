package com.chen.family;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.chen.family.utils.ViewFinder;

public class MainActivity extends CCActivity
{
    private Toolbar toolbar;
    @Override
    public void initView(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);
        toolbar= ViewFinder.findView(this,R.id.toolBar);
    }

    @Override
    public void initValues(Bundle savedInstanceState)
    {

    }

    @Override
    public void initListeners(Bundle savedInstanceState)
    {
        toolbar.setNavigationOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                onBackPressed();
            }
        });
    }
}
