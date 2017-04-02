package com.chen.family.transition;

import android.animation.Animator;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.transition.Transition;
import android.support.transition.TransitionValues;
import android.view.View;
import android.view.ViewGroup;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/5</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class LoginTransion extends Transition
{
    private static final String HEIGHT="height";
    private static final String WIDTH="width";
    @Override
    public void captureEndValues(@NonNull TransitionValues transitionValues)
    {
        View view=transitionValues.view;
        Rect rect=new Rect();
        view.getHitRect(rect);
        transitionValues.values.put(HEIGHT,rect.top);
        transitionValues.values.put(WIDTH,view.getWidth());
    }

    @Override
    public void captureStartValues(@NonNull TransitionValues transitionValues)
    {
        View view=transitionValues.view;
        Rect rect=new Rect();
        view.getHitRect(rect);
        transitionValues.values.put(HEIGHT,rect.top);
        transitionValues.values.put(WIDTH,view.getWidth());
    }

    @Nullable
    @Override
    public Animator createAnimator(@NonNull ViewGroup sceneRoot, @Nullable TransitionValues startValues, @Nullable TransitionValues endValues)
    {
        return super.createAnimator(sceneRoot, startValues, endValues);
    }

}
