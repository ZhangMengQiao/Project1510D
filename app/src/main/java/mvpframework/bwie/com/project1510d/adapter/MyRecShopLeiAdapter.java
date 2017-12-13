package mvpframework.bwie.com.project1510d.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import mvpframework.bwie.com.project1510d.R;
import mvpframework.bwie.com.project1510d.bean.ShopLeiBean;

/**
 * Created by Administrator on 2017/12/13.
 */
public class MyRecShopLeiAdapter  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    List<ShopLeiBean.DataBean> list;
    public MyRecShopLeiAdapter(Context context, List<ShopLeiBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }
    //加载视图
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= View.inflate(context, R.layout.shou_lei_item,null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //获取数据
        ShopLeiBean.DataBean dataBean=list.get(position);
        MyViewHolder myViewHolder= (MyViewHolder) holder;

        ImageLoader.getInstance().displayImage(dataBean.getIcon(),myViewHolder.img);
        myViewHolder.name.setText(dataBean.getName()+"");

    }
    class MyViewHolder extends RecyclerView.ViewHolder
    {
        ImageView img;
        TextView name;
        public MyViewHolder(View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.shou_img);
            name=itemView.findViewById(R.id.shouName);
        }
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}
