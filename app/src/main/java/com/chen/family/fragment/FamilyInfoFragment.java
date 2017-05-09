package com.chen.family.fragment;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.chen.family.R;
import com.chen.family.utils.DLog;
import com.chen.family.utils.ViewFinder;
import com.chen.family.view.NestedWebView;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2017/4/10</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class FamilyInfoFragment extends BaseFragment
{
    private WebView webView;
//    private NestedWebView webView;
    @Override
    public View initView(Bundle savedInstanceState)
    {
        DLog.i("开始执行0000");
        View view=View.inflate(getActivity(), R.layout.frag_family_info,null);
        webView= ViewFinder.findView(view,R.id.webView);
        return view;
    }

    @Override
    public void initValues(Bundle savedInstanceState)
    {
        initWebView(webView);
        webView.loadUrl("https://www.baidu.com");
    }

    @Override
    public void initListeners(Bundle savedInstanceState)
    {

    }
    private void initWebView(WebView webView)
    {
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(false);
        settings.setAppCacheEnabled(false);
    }
}
