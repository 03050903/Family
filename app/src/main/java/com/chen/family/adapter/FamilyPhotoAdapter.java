package com.chen.family.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.chen.family.R;
import com.chen.family.holder.FamilyPhotoViewHolder;
import com.chen.family.utils.DLog;
import com.chen.family.utils.ImageUtils;
import com.chen.god.imp.PhotoInfo;
import com.chen.god.utils.ScreenUtils;

import java.util.ArrayList;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/18</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class FamilyPhotoAdapter extends RecyclerView.Adapter<FamilyPhotoViewHolder>
{
    private ArrayList<? extends PhotoInfo> photoList;
    private int itemWidth;
    public FamilyPhotoAdapter(ArrayList<? extends PhotoInfo> list)
    {
        this.photoList=list;
        itemWidth= ScreenUtils.getScreenWidth(MyApplication.getInstance())/2/*- DensityUtils.dip2px(MyApplication.getInstance(),10)*/;

    }
    @Override
    public FamilyPhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_family_photo,null);
        return new FamilyPhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FamilyPhotoViewHolder holder, int position)
    {
        ImageView imageView = holder.getImageView();
        DLog.i("layoutParams:"+imageView.getLayoutParams());
        ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
        layoutParams.width=itemWidth;
        int itemHeight=itemWidth;
        PhotoInfo photoInfo = photoList.get(position);
        if (photoInfo.getPicHeight()>0)
        {
            itemHeight= (int) (itemWidth*photoInfo.getPicHeight()*1.0/photoInfo.getPicWidth());
        }
        layoutParams.width=itemWidth;
        layoutParams.height=itemHeight;
        ImageUtils.getInstance().loadImage(imageView,photoInfo.getPicPath());
    }

    @Override
    public int getItemCount()
    {
        return photoList==null?0:photoList.size();
    }
}
