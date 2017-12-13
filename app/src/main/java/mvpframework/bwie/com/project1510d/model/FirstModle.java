package mvpframework.bwie.com.project1510d.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import mvpframework.bwie.com.project1510d.bean.AddBean;
import mvpframework.bwie.com.project1510d.bean.FirstBean;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;
import mvpframework.bwie.com.project1510d.model.IModel.IFirstModle;
import mvpframework.bwie.com.project1510d.net.OnNetListener;
import mvpframework.bwie.com.project1510d.utils.HttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/13.
 */

public class FirstModle implements IFirstModle{
    @Override
    public void doGet(String url, final OnNetListener<FirstBean> onNetListener) {
       //调用Httpuclien对象
        HttpUtils.getHttpUtils().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onNetListener.onFailure(e);//请求失败
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //解析
                FirstBean firstBean = new Gson().fromJson(response.body().string(), FirstBean.class);
                onNetListener.onSuccess(firstBean);

            }
        });
    }

    //get请求九宫格商品分类
    @Override
    public void doGetShop(String url, final OnNetListener<ShopLeiBean> netLisenter) {
        HttpUtils.getHttpUtils().doGet(url, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netLisenter.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                ShopLeiBean shopLeiBean=new Gson().fromJson(response.body().string(),ShopLeiBean.class);
                netLisenter.onSuccess(shopLeiBean);
            }
        });
    }


    @Override
    public void doPost(String uri, Map<String, String> param, final OnNetListener<AddBean> netLisenter) {
        HttpUtils.getHttpUtils().doPost(uri, param, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                netLisenter.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                AddBean addBean=new Gson().fromJson(response.body().string(),AddBean.class);
                netLisenter.onSuccess(addBean);
            }
        });
    }
}
