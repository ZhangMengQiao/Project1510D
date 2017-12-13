package mvpframework.bwie.com.project1510d.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import mvpframework.bwie.com.project1510d.MainActivity;
import mvpframework.bwie.com.project1510d.R;
import mvpframework.bwie.com.project1510d.bean.RegBean;
import mvpframework.bwie.com.project1510d.prestener.MainPresenter;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener,IRegisterActivity {
    private ImageView mIvBack;
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
     * 注册
     */
    private Button mBtLogin;
    private LinearLayout mActivityRegister;
    MainPresenter mainPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        mainPresenter=new MainPresenter(this,this);
        initView();
    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mEtPhone = (EditText) findViewById(R.id.et_phone);
        mEtPwd = (EditText) findViewById(R.id.et_pwd);
        mIvPwd = (ImageView) findViewById(R.id.iv_pwd);
        mBtLogin = (Button) findViewById(R.id.bt_login);
        mBtLogin.setOnClickListener(this);
        mActivityRegister = (LinearLayout) findViewById(R.id.activity_register);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_login:
                mainPresenter.doPost();
                break;
            case R.id.iv_back:
                Intent intent=new Intent(RegisterActivity.this,MainActivity.class);
                startActivity(intent);
                break;
        }
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
    public void show(final RegBean regBean) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(RegisterActivity.this,regBean.getMsg(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
