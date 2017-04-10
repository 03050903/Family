package com.chen.family.cache;

import android.text.TextUtils;
import com.chen.family.model.UserModel;

/**
 * <font color='#9B77B2'>该类的主要用途:</font><br/><font color='#36FC2C'><b>
 * <p></p>
 * <b/></font><br/><hr/>
 * <b><font color='#05B8FD'>作者: C&C</font></b><br/><br/>
 * <b><font color='#05B8FD'>创建时间：2016/12/5</font></b><br/><br/>
 * <b><font color='#05B8FD'>联系方式：862530304@qq.com</font></b>
 */

public class UserInfoUtils
{
    private static final String USER_MODEL_JSON="user_model_json";
    private static final String CONFIG_FILE_NAME="user_info";
    /**
     * 实例化一个实例
     */
    private static UserInfoUtils mUserInfoUtils=new UserInfoUtils();

    private UserModel mUserModel;

    /**
     * 私有化构造函数
     */
    private UserInfoUtils()
    {
        createUserModelFromLocal();
    }
    /**
     * 获取实例
     * @return
     */
    public static UserInfoUtils getInstannce()
    {
        return mUserInfoUtils;
    }
    /**
     * 获取当前的用户
     */
    public UserModel getCurrentUser()
    {
        return mUserModel;
    }

    /**
     * 判断用户时候登录
     * @return
     */
    public boolean isLogin()
    {
        return mUserModel!=null;
    }

    /**
     * 从本地数据中创建用户的model
     */
    private void createUserModelFromLocal()
    {
        String userModelJson=PreferenceUtils.getString(CONFIG_FILE_NAME,USER_MODEL_JSON);
        if (!TextUtils.isEmpty(userModelJson))
        {
            mUserModel=UserModel.localFromJson(userModelJson);
        }

    }
    public String getString(String paramName)
    {
        return PreferenceUtils.getString(CONFIG_FILE_NAME,paramName);
    }

    /**
     * 设置当前的用户
     * @param model
     */
    public void setUserModel(UserModel model)
    {
        mUserModel=model;
        if (mUserModel!=null)
        {
            PreferenceUtils.getEditor(CONFIG_FILE_NAME).putString(USER_MODEL_JSON,mUserModel.toJson()).apply();
        }
    }

    /**
     * 用户登出
     */
    public void loginOut()
    {
        mUserModel=null;
        PreferenceUtils.getEditor(CONFIG_FILE_NAME).clear().apply();
    }

}
