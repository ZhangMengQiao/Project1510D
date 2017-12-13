package mvpframework.bwie.com.project1510d.model.IModel;

import java.util.Map;

import mvpframework.bwie.com.project1510d.bean.LoginBean;
import mvpframework.bwie.com.project1510d.bean.RegBean;
import mvpframework.bwie.com.project1510d.net.OnNetListener;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface IMainModle {
    //Post请求注册
    public void PostReg(String url, Map<String,String> param, OnNetListener<RegBean> onNetListener);

    //Post请求登陆
    public void PostLogin(String url, Map<String,String> param, OnNetListener<LoginBean> onNetListener);
}
