package com.chen.family.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chen.family.R;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>显示提示的工具类，可以提示toast和对话框</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/5</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class TipUtils
{
    //定义了唯一的实例对象
    private static TipUtils mHHTipUtils;
    //私有化构造函数
    private TipUtils(){}
    //显示的Toast
    private Toast mToast;
    //显示Toast的内容
    private TextView mToastContentTextView;
    //显示的ProgressDialog
    private Dialog mProgressDialog;
    //显示Dialog的内容
    private TextView mDialogContentTextView;
    /**
     * 获取HHTipUtils的实例
     * @return
     */
    public static TipUtils getInstance()
    {
        synchronized (TipUtils.class)
        {
            if (mHHTipUtils==null)
            {
                mHHTipUtils=new TipUtils();
            }
            return mHHTipUtils;
        }
    }
    /**
     * 显示Toast通知
     * @param context
     * @param msg			显示的内容
     */
    public void showToast(Context context, String msg)
    {

        if (mToast==null)
        {
            Context applicationContext = context.getApplicationContext();
            mToast=new Toast(applicationContext);
            View view= View.inflate(applicationContext, R.layout.toast_custom, null);
            mToastContentTextView=ViewFinder.findView(view, R.id.hh_tv_toast_content);
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setView(view);
        }
        mToastContentTextView.setText(msg);
        mToast.show();
    }
    /**
     * 显示Toast通知
     * @param context
     * @param resID			资源的ID
     */
    public void showToast(Context context,int resID)
    {
        showToast(context, context.getString(resID));
    }
    /**
     * 显示提示的Dialog
     * @param context
     * @param msg			显示的内容
     */
    public void showProgressDialog(Context context,String msg)
    {
//        if (mProgressDialog!=null&&mProgressDialog.isShowing())
//        {
//            mProgressDialog.dismiss();
//        }
//        if (mProgressDialog==null||mProgressDialog.getContext()!=context)
//        {
//            mProgressDialog=new Dialog(context,R.style.hh_dialog_style);
//            View view=View.inflate(context, R.layout.hh_dialog_huahan_custom, null);
//            mDialogContentTextView=HHViewHelper.getViewByID(view, R.id.hh_tv_dialog_content);
//            mProgressDialog.setCanceledOnTouchOutside(true);
//            mProgressDialog.setContentView(view);
//        }
//        mDialogContentTextView.setText(msg);
//        mProgressDialog.show();

    }
    /**
     * 显示的提示的Dialog
     * @param context
     * @param resID			显示的内容的资源的ID
     */
    public void showProgressDialog(Context context,int resID)
    {
        showProgressDialog(context, context.getString(resID));
    }
    /**
     * 取消显示提示的Dialog
     */
    public void dismissProgressDialog()
    {
        if (mProgressDialog!=null&&mProgressDialog.isShowing())
        {
            mProgressDialog.dismiss();
        }
    }
}
