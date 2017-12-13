package mvpframework.bwie.com.project1510d;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import mvpframework.bwie.com.project1510d.bean.LoginBean;
import mvpframework.bwie.com.project1510d.prestener.MainPresenter;
import mvpframework.bwie.com.project1510d.view.IMainActivity;
import mvpframework.bwie.com.project1510d.view.LoginActivity;
import mvpframework.bwie.com.project1510d.view.RegisterActivity;

public class MainActivity extends AppCompatActivity implements  View.OnClickListener,IMainActivity{

    /**
     * 手机号
     */
    private EditText mEtPhone;
    /**
     * 请输入密码
     */
    private EditText mEtPwd;
    private ImageView mIvPwd;
    /**
     * 登陆
     */
    private Button mBtLogin;
    /**
     * 请注册
     */
    private TextView mTvRegister;

    /**
     * QQ分享
     */
    private  ImageView imageView;
    private  ImageView loginQQ;
    private LinearLayout mActivityMain;
    private MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mainPresenter=new MainPresenter(this,this);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        imageView= (ImageView) findViewById(R.id.imgqq);
        imageView.setOnClickListener(this);
        loginQQ= (ImageView) findViewById(R.id.loginqq);
        loginQQ.setOnClickListener(this);
        mIvPwd = (ImageView) findViewById(R.id.iv_pwd);
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mTvRegister = (TextView) findViewById(R.id.tv_register);
        mTvRegister.setOnClickListener(this);
        mActivityMain = (LinearLayout) findViewById(R.id.activity_main);
    }

    @Override
    public String getPhone() {
        return mEtPhone.getText().toString().trim();
    }

    @Override
    public String getPwd() {
        return mEtPwd.getText().toString().trim();
    }

    @Override
    public void show(final LoginBean loginBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this,loginBean.getMsg(),Toast.LENGTH_LONG).show();
                if(loginBean.getMsg().equals("登录成功"))
                {
                    //跳转到登陆成功页面
                    Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                    intent.putExtra("user",loginBean.getData().getUid()+"");
                    startActivity(intent);
                }
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_login:
                //登陆判断
                mainPresenter.PostLogin();
                break;
            case R.id.tv_register:
                //跳转到注册页面
                Intent intent=new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                break;
        }
    }
}
