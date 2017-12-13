package mvpframework.bwie.com.project1510d.view;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.project1510d.R;
import mvpframework.bwie.com.project1510d.fragment.FirstFragment;
import mvpframework.bwie.com.project1510d.fragment.LoginFragment;
import mvpframework.bwie.com.project1510d.fragment.SecondFragment;
import mvpframework.bwie.com.project1510d.fragment.ShopCarFragment;
import mvpframework.bwie.com.project1510d.fragment.ThreeFragment;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener{
    private ViewPager mFragment;
    private RadioButton mAc0;
    private RadioButton mAbw;
    private RadioButton mAby;
    private RadioButton mAbu;
    private RadioButton mMyde;
    private RelativeLayout mActivityLogin;
    List<Fragment> fragments;
    //用户信息
    String uid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initView();
        /**
         * 接受登陆成功后传来的用户信息
         */
        Intent intent=getIntent();
        //捕捉异常
        try {
            uid= intent.getStringExtra("user");
        } catch (NullPointerException e)
        {
            Toast.makeText(LoginActivity.this,"未登录状态",Toast.LENGTH_SHORT).show();
        }
        //实例化list集合
        fragments=new ArrayList<>();
        FirstFragment firstFragment=new FirstFragment();
        //传值
        Bundle bundle = new Bundle();
        bundle.putString("DATA",uid+"");//这里的values就是我们要传的值
        firstFragment.setArguments(bundle);

        SecondFragment secondFragment=new SecondFragment();
        ThreeFragment threeFragment=new ThreeFragment();
        ShopCarFragment shopCarFragment=new ShopCarFragment();
        //传值

        LoginFragment loginFragment=new LoginFragment();
        //添加数据到集合
        fragments.add(firstFragment);
        fragments.add(secondFragment);
        fragments.add(threeFragment);
        fragments.add(shopCarFragment);
        fragments.add(loginFragment);
        //添加数据到集合
        mFragment.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return fragments.get(position);
            }

            @Override
            public int getCount() {
                return fragments.size();
            }
        });

    }

    private void initView() {
        mFragment = (ViewPager) findViewById(R.id.fragment);
        mAc0 = (RadioButton) findViewById(R.id.ac0);
        mAc0.setOnClickListener(this);
        mAbw = (RadioButton) findViewById(R.id.abw);
        mAbw.setOnClickListener(this);
        mAby = (RadioButton) findViewById(R.id.aby);
        mAby.setOnClickListener(this);
        mAbu = (RadioButton) findViewById(R.id.abu);
        mAbu.setOnClickListener(this);
        mMyde = (RadioButton) findViewById(R.id.myde);
        mMyde.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.ac0:
                mFragment.setCurrentItem(0);
                break;
            case R.id.abw:
                mFragment.setCurrentItem(1);
                break;
            case R.id.aby:
                mFragment.setCurrentItem(2);
                break;
            case R.id.abu:
                mFragment.setCurrentItem(3);
                break;
            case R.id.myde:
                mFragment.setCurrentItem(4);
                break;
        }
    }
}
