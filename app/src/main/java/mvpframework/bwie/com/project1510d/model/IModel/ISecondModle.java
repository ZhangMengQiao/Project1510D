package mvpframework.bwie.com.project1510d.model.IModel;

import java.util.Map;

import mvpframework.bwie.com.project1510d.bean.ProductCatagoryBean;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;
import mvpframework.bwie.com.project1510d.net.OnNetListener;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface ISecondModle {
    public void doGet(OnNetListener<ShopLeiBean> onNetListener);
    public void doPost(String url, Map<String,String> params, OnNetListener<ProductCatagoryBean> productCatagoryBeanOnNetListener);
}
