package mvpframework.bwie.com.project1510d.net;

/**
 * Created by Administrator on 2017/12/12.
 */

public interface Api {
    public static boolean isOnline=false;

    public static final String DEV="http://120.27.23.105/";
    public static  final String WORK="";
    public  static  final String HOST=isOnline?WORK:DEV;

    public static final String LOGIN = HOST + "user/login";//登陆
    public static final String REGISTER = HOST + "user/reg";//注册
    public static final String SHOPFEI=HOST+"product/getCatagory";//商品分类
    public static final String PRODUCT_CATAGORY = HOST + "product/getProductCatagory";//商品子分类接口
    public static final String SHOWYE=HOST+"ad/getAd";//轮播图+京东秒杀+最底部的为你推荐
    public static final String ADDCAR=HOST+"product/addCart";//添加购物车的接口
    public static final String SHOECAR=HOST+"product/getCarts";//查询购物车的接口
    public static final String DELETECAR=HOST+"product/deleteCart";//删除购物车商品的接口
    public static final String SOUSUO=HOST+"product/searchProducts";//实现搜索功能的接口
}
