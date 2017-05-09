package com.chen.god.model;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/18</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class StagDecoration extends RecyclerView.ItemDecoration
{
    private int itemHeight;

    public StagDecoration(int itemHeight)
    {
        this.itemHeight= itemHeight;
    }
    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state)
    {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.bottom=itemHeight;
        outRect.top=itemHeight;
        outRect.right=itemHeight;
        outRect.left=itemHeight;
    }


}
