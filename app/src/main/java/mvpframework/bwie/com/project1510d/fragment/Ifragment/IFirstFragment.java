package mvpframework.bwie.com.project1510d.fragment.Ifragment;

import mvpframework.bwie.com.project1510d.bean.AddBean;
import mvpframework.bwie.com.project1510d.bean.FirstBean;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface IFirstFragment {
    public  void show(FirstBean firstBean);//请求过来的商品
    public  void showCar(AddBean addBean);//添加购物车返回的数据
    public  void showLei(ShopLeiBean shopLeiBean);//请求的九宫格商品分类
}
