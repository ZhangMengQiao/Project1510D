package mvpframework.bwie.com.project1510d.fragment.Ifragment;

import mvpframework.bwie.com.project1510d.bean.ProductCatagoryBean;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;

/**
 * Created by Administrator on 2017/12/13.
 */

public interface ISecondFragment {
    public void show(ShopLeiBean shopLeiBean);
    public void showAdapter(ProductCatagoryBean productCatagoryBean);
}
