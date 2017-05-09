package com.chen.family.activity;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.TextView;

import com.chen.family.R;
import com.chen.family.cache.UserInfoUtils;
import com.chen.family.fragment.FamilyFragment;
import com.chen.family.model.UserModel;
import com.chen.family.utils.ImageUtils;
import com.chen.family.utils.ViewFinder;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>主页面，显示一个App的首页</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/1/4</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */
public class MainActivity extends CCActivity
{
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private TextView userNameTextView;
    private CircleImageView userHeadImageView;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_main);
        drawerLayout=ViewFinder.findView(this, R.id.dl_drawer);
        navigationView=ViewFinder.findView(this,R.id.nv_menu);
        View headerView = navigationView.getHeaderView(0);
        userNameTextView=ViewFinder.findView(headerView,R.id.tv_user_name);
        userHeadImageView=ViewFinder.findView(headerView,R.id.img_user_head);
        showPage();
        return null;
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        UserModel currentUser = UserInfoUtils.getInstannce().getCurrentUser();
        if (currentUser!=null)
        {
            //设置用户的数据
            userNameTextView.setText(currentUser.getUserName());
            ImageUtils.getInstance().loadImage(userHeadImageView,currentUser.getHeadUrl());
        }else
        {
            //设置未登录的信息
            userNameTextView.setText(R.string.user_not_login);
            userHeadImageView.setImageResource(R.drawable.default_image);
        }
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
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,new FamilyFragment()).commitAllowingStateLoss();
//        getSupportFragmentManager().beginTransaction().replace(R.id.fl_content,new CircleFragment()).commitAllowingStateLoss();
    }
}
