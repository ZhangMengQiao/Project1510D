package mvpframework.bwie.com.project1510d.model.IModel;

import java.util.Map;

import mvpframework.bwie.com.project1510d.bean.AddBean;
import mvpframework.bwie.com.project1510d.bean.FirstBean;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;
import mvpframework.bwie.com.project1510d.net.OnNetListener;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface IFirstModle {
    //Get请求
    public void doGet(String url, OnNetListener<FirstBean> netLisenter);
    //Get请求九宫格商品分类
    public void doGetShop(String url, OnNetListener<ShopLeiBean> netLisenter);
    //Post请求
    public void doPost(String uri, Map<String,String> param,OnNetListener<AddBean> netLisenter);
}
