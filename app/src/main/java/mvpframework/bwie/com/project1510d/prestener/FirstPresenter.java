package mvpframework.bwie.com.project1510d.prestener;

import java.util.HashMap;
import java.util.Map;

import mvpframework.bwie.com.project1510d.bean.AddBean;
import mvpframework.bwie.com.project1510d.bean.FirstBean;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;
import mvpframework.bwie.com.project1510d.fragment.Ifragment.IFirstFragment;
import mvpframework.bwie.com.project1510d.model.FirstModle;
import mvpframework.bwie.com.project1510d.model.IModel.IFirstModle;
import mvpframework.bwie.com.project1510d.net.Api;
import mvpframework.bwie.com.project1510d.net.OnNetListener;

/**
 * Created by Administrator on 2017/12/13.
 */

public class FirstPresenter {
    IFirstModle iFirstModle;
    IFirstFragment iFirstFragment;

    public FirstPresenter(IFirstFragment iFirstFragment) {
        this.iFirstFragment = iFirstFragment;
        iFirstModle=new FirstModle();
    }
    //请求数据
    public void getFirst(){
        iFirstModle.doGet(Api.SHOWYE, new OnNetListener<FirstBean>() {
            @Override
            public void onSuccess(FirstBean firstBean) {
                iFirstFragment.show(firstBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    //请求九宫格商品
    public void getShop(){
        iFirstModle.doGetShop(Api.SHOPFEI, new OnNetListener<ShopLeiBean>() {
            @Override
            public void onSuccess(ShopLeiBean shopLeiBean) {
                iFirstFragment.showLei(shopLeiBean);
            }

            @Override
            public void onFailure(Exception e) {

            }
        });
    }
    //添加购买商品到接口
    public void AddCar(String uid,String pid){
        //创建map集合
        Map<String,String> map=new HashMap<>();
        map.put("uid",uid);
        map.put("pid",pid);
                iFirstModle.doPost(Api.ADDCAR, map, new OnNetListener<AddBean>() {
                    @Override
                    public void onSuccess(AddBean addBean) {
                        iFirstFragment.showCar(addBean);
                    }

                    @Override
                    public void onFailure(Exception e) {

                    }
                });
    }
}
