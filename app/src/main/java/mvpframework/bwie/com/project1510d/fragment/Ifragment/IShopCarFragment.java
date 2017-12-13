package mvpframework.bwie.com.project1510d.fragment.Ifragment;

import mvpframework.bwie.com.project1510d.bean.ShopCarBean;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface IShopCarFragment {
    public void show(ShopCarBean shopCarBean);
    public  void isAllCheck(boolean b);
    public void isAllPrice();//计算商品总量和价格的方法
}
