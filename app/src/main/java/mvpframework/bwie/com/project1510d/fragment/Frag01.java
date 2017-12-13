package mvpframework.bwie.com.project1510d.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import mvpframework.bwie.com.project1510d.R;
import mvpframework.bwie.com.project1510d.adapter.MyRecShopLeiAdapter;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;

/**
 * Created by Administrator on 2017/12/13.
 */

public class Frag01 extends Fragment {

    ShopLeiBean shopLeiBean;
    private View view;
    private RecyclerView mMrc;
    List<ShopLeiBean.DataBean> list;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = View.inflate(getContext(), R.layout.rc_item, null);
        initView(view);
        mMrc.setLayoutManager(new GridLayoutManager(getActivity(),5));
        list=new ArrayList<>();
        for(int i=0;i<10 ;i++)
        {
            list.add(shopLeiBean.getData().get(i));
        }
        MyRecShopLeiAdapter myRecShopLeiAdapter=new MyRecShopLeiAdapter(getActivity(),list);
        mMrc.setAdapter(myRecShopLeiAdapter);
        return view;
    }

    public void setBean(ShopLeiBean leiBean) {
        shopLeiBean = leiBean;
    }

    private void initView(View view) {
        mMrc = (RecyclerView) view.findViewById(R.id.mrc);
    }
}
