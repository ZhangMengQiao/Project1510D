package mvpframework.bwie.com.project1510d.prestener;

import android.content.Context;
import android.text.TextUtils;
import android.widget.Toast;

import java.util.HashMap;
import java.util.Map;

import mvpframework.bwie.com.project1510d.MainActivity;
import mvpframework.bwie.com.project1510d.bean.LoginBean;
import mvpframework.bwie.com.project1510d.bean.RegBean;
import mvpframework.bwie.com.project1510d.model.IModel.IMainModle;
import mvpframework.bwie.com.project1510d.model.MainModel;
import mvpframework.bwie.com.project1510d.net.Api;
import mvpframework.bwie.com.project1510d.net.OnNetListener;
import mvpframework.bwie.com.project1510d.view.IMainActivity;
import mvpframework.bwie.com.project1510d.view.IRegisterActivity;

/**
 * Created by Administrator on 2017/12/12.
 */

public class MainPresenter {
    private IMainModle iMainModle;
    //注册接口
    private IRegisterActivity iRegisterActivity;
    private IMainActivity iMainActivity;
    private Context context;

    public MainPresenter(IRegisterActivity iRegisterActivity, Context context) {
        this.iRegisterActivity = iRegisterActivity;
        this.context = context;
        iMainModle=new MainModel();
    }

    public MainPresenter(IMainActivity iMainActivity, Context context) {
        this.iMainActivity = iMainActivity;
        this.context = context;
        iMainModle=new MainModel();
    }
    //post注册
    public void doPost(){
        Map<String,String> params=new HashMap<>();
        String phone = iRegisterActivity.getPhone();
        String pwd = iRegisterActivity.getPwd();
        boolean b=isPhone(phone,pwd);
        if(b){
            params.put("mobile",phone);
            params.put("password",pwd);
            iMainModle.PostReg(Api.REGISTER, params, new OnNetListener<RegBean>() {
                @Override
                public void onSuccess(RegBean regBean) {
                    iRegisterActivity.show(regBean);
                }

                @Override
                public void onFailure(Exception e) {

                }
            });
        }
    }
    //Post登陆
    public void PostLogin()
    {
        Map<String,String> param=new HashMap<>();
        //
        String phone = iMainActivity.getPhone();
        String pwd = iMainActivity.getPwd();
        boolean b=isPhone(phone,pwd);
        if(b)
        {
            param.put("mobile",phone);
            param.put("password",pwd);
            iMainModle.PostLogin(Api.LOGIN, param, new OnNetListener<LoginBean>() {


                @Override
                public void onSuccess(LoginBean loginBean) {
                    iMainActivity.show(loginBean);
                }

                @Override
                public void onFailure(Exception e) {

                }
            });
        }
    }

    private boolean isPhone(String phone, String pwd) {
        if(TextUtils.isEmpty(phone)||TextUtils.isEmpty(pwd)){
            Toast.makeText(context,"用户名或密码不能为空",Toast.LENGTH_LONG).show();
            return false;
        }else if(phone=="^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$"){
            Toast.makeText(context,"手机号格式不正确",Toast.LENGTH_LONG).show();
            return false;
        }
        return true;
    }
}
