package mvpframework.bwie.com.project1510d.utils;

import java.util.Map;

import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/**
 * Created by Administrator on 2017/12/12.
 */

public class HttpUtils {
    private static HttpUtils httpUtils;
    private OkHttpClient okHttpClient;
     /* public HttpUtils() {
        //创建拦截器
       *//* HttpLoggingInterceptor logging=new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);*//*
        //创建OkHttpClient对象
        okHttpClient=new OkHttpClient.Builder().
                addInterceptor(new MyInterceptor()).build();

    }*/
     public static HttpUtils getHttpUtils()
     {
         if(httpUtils==null)
         {
             synchronized (HttpUtils.class)
             {
                 if(httpUtils==null)
                 {
                     httpUtils=new HttpUtils();
                 }
             }
         }
         return httpUtils;
     }
    //Post请求
    public void doPost(String url, Map<String,String> param, Callback callback)
    {
        okHttpClient=new OkHttpClient.Builder().
                addInterceptor(new MyInterceptor()).build();
        //创建FormBody.Builder
        FormBody.Builder builder=new FormBody.Builder();
        for(Map.Entry<String,String> entry:param.entrySet())
        {
            builder.add(entry.getKey(),entry.getValue());
        }
        FormBody formBody=builder.build();
        Request request=new Request.Builder().url(url).post(formBody).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
    //Get请求
    public void doGet(String url,Callback callback)
    {
        okHttpClient=new OkHttpClient();
        //创建Request对象
        Request request=new Request.Builder().url(url).build();
        okHttpClient.newCall(request).enqueue(callback);
    }
}
