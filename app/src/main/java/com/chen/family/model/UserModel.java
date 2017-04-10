package com.chen.family.model;

import org.json.JSONObject;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/5</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class UserModel
{
    private String userName;
    private String userPwd;
    private String headUrl;

    public String getHeadUrl()
    {
        return headUrl;
    }

    public void setHeadUrl(String headUrl)
    {
        this.headUrl = headUrl;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getUserPwd()
    {
        return userPwd;
    }

    public void setUserPwd(String userPwd)
    {
        this.userPwd = userPwd;
    }
    /**
     * 从json中实例化一个UserModel
     */
    public static UserModel localFromJson(String json)
    {
        JSONObject jsonObject=null;
        UserModel model=null;
        try
        {
            jsonObject=new JSONObject(json);
        }catch (Exception e)
        {

        }
        if (jsonObject!=null)
        {
            model=new UserModel();
            model.setUserName(jsonObject.optString("user_name"));
            model.setUserPwd(jsonObject.optString("user_pwd"));
        }
        return model;
    }

    /**
     * 转换成Json
     * @return
     */
    public String toJson()
    {
        StringBuilder builder=new StringBuilder();
        builder.append("{\"user_name\":\"");
        builder.append(userName);
        builder.append("\",\"user_pwd\":\"");
        builder.append(userPwd);
        builder.append("\"}");
        return builder.toString();
    }
}
