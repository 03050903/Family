package com.chen.family.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.NestedScrollView;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import com.chen.family.R;
import com.chen.family.adapter.FamilyAdapter;
import com.chen.family.utils.ImageUtils;
import com.chen.family.utils.ViewFinder;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>我爱我家的页面</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/8</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class FamilyFragment extends BaseFragment
{
    private CollapsingToolbarLayout collapsingToolbarLayout;
    private ImageView backImageView;
    private ViewPager viewPager;
    private TabLayout tabLayout;
//    private NestedScrollView scrollView;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        View view=View.inflate(getActivity(), R.layout.frag_family,null);
        backImageView=ViewFinder.findView(view,R.id.img_family);
        collapsingToolbarLayout=ViewFinder.findView(view,R.id.ctl_toolbar);
        viewPager=ViewFinder.findView(view,R.id.viewPager);
        tabLayout=ViewFinder.findView(view,R.id.tabLayout);
//        scrollView=ViewFinder.findView(view,R.id.scrollView);
        return view;
    }

    @Override
    public void initValues(Bundle savedInstanceState)
    {
//        scrollView.setFillViewport(true);
        collapsingToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        collapsingToolbarLayout.setExpandedTitleColor(Color.WHITE);
        ImageUtils.getInstance().loadImage(backImageView,ImageUtils.getPathFromAssets("test_family.jpg"));
        viewPager.setAdapter(new FamilyAdapter(getChildFragmentManager()));
        tabLayout.setupWithViewPager(viewPager);
    }
    @Override
    public void initListeners(Bundle savedInstanceState)
    {

    }

}
