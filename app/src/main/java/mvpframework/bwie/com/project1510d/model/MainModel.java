package mvpframework.bwie.com.project1510d.model;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import mvpframework.bwie.com.project1510d.bean.LoginBean;
import mvpframework.bwie.com.project1510d.bean.RegBean;
import mvpframework.bwie.com.project1510d.model.IModel.IMainModle;
import mvpframework.bwie.com.project1510d.net.OnNetListener;
import mvpframework.bwie.com.project1510d.utils.HttpUtils;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

/**
 * Created by Administrator on 2017/12/12.
 */

public class MainModel implements IMainModle {
    //post注册
    @Override
    public void PostReg(String url, Map<String, String> param, final OnNetListener<RegBean> onNetListener) {
        HttpUtils.getHttpUtils().doPost(url, param, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onNetListener.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //解析gson传
                RegBean regBean = new Gson().fromJson(response.body().string(), RegBean.class);
                onNetListener.onSuccess(regBean);
            }
        });
    }

    //post登陆
    @Override
    public void PostLogin(String url, Map<String, String> param, final OnNetListener<LoginBean> onNetListener) {
        HttpUtils.getHttpUtils().doPost(url, param, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                onNetListener.onFailure(e);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                //解析
                LoginBean loginBean = new Gson().fromJson(response.body().string(), LoginBean.class);
                onNetListener.onSuccess(loginBean);
            }
        });
    }
}
