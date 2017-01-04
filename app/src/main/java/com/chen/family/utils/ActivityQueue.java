package com.chen.family.utils;

import android.app.Activity;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>保存打开的activity队列</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/2</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class ActivityQueue
{
    /**
     * ActivityQueue的实例
     */
    private static ActivityQueue mActivityQuene=new ActivityQueue();
    /**
     * 缓存了所有的Activity的List，使用WeakReference，防止出现内存泄漏
     */
    private ArrayList<WeakReference<Activity>> mActivityList=new ArrayList<>();
    private ActivityQueue()
    {

    }

    /**
     * 获取ActivityQueue对象的实例
     * @return
     */
    public static ActivityQueue getInstance()
    {
        return mActivityQuene;
    }

    /**
     * 添加一个缓存
     * @param activity
     */
    public void push(Activity activity)
    {
        WeakReference<Activity> activityWeakReference=new WeakReference<>(activity);
        mActivityList.add(activityWeakReference);
    }

    /**
     * 移除一个缓存
     */
    public void pop()
    {
        if (mActivityList.size()!=0)
        {
            mActivityList.remove(mActivityList.size()-1);
        }
    }

    /**
     * 开启Activity，打开该Activity类型的第一个缓存的实例,该Activity之后的Activity都会被清除
     * @param clazz
     * @return true:找到该Actvity的实例并且打开，false没有找到该Activity
     */
    public boolean startFirstActivity(Class<? extends Activity> clazz)
    {
        //搜寻当前的Activity实例第一次出现的位置
        int index=findActivityFirstIndex(clazz);
        //关闭之后的Activity
        return finishActivitiesBehindIndex(index);
    }

    /**
     * 开启Activity，打开该Activity类型的最后一个缓存的实例,该Activity之后的Activity都会被清除
     * @param clazz
     * @return      true：打开成功，false失败
     */
    public boolean startLastActivity(Class<? extends Activity> clazz)
    {
        //搜寻当前的Activity实例第一次出现的位置
        int index=findActivityLastIndex(clazz);
        return finishActivitiesBehindIndex(index);
    }

    /**
     * 关闭缓存的该Activity的第一个实例
     * @param clazz
     * @return  true 关闭成功，false关闭失败
     */
    public boolean finishFirst(Class<? extends Activity> clazz)
    {
        int index=findActivityFirstIndex(clazz);
        return finishActivityAtIndex(index);
    }

    /**
     * 关闭缓存的该Activity的最后一个实例，也就是最近打开的实例
     * @param clazz
     * @return  true关闭成功 false关闭失败
     */
    public boolean finishLast(Class<? extends Activity> clazz)
    {
        int index=findActivityLastIndex(clazz);
        return finishActivityAtIndex(index);
    }
    /**
     * 关闭所有的Activity
     */
    public void finishAll()
    {
       while(mActivityList.size()>0)
       {
           WeakReference<Activity> activityWeakReference = mActivityList.remove(mActivityList.size()-1);
           if (activityWeakReference!=null&&activityWeakReference.get()!=null)
           {
               activityWeakReference.get().finish();
           }
       }
    }

    /**
     * 关闭指定位置上的Activity
     * @param index 指定的Activity
     */
    private boolean finishActivityAtIndex(int index)
    {
        if (index>=0&&index<mActivityList.size())
        {
            WeakReference<Activity> activityWeakReference = mActivityList.remove(index);
            if (activityWeakReference!=null&&activityWeakReference.get()!=null)
            {
                activityWeakReference.get().finish();
            }
            return true;
        }
        return false;
    }
    /**
     * 找到Activity缓存第一次出现的位置
     * @param clazz
     * @return  如果不存在，返回的index会大于缓存的大小
     */
    private int findActivityFirstIndex(Class<? extends Activity> clazz)
    {
        int index=-1;
        for (WeakReference<Activity> activityWeakReference:mActivityList)
        {
            if (activityWeakReference!=null&&activityWeakReference.get()!=null)
            {
                Activity activity = activityWeakReference.get();
                if (activity.getClass()==clazz)
                {
                    break;
                }
            }
            index++;
        }
        return index;
    }
    /**
     * 找到Activity缓存最后一次出现的位置
     * @param clazz
     * @return  如果不存在，返回的index会大于缓存的大小
     */
    private int findActivityLastIndex(Class<? extends Activity> clazz)
    {
        int index=mActivityList.size();
        for (int i=mActivityList.size()-1;i>=0;i--)
        {
            WeakReference<Activity> activityWeakReference = mActivityList.get(i);
            if (activityWeakReference!=null&&activityWeakReference.get()!=null)
            {
                Activity activity = activityWeakReference.get();
                if (activity.getClass()==clazz)
                {
                    index=i;
                    break;
                }
            }
        }
        return index;
    }
    /**
     * 关闭Index之后的Activity
     * @param index     位置
     * @return true：关闭了这个index之后的Acitivity，false没有关闭，索引超出范围
     */
    private boolean finishActivitiesBehindIndex(int index)
    {
        //关闭之后的Activity
        if (index>-1&&index<mActivityList.size())
        {
            while(mActivityList.size()>index+1)
            {
                WeakReference<Activity> remove = mActivityList.remove(mActivityList.size() - 1);
                if (remove!=null&&remove.get()!=null)
                {
                    remove.get().finish();
                }
            }
            return true;
        }
        return false;
    }




}
