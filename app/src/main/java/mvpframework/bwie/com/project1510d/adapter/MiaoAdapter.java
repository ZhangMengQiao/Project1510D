package mvpframework.bwie.com.project1510d.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import mvpframework.bwie.com.project1510d.R;
import mvpframework.bwie.com.project1510d.bean.FirstBean;

/**
 * Created by Administrator on 2017/12/13.
 */
public class MiaoAdapter extends BaseAdapter{
    private List<FirstBean.MiaoshaBean.ListBeanX> list;
    Context context;

    public MiaoAdapter(List<FirstBean.MiaoshaBean.ListBeanX> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    class  ViewHolder{
        TextView name;
        TextView content;
        ImageView img1;
    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view==null){
            view=View.inflate(context, R.layout.item_miao,null);
            holder=new ViewHolder();
            holder.name=view.findViewById(R.id.miao_name);
            holder.content=view.findViewById(R.id.miao_conect);
            holder.img1=view.findViewById(R.id.miao_img1);
            view.setTag(holder);
        }else{
            holder= (ViewHolder) view.getTag();
        }
        FirstBean.MiaoshaBean.ListBeanX listBeanX = list.get(position);
        holder.name.setText(listBeanX.getTitle());
        holder.content.setText("￥"+listBeanX.getPrice());
        String[] str=listBeanX.getImages().split("\\|");
        ImageLoader.getInstance().displayImage(str[0],holder.img1);
        return view;
    }
}
