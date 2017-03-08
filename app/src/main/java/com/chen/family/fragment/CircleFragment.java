package com.chen.family.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chen.family.R;
import com.chen.family.utils.ViewFinder;
import com.yalantis.phoenix.PullToRefreshView;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/3/1</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class CircleFragment extends BaseFragment
{
    private RecyclerView listView;
    private PullToRefreshView refreshLayout;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        View view=View.inflate(getActivity(), R.layout.frag_circle,null);
        listView= ViewFinder.findView(view,R.id.rl_list);
        refreshLayout=ViewFinder.findView(view,R.id.pf_refresh);
        return view;
    }

    @Override
    public void initValues(Bundle savedInstanceState)
    {
        listView.setAdapter(new TestAdapter());
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    @Override
    public void initListeners(Bundle savedInstanceState)
    {
        refreshLayout.setOnRefreshListener(new PullToRefreshView.OnRefreshListener()
        {
            @Override
            public void onRefresh()
            {
                refreshLayout.postDelayed(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        refreshLayout.setRefreshing(false);
                    }
                },2000);
            }
        });

    }
    private class TestAdapter extends RecyclerView.Adapter<TestViewHolder>
    {


        @Override
        public TestViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            TextView textview=new TextView(parent.getContext());
            return new TestViewHolder(textview);
        }

        @Override
        public void onBindViewHolder(TestViewHolder holder, int position)
        {
            TextView itemView = (TextView) holder.itemView;
            itemView.setText(position+"");
        }

        @Override
        public int getItemCount()
        {
            return 100;
        }
    }
    private class TestViewHolder extends RecyclerView.ViewHolder
    {

        public TestViewHolder(View itemView)
        {
            super(itemView);
        }
    }
}
