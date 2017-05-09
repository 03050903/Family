package com.chen.family.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.chen.family.R;
import com.chen.family.utils.ViewFinder;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/18</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class FamilyPhotoViewHolder extends RecyclerView.ViewHolder
{
    private ImageView imageView;
    public FamilyPhotoViewHolder(View itemView)
    {
        super(itemView);
        imageView= ViewFinder.findView(itemView, R.id.img_photo);
    }
    public ImageView getImageView()
    {
        return imageView;
    }
}
