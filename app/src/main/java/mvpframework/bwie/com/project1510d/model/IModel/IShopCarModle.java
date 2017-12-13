package mvpframework.bwie.com.project1510d.model.IModel;

import java.util.Map;

import mvpframework.bwie.com.project1510d.bean.ShopCarBean;
import mvpframework.bwie.com.project1510d.net.OnNetListener;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface IShopCarModle {
    //Post请求
    public void doPost(String uri, Map<String,String> param, OnNetListener<ShopCarBean> onNetListener);
    //Post请求删除购物车商品
    public void postDel(String uri,Map<String,String> param);
}
