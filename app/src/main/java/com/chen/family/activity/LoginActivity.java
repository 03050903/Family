package com.chen.family.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import com.chen.family.R;
import com.chen.family.utils.TipUtils;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>实现登录的页面</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/1</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class LoginActivity extends CCActivity
{
    private EditText userNameEditText;
    private EditText userPwdEditText;
    private FloatingActionButton loginButton;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        setContentView(R.layout.activity_login);
        userNameEditText=findView(R.id.et_user_name);
        userPwdEditText=findView(R.id.et_user_pwd);
        loginButton=findView(R.id.fab_login);
        return null;
    }

    @Override
    public void initValues(Bundle savedInstanceState)
    {

    }

    @Override
    public void initListeners(Bundle savedInstanceState)
    {
        loginButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                checkUserInput();
            }
        });
    }

    /**
     * 检查用户的操作
     */
    private void checkUserInput()
    {
        String userName=userNameEditText.getText().toString().trim();
        if (TextUtils.isEmpty(userName))
        {
            TipUtils.getInstance().showToast(getPageContext(),R.string.input_user_name);
            return ;
        }
        String pwd=userPwdEditText.getText().toString().trim();
        if (TextUtils.isEmpty(pwd))
        {
            TipUtils.getInstance().showToast(getPageContext(),R.string.input_user_pwd);
            return ;
        }
        startMain();
    }
    private void startMain()
    {
        Intent intent=new Intent(getPageContext(),MainActivity.class);
        ActivityOptionsCompat compat=ActivityOptionsCompat.makeSceneTransitionAnimation(this,loginButton,"login");
        ActivityCompat.startActivity(this,intent,compat.toBundle());
    }
}
