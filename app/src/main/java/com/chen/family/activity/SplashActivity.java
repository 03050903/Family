package com.chen.family.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.view.View;
import android.widget.ImageView;

import com.chen.family.R;
import com.chen.family.cache.UserInfoUtils;
import com.chen.family.model.AnimatorAdapter;
import com.chen.family.utils.DLog;
import com.chen.god.utils.DensityUtils;
import com.chen.god.utils.ScreenUtils;

import me.wangyuwei.particleview.ParticleView;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>启动页</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/1/4</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class SplashActivity extends CCActivity
{
    private ImageView splashImageView;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        setContentView(R.layout.cc_activity_aplash);
        ParticleView particleView=findView(R.id.pv_splash);
        splashImageView=findView(R.id.img_splash);
        particleView.startAnim();
        particleView.setOnParticleAnimListener(new ParticleView.ParticleAnimListener()
        {
            @Override
            public void onAnimationEnd()
            {
                resetImageMargin();
                splashImageView.setVisibility(View.VISIBLE);
                animImageView();
            }
        });
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
    private int getTextHeight()
    {
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setTextSize(DensityUtils.sp2px(getPageContext(),36));
        Rect rect = new Rect();
        String text=getResources().getString(R.string.en_family);
        paint.getTextBounds(text, 0, text.length(), rect);
        return (int) (rect.height() / 1.1f);
    }
    private void resetImageMargin()
    {
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        BitmapFactory.decodeResource(getResources(), R.mipmap.cc_splash, options);
        int bitmapHeight=options.outHeight;
        int textHeight = getTextHeight();
        DLog.i("textHeight:"+textHeight);
        int statusBarHeight=ScreenUtils.getStatusBarHeight(this);
        int bottom= ScreenUtils.getScreenHeight(this)/2-textHeight*3-bitmapHeight-statusBarHeight;
        ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) splashImageView.getLayoutParams();
        layoutParams.topMargin=bottom;
    }

    /**
     * 执行ImageView显示的动画
     */
    private void animImageView()
    {
        ObjectAnimator animator=ObjectAnimator.ofFloat(splashImageView,"translationY",DensityUtils.dip2px(this,-150),0);
        ObjectAnimator alphaAnimator=ObjectAnimator.ofFloat(splashImageView,"alpha",0.2f,1.0f);
        ObjectAnimator scaleXAnimator=ObjectAnimator.ofFloat(splashImageView,"scaleX",0.2f,0.5f,1.0f);
        ObjectAnimator scaleYAnimator=ObjectAnimator.ofFloat(splashImageView,"scaleY",0.2f,0.5f,1.0f);
        AnimatorSet set=new AnimatorSet();
        set.addListener(new AnimatorAdapter(){
            @Override
            public void onAnimationEnd(Animator animation)
            {
                super.onAnimationEnd(animation);
                boolean login = UserInfoUtils.getInstannce().isLogin();
//                if (login)
//                {
//                    //已登陆，需要跳转到首页
//                    ActivityUtils.startLogin(SplashActivity.this,false);
//                }else
//                {
//                    //没有登录，需要跳转到登录页面
//                    ActivityUtils.startLogin(SplashActivity.this,false);
//                }
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        });
        set.setDuration(500);
        set.play(animator).with(alphaAnimator).with(scaleXAnimator).with(scaleYAnimator);
        set.start();
    }

}
