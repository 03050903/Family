package com.chen.family.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;

import com.chen.family.R;
import com.chen.family.adapter.FamilyPhotoAdapter;
import com.chen.family.utils.ViewFinder;
import com.chen.god.imp.PhotoInfo;
import com.chen.god.model.StagDecoration;
import com.chen.god.utils.DensityUtils;
import com.chen.god.utils.SystemUtils;

import java.util.ArrayList;


/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p>显示家庭的照片</p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/10</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class FamilyPhotoFragment extends BaseFragment
{
    private RecyclerView listView;
    private ArrayList<? extends PhotoInfo> photoList;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        View view=View.inflate(getActivity(), R.layout.frag_family_photo,null);
        listView= ViewFinder.findView(view,R.id.listView);
        return view;
    }
    @Override
    public void initValues(Bundle savedInstanceState)
    {
        photoList=getPhotoList();
        listView.setAdapter(new FamilyPhotoAdapter(photoList));
        StaggeredGridLayoutManager layoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        listView.setLayoutManager(layoutManager);
        int height= DensityUtils.dip2px(getActivity(),4);
        listView.setPadding(height,height,height,height);
        listView.addItemDecoration(new StagDecoration(height));
    }
    @Override
    public void initListeners(Bundle savedInstanceState)
    {

    }
    private ArrayList<? extends PhotoInfo> getPhotoList()
    {
        return SystemUtils.getSystemPhotoList(getActivity());
    }
}
