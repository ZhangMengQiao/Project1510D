package mvpframework.bwie.com.project1510d.fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.youth.banner.Banner;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.project1510d.R;
import mvpframework.bwie.com.project1510d.adapter.MiaoAdapter;
import mvpframework.bwie.com.project1510d.adapter.TuiAdapter;
import mvpframework.bwie.com.project1510d.bean.AddBean;
import mvpframework.bwie.com.project1510d.bean.FirstBean;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;
import mvpframework.bwie.com.project1510d.fragment.Ifragment.IFirstFragment;
import mvpframework.bwie.com.project1510d.prestener.FirstPresenter;
import mvpframework.bwie.com.project1510d.utils.GlideImageLoader;
import mvpframework.bwie.com.project1510d.view.MyView;
import mvpframework.bwie.com.project1510d.view.WebViewActivity;

/**
 * Created by Administrator on 2017/12/12.
 */
public class FirstFragment  extends Fragment implements IFirstFragment {

    private Banner banner;
    FirstPresenter presenter;
    private List<String> list;
    private View view;
    String uid;//用户id
    /**
     * 京东秒杀
     */
    private TextView mNameMiaosha;
    private GridView mMiaosha;
    /**
     * 京东推荐
     */
    private TextView mNameTuijian;
    private GridView mTuijian;
    MiaoAdapter miaoAdapter;
    TuiAdapter tuiAdapter;
    List<FirstBean.MiaoshaBean.ListBeanX> miaolist;
    List<FirstBean.TuijianBean.ListBean> tuilist;
    Appendable controlLog;
    private ImageView mSao;
    private ViewPager mPager;
    List<Fragment> fragments;
    MyView myView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmentfirst, null);
        banner = (Banner) view.findViewById(R.id.banner);
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //接收传过来的用户id
        Bundle bundle = getArguments();
        uid = bundle.getString("DATA");
        //设置图片集合
        List<String> images = new ArrayList<>();
        images.add("http://pic8.nipic.com/20100701/5290458_114840036316_2.jpg");
        images.add("http://pic2.nipic.com/20090424/1468853_230119053_2.jpg ");
        images.add("http://img3.3lian.com/2013/s1/20/d/57.jpg");
        images.add("http://pic39.nipic.com/20140226/18071023_164300608000_2.jpg");
        images.add("http://a0.att.hudong.com/15/08/300218769736132194086202411_950.jpg");
        banner.setImages(images);
        /**
         *
         */
        myView=new MyView(getActivity());
        //输入框回车事件
        myView.setEditTextOnClient(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent event) {
                String name=myView.getEditText();
                Toast.makeText(getContext(),name,Toast.LENGTH_SHORT).show();
                return event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER);
            }
        });

        //banner设置方法全部调用完毕时最后调用
        banner.start();
        initView(view);//初始化控件
        presenter = new FirstPresenter(this);
        presenter.getFirst();
        presenter.getShop();
        //点击事件
        mMiaosha.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = miaolist.get(i).getDetailUrl();
                //Intent跳转
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", str);//Intent传值
                getActivity().startActivity(intent);
            }
        });
        //长按事件
        mMiaosha.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, final int p, long l) {

                //Builde弹框
                AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                builder.setTitle("是否加入购物车")
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                presenter.AddCar(uid, miaolist.get(p).getPid() + "");
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                    }
                });

                //显示对话框
                AlertDialog dialog = builder.create();
                dialog.show();
                return true;
            }
        });
        //点击事件
        mTuijian.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String str = tuilist.get(i).getDetailUrl();
                //Intent跳转
                Intent intent = new Intent(getActivity(), WebViewActivity.class);
                intent.putExtra("url", str);//Intent传值
                getActivity().startActivity(intent);
            }
        });
        return view;
    }

    private void initView(View view) {
        mNameMiaosha = (TextView) view.findViewById(R.id.name_miaosha);
        mMiaosha = (GridView) view.findViewById(R.id.miaosha);
        mNameTuijian = (TextView) view.findViewById(R.id.name_tuijian);
        mTuijian = (GridView) view.findViewById(R.id.tuijian);
        mSao = (ImageView) view.findViewById(R.id.sao);
        mSao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
           //     onScanQR();//扫码

            }
        });
        mPager = (ViewPager) view.findViewById(R.id.pag);

    }

    /*{public void onScanQR()
        QRCodeManager.getInstance()
                .with(getActivity())
                .setReqeustType(1)//可以不设置，默认是0
                .scanningQRCode(new OnQRCodeScanCallback() {
                    @Override
                    public void onCompleted(String result) {//扫描成功之后回调，result就是扫描的结果

                        try {
                            controlLog.append("\n\n(结果)" + result);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onError(Throwable errorMsg) {//扫描出错的时候回调
                        try {
                            controlLog.append("\n\n(错误)" + errorMsg.toString());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }

                    @Override
                    public void onCancel() {//取消扫描的时候回调
                        try {
                            controlLog.append("\n\n(取消)扫描任务取消了");
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
    }
*/
    @Override
    public void show(final FirstBean firstBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                miaolist = firstBean.getMiaosha().getList();
                //实例化适配器
                miaoAdapter = new MiaoAdapter(miaolist, getActivity());
                mMiaosha.setAdapter(miaoAdapter);

                tuilist = firstBean.getTuijian().getList();
                tuiAdapter = new TuiAdapter(tuilist, getActivity());
                mTuijian.setAdapter(tuiAdapter);
            }
        });
    }

    /**
     * 添加购物车返回的数据
     *
     * @param addBean
     */
    @Override
    public void showCar(final AddBean addBean) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getActivity(), addBean.getMsg(), Toast.LENGTH_LONG).show();
            }
        });
    }

    /**
     * 请求回来的九宫格商品分类
     * @param shopLeiBean
     */
    @Override
    public void showLei(final ShopLeiBean shopLeiBean)
    {
        //切换到主线程
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //初始化适配器
                 /*MyRecShopLeiAdapter myRecShopLeiAdapter=new MyRecShopLeiAdapter(getActivity(),shopLeiBean.getData());
                 mRecs.setAdapter(myRecShopLeiAdapter);*/
                Frag01 frag01=new Frag01();
                frag01.setBean(shopLeiBean);

                Frag02 frag02=new Frag02();
                frag02.setBean(shopLeiBean);
                fragments=new ArrayList<>();
                fragments.add(frag01);
                fragments.add(frag02);
                mPager.setAdapter(new FragmentPagerAdapter(getActivity().getSupportFragmentManager()) {
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
        });

    }
}
